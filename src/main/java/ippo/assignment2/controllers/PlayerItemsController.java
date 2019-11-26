package ippo.assignment2.controllers;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.utils.ActionEventHelper;
import ippo.assignment2.models.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.util.*;

/**
 * An Observer controller for PlayerItemsViewer.fxml.
 *
 * @since 0.2.1
 */
public class PlayerItemsController extends AbstractObserverController implements IController {

    /**
     * A reference to the counter Label (defined within PlayerItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Label counter;

    /**
     * A reference to imageViewer1 (defined within PlayerItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private ImageView imageViewer1;

    /**
     * A reference to imageViewer2 (defined within PlayerItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private ImageView imageViewer2;

    /**
     * A reference to imageViewer3 (defined within PlayerItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private ImageView imageViewer3;

    /**
     * A reference to imageViewer4 (defined within PlayerItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private ImageView imageViewer4;

    /**
     * A reference to putDownButton1 (defined within PlayerItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button putDownButton1;

    /**
     * A reference to putDownButton2 (defined within PlayerItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button putDownButton2;

    /**
     * A reference to putDownButton3 (defined within PlayerItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button putDownButton3;

    /**
     * A reference to putDownButton4 (defined within PlayerItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button putDownButton4;

    /**
     * 'Put down' one of the player's items.
     * This method is the 'click handler' for
     * each of the 'putDownButton*' buttons.
     *
     * @param actionEvent The event associated with the button click.
     *
     * @since 0.2.3
     */
    @FXML
    public void putDown(ActionEvent actionEvent) {

        // Derive the index of the item to be
        // 'put down' from the received actionEvent.
        Integer itemIndex = ActionEventHelper.deriveItemIndex(actionEvent);

        // Find the item by index.
        Item item = this.player.getItems().get(itemIndex);
        this.player.putDown(item);
    }

    /**
     * Update the view following a change to the model.
     *
     * @since 0.2.1
     */
    @Override
    public void updateView() {
        ItemsCollection playerItems = this.player.getItems();
        this.updateCounter(playerItems);

        ArrayList<ImageView> imageViewers = this.getImageViewers();
        this.updateImageViewers(playerItems, imageViewers);

        ArrayList<Button>  putDownButtons = this.getPutDownButtons();
        this.updatePutDownButtonsDisability(playerItems, putDownButtons);
    }

    /**
     * Construct a list of the 'put down' buttons
     * associated with this controller.
     *
     * @return A list of buttons.
     *
     * @since 0.3.3
     */
    private ArrayList<Button>  getPutDownButtons() {
        ArrayList<Button>  putDownButtons = new ArrayList<Button> ();
        putDownButtons.add(this.putDownButton1);
        putDownButtons.add( this.putDownButton2);
        putDownButtons.add(this.putDownButton3);
        putDownButtons.add(this.putDownButton4);

        return putDownButtons;
    }

    /**
     * Construct a list of the child image viewers
     * associated with this controller.
     *
     * @return A list of child image viewers.
     *
     * @since 0.2.7
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
     * Update the visible counter with the current number of player items.
     *
     * @param playerItems A collection of the player's Item objects.
     *
     * @since 0.3.3
     */
    private void updateCounter(ItemsCollection playerItems) {
        String counterValue = (playerItems == null ? "0" : playerItems.count().toString());
        this.counter.setText(counterValue);
    }

    /**
     * This method updates each imageViewer with the associated (by index)
     * Item object image.
     *
     * @param playerItems A collection of the player's Item objects.
     * @param imageViewers A list of the imageViewers associated with this controller.
     *
     * @since 0.3.3
     */
    private void updateImageViewers(ItemsCollection playerItems, ArrayList<ImageView> imageViewers) {
        if (playerItems == null || imageViewers == null) {
            return;
        }

        for (Integer i = 0; i < imageViewers.size(); i++) {
            ImageView imageViewer = imageViewers.get(i);
            Item playerItem = playerItems.get(i);

            if (playerItem != null && playerItem.getImage() != null) {
                imageViewer.setImage(playerItem.getImage());
            } else {
                imageViewer.setImage(null);
            }
        }
    }

    /**
     * This method determines whether or not a 'put down' button is disabled
     * based upon whether or not the associated (by index) Item object
     * is valid and contains an image. If the Item object is valid the
     * associated button will not be disabled. Otherwise it will be.
     *
     * @param playerItems A collection of the player's Item objects.
     * @param putDownButtons A list of the 'put down' buttons.
     *
     * @since 0.3.3
     */
    private void updatePutDownButtonsDisability(ItemsCollection playerItems, ArrayList<Button> putDownButtons) {
        if (playerItems == null || putDownButtons == null) {
            return;
        }

        for (Integer i = 0; i < putDownButtons.size(); i++) {
            Button putDownButton = putDownButtons.get(i);
            Item playerItem = playerItems.get(i);

            Boolean isDisabled = (playerItem == null || playerItem.getImage() == null);
            putDownButton.setDisable(isDisabled);
        }
    }
}
