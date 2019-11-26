package ippo.assignment2.controllers;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.utils.ActionEventHelper;
import ippo.assignment2.models.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.*;

/**
 * An Observer controller for PlayerItemsViewer.fxml.
 *
 * @since 0.2.1
 */
public class PlayerItemsController extends AbstractObserverController implements IController {

    /**
     * A reference to the counter TextField (defined within PlayerItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private TextField counter;

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
        ItemsCollection items = this.player.getItems();

        if (items == null) {

            // Update the visible counter when there are no items.
            this.counter.setText("0");
        } else {

            // Update the visible counter with the number of player items.
            this.counter.setText(items.count().toString());

            // Retrieve a list of the child ImageViews
            ArrayList<ImageView> imageViewers = this.getImageViewers();

            for (Integer i = 0; i < items.count(); i++) {
                Item item = items.get(i);
                ImageView imageViewer = imageViewers.get(i);
                this.updateViewItem(item, imageViewer);
            }
        }
    }

    /**
     * Clear all images from the image viewers.
     *
     * @param imageViewers A list of all child image viewers.
     *
     * @since 0.2.12
     */
    private void clearImageViewers(ArrayList<ImageView> imageViewers) {
        Iterator<ImageView> imageViewersIterator = imageViewers.iterator();

        while (imageViewersIterator.hasNext()) {
            ImageView imageView = imageViewersIterator.next();
            imageView.setImage(null);
        }
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
     * Update the item image within an image viewer.
     *
     * @param item The item with an image.
     * @param imageViewer The image viewer to be updated.
     *
     * @since 0.2.1
     */
    private void updateViewItem(Item item, ImageView imageViewer) {
        Image image = null;

        ArrayList<ImageView> imageViewers = this.getImageViewers();
        this.clearImageViewers(imageViewers);

        if (item != null && imageViewer != null) {
            image = item.getImage();
        }

        if (image != null) {
            imageViewer.setImage(image);
        }
    }
}
