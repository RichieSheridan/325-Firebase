package aydin.firebasedemo;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {

    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private void signInButtonClicked() throws IOException {
        String name = nameTextField.getText();
        String password = passwordTextField.getText();

        ApiFuture<QuerySnapshot> future = DemoApp.fstore.collection("Persons")
                .whereEqualTo("Name", name)
                .whereEqualTo("Password", password)
                .get();

        try {
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            if (!documents.isEmpty()) {

                System.out.println("Successful login! Welcome!");

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Sign-In Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid name or password.");
                alert.showAndWait();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
