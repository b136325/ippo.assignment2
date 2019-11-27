package ippo.assignment2.controllers;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.models.Item;
import ippo.assignment2.models.Room;
import ippo.assignment2.utils.ActionEventHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

/**
 * An Observer controller for RoomItemsViewer.fxml.
 *
 * @since 0.2.1
 */
public class RoomItemsController extends AbstractObserverController implements IController {

    /**
     * A reference to the counter Label (defined within RoomItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Label counter;

    /**
     * A reference to imageViewer1 (defined within RoomItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private ImageView imageViewer1;

    /**
     * A reference to imageViewer2 (defined within RoomItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private ImageView imageViewer2;

    /**
     * A reference to imageViewer3 (defined within RoomItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private ImageView imageViewer3;

    /**
     * A reference to imageViewer4 (defined within RoomItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private ImageView imageViewer4;

    /**
     * A reference to pickUpButton1 (defined within RoomItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button pickUpButton1;

    /**
     * A reference to pickUpButton2 (defined within RoomItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button pickUpButton2;

    /**
     * A reference to pickUpButton3 (defined within RoomItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button pickUpButton3;

    /**
     * A reference to pickUpButton4 (defined within RoomItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button pickUpButton4;

    /**
     * 'Pick up' one of the room's items.
     *
     * @param actionEvent The event associated with the button click.
     *
     * @since 0.2.6
     */
    @FXML
    public void pickUp(ActionEvent actionEvent) {

        // Derive the index of the item to be
        // 'picked up' from the received actionEvent.
        Integer itemIndex = ActionEventHelper.deriveItemIndex(actionEvent);

        // Find the item by index.
        Item item = this.player.getRoom().getItems().get(itemIndex);
        this.player.pickUp(item);
    }

    /**
     * Update the view following a change to the model.
     *
     * @since 0.3.5
     */
    @Override
    public void updateView() {
        Room room = null;
        ItemsCollection roomItems = null;

        room = this.player.getRoom();
        if (room == null) {
            return;
        }

        roomItems = room.getItems();
        if (roomItems == null) {
            return;
        }

        this.updateCounter(roomItems);

        ArrayList<ImageView> imageViewers = this.getImageViewers();
        this.updateImageViewers(roomItems, imageViewers);

        ArrayList<Button>  pickUpButtons = this.getPickUpButtons();
        this.updatePickUpButtonsDisability(roomItems, pickUpButtons);
    }

    /**
     * Construct a list of the 'pick up' buttons
     * associated with this controller.
     *
     * @return A list of buttons.
     *
     * @since 0.3.5
     */
    private ArrayList<Button>  getPickUpButtons() {
        ArrayList<Button>  pickUpButtons = new ArrayList<Button> ();
        pickUpButtons.add(this.pickUpButton1);
        pickUpButtons.add( this.pickUpButton2);
        pickUpButtons.add(this.pickUpButton3);
        pickUpButtons.add(this.pickUpButton4);

        return pickUpButtons;
    }

    /**
     * Construct a list of the child image viewers
     * associated with this controller.
     *
     * @return A list of child image viewers.
     *
     * @since 0.3.5
     */
    private ArrayList<ImageView>  getImageViewers() {
        ArrayList<ImageView>  imageViewers = new ArrayList<ImageView> ();
        imageViewers.add(this.imageViewer1);
        imageViewers.add( this.imageViewer2);
        imageViewers.add(this.imageViewer3);
        imageViewers.add(this.imageViewer4);

        return imageViewers;
    }

    /**
     * Update the visible counter with the current number of room items.
     *
     * @param roomItems A collection of room Item objects.
     *
     * @since 0.3.3
     */
    private void updateCounter(ItemsCollection roomItems) {
        String counterValue = (roomItems == null ? "0" : roomItems.count().toString());
        this.counter.setText(counterValue);
    }

    /**
     * This method updates each imageViewer with the associated (by index)
     * Item object image.
     *
     * @param roomItems A collection of room Item objects.
     * @param imageViewers A list of the imageViewers associated with this controller.
     *
     * @since 0.3.3
     */
    private void updateImageViewers(ItemsCollection roomItems, ArrayList<ImageView> imageViewers) {
        if (roomItems == null || imageViewers == null) {
            return;
        }

        for (Integer i = 0; i < imageViewers.size(); i++) {
            ImageView imageViewer = imageViewers.get(i);
            Item roomItem = roomItems.get(i);

            if (roomItem != null && roomItem.getImage() != null) {
                imageViewer.setImage(roomItem.getImage());
            } else {
                imageViewer.setImage(null);
            }
        }
    }

    /**
     * This method determines whether or not a 'pick up' button is disabled
     * based upon whether or not the associated (by index) Item object
     * is valid and contains an image. If the Item object is valid the
     * associated button will not be disabled. Otherwise it will be.
     *
     * @param roomItems A collection of room Item objects.
     * @param pickUpButtons A list of the 'pick up' buttons.
     *
     * @since 0.3.3
     */
    private void updatePickUpButtonsDisability(ItemsCollection roomItems, ArrayList<Button> pickUpButtons) {
        if (roomItems == null || pickUpButtons == null) {
            return;
        }

        for (Integer i = 0; i < pickUpButtons.size(); i++) {
            Button pickUpButton = pickUpButtons.get(i);
            Item roomItem = roomItems.get(i);

            Boolean isDisabled = (roomItem == null || roomItem.getImage() == null);
            pickUpButton.setDisable(isDisabled);
        }
    }
}
