package ippo.assignment2.controllers;

import ippo.assignment2.collections.Items;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.util.Observable;

/**
 * An Observer controller for RoomItemsViewer.fxml.
 * @since 0.2.1
 */
public class RoomItemsController extends AbstractObserverController implements IController {

    @FXML
    private TextField counter;

    @FXML
    private ImageView imageViewer;

    @FXML
    private Button pickUpButton;

    /**
     * @since 0.2.6
     */
    @FXML
    public void pickUp() {
        //this.player.pickUp();
    }

    /**
     * @since 0.2.1
     */
    @Override
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
