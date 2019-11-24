package ippo.assignment2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @since 0.1.2
 */
public class HeaderController {

    @FXML
    private Button pickUpButton;

    @FXML
    private Button putDownButton;

    /**
     *
     * @param event
     * @since 0.1.3
     */
    public void pickUp(ActionEvent event) {
        this.pickUpButton.setText("Clicked");
    }

    /**
     *
     * @param event
     * @since 0.1.3
     */
    public void putDown(ActionEvent event) {
        this.putDownButton.setText("Clicked");
    }

}
