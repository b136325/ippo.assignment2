package ippo.assignment2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * @since 0.1.2
 */
public class ImageController {

    @FXML
    private Button imageButton;

    /**
     *
     * @param event
     * @since 0.1.2
     */
    public void pressImageButton(ActionEvent event) {
        imageButton.setText("Clicked");
    }
}
