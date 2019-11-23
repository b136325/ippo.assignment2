package ippo.assignment2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class HeaderController implements Initializable {

    @FXML
    private Button basketButton;

    public Button getButton() {
        return this.basketButton;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void pressHeaderButton(ActionEvent event) {
        basketButton.setText("Clicked");
    }
}
