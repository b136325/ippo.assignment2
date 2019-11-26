package ippo.assignment2.controllers;

import ippo.assignment2.collections.Items;
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
 * @since 0.2.1
 */
public class PlayerItemsController extends AbstractObserverController implements IController {

    @FXML
    private TextField counter;

    @FXML
    private ImageView imageViewer1;

    @FXML
    private ImageView imageViewer2;

    @FXML
    private ImageView imageViewer3;

    @FXML
    private ImageView imageViewer4;

    @FXML
    private Button putDownButton1;

    @FXML
    private Button putDownButton2;

    @FXML
    private Button putDownButton3;

    @FXML
    private Button putDownButton4;

    /**
     * @since 0.2.6
     */
    @FXML
    public void putDown(ActionEvent actionEvent) {
        Integer itemIndex = ActionEventHelper.deriveItemIndex(actionEvent);
        Item item = this.player.getItems().get(itemIndex);
        this.player.putDown(item);
    }

    /**
     * @since 0.2.1
     */
    @Override
    public void updateView() {
        Items items = this.player.getItems();
        if (items == null) {
            this.counter.setText("0");
        } else {
            this.counter.setText(items.count().toString());
            ArrayList<ImageView> imageViewers = this.getImageViewers();

            for (Integer i = 0; i < items.count(); i++) {
                Item item = items.get(i);
                ImageView imageViewer = imageViewers.get(i);
                this.updateViewItem(item, imageViewer);
            }
        }
    }

    /**
     *
     * @param imageViewers
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
     *
     * @return
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
     *
     * @param item
     * @param imageViewer
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
