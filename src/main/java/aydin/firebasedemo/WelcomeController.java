package aydin.firebasedemo;

import java.io.IOException;
import javafx.fxml.FXML;

public class WelcomeController {

    @FXML
    private void registerButtonClicked() throws IOException {
        DemoApp.setRoot("primary");
    }

    @FXML
    private void signInButtonClicked() throws IOException {
        DemoApp.setRoot("signin");
    }
}
