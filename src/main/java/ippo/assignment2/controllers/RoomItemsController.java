package ippo.assignment2.controllers;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.models.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * An Observer controller for RoomItemsViewer.fxml.
 *
 * @since 0.2.1
 */
public class RoomItemsController extends AbstractObserverController implements IController {

    /**
     * A reference to the counter TextField (defined within RoomItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private TextField counter;

    /**
     * A reference to the imageViewer (defined within RoomItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private ImageView imageViewer;

    /**
     * A reference to the pickUpButton (defined within RoomItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button pickUpButton;

    /**
     * 'Pick up' one of the room's items.
     *
     * @param actionEvent The event associated with the button click.
     *
     * @since 0.2.6
     */
    @FXML
    public void pickUp(ActionEvent actionEvent) {
        //@TODO this.player.pickUp();
    }

    /**
     * Update the view following a change to the model.
     *
     * @since 0.2.1
     */
    @Override
    public void updateView() {
        ItemsCollection items = null;
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
