package ippo.assignment2.controllers;

import ippo.assignment2.collections.Items;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.PlayerObservable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

/**
 * @since 0.2.1
 */
public class RoomItemsObserverController extends BaseController implements Observer, Initializable {

    @FXML
    private ImageView imageViewer;

    @FXML
    private TextField counter;

    /**
     *
     * @param location
     * @param resources
     * @since 0.2.1
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

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
     * @since 0.2.1
     */
    public void updateView() {
        Items items = this.player.getRoom().getItems();
        if (items != null) {
            this.counter.setText(items.count().toString());
        }
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
}
