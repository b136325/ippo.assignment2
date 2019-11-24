package ippo.assignment2.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import ippo.assignment2.collections.Items;
import ippo.assignment2.models.PlayerObservable;

/**
 * @since 0.2.1
 */
public class PlayerItemsObserverController extends BaseController implements Observer, Initializable {

    @FXML
    private TextField counter;

    @FXML
    private ImageView imageViewer;

    @FXML
    private Button putDownButton;

    /**
     *
     * @param location
     * @param resources
     * @since 0.2.1
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML
    public void putDown() {
        //this.player.putDown();
    }

    /**
     *
     * @param player
     * @since 0.2.1
     */
    @Override
    public void setPlayer(PlayerObservable player) {
        super.setPlayer(player);
        this.updateView();
    }

    /**
     *
     * @param o
     * @param arg
     * @since 0.2.1
     */
    @Override
    public void update(Observable o, Object arg) {
        PlayerObservable player = (PlayerObservable)o;
        this.setPlayer(player);
    }

    /**
     * @since 0.2.1
     */
    public void updateView() {
        Items items = this.player.getItems();
        this.counter.setText(items.count().toString());
    }
}
