package ippo.assignment2.controllers;

import ippo.assignment2.models.PlayerObservable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

/**
 * @since 0.1.2
 */
public class HeaderObserverController extends BaseController implements Observer, Initializable {

    @FXML
    private Button pickUpButton;

    @FXML
    private Button putDownButton;

    /**
     *
     * @param location
     * @param resources
     * @since 0.2.0
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

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

    @Override
    public void update(Observable o, Object arg) {
        PlayerObservable player = (PlayerObservable)o;
        this.setPlayer(player);
    }
}
