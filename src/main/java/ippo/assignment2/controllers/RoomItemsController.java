package ippo.assignment2.controllers;

import ippo.assignment2.collections.Items;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

/**
 * @since 0.2.1
 */
public class RoomItemsController extends BaseController implements Observer, Initializable {

    @FXML
    private TextField counter;

    @FXML
    private ImageView imageViewer;

    @FXML
    private Button pickUpButton;

    /**
     *
     * @param location
     * @param resources
     * @since 0.2.1
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    /**
     * @since 0.2.6
     */
    @FXML
    public void pickUp() {
        //this.player.pickUp();
    }

    /**
     *
     * @param player
     * @since 0.2.1
     */
    @Override
    public void setPlayer(Player player) {
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
        Player player = (Player)o;
        this.setPlayer(player);
    }

    /**
     * @since 0.2.1
     */
    public void updateView() {
        Items items = null;
        Room room = null;

        room = this.player.getRoom();

        if (room != null) {
            items = room.getItems();
        }

        if (items != null) {
            this.counter.setText(items.count().toString());
        }
    }
}
