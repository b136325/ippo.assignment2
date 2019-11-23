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
public class NavigationController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Button forwardButton;

    @FXML
    private Button leftButton;

    @FXML
    private Button rightButton;

    /**
     *
     * @param url
     * @param resourceBundle
     * @since 0.1.3
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * @since 0.1.3
     */
    @FXML
    public void goBack() {
        this.backButton.setText("Back - Clicked");
    }

    /**
     * @since 0.1.3
     */
    @FXML
    public void goForward() {
        this.forwardButton.setText("Forward - Clicked");
    }

    /**
     * @since 0.1.2
     */
    @FXML
    public void turnLeft() {
        this.leftButton.setText("Left - Clicked");
    }

    /**
     * @since 0.1.3
     */
    @FXML
    public void turnRight() {
        this.rightButton.setText("Right - Clicked");
    }
}
