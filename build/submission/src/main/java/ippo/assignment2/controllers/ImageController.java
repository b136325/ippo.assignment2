package ippo.assignment2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ImageController {

    @FXML
    private Button imageButton;

    public Button getButton() {
        return this.imageButton;
    }

    public void pressImageButton(ActionEvent event) {
        imageButton.setText("Clicked");
    }
}
