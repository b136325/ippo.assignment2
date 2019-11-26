package ippo.assignment2.controllers;

import ippo.assignment2.models.Direction;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * An Observer controller for ImageViewer.fxml.
 *
 * @since 0.1.2
 */
public class ImageController extends AbstractObserverController implements IController {

    /**
     * A reference to the imageViewer (defined within ImageViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private ImageView imageViewer;

    /**
     * Update the view following a change to the model.
     *
     * @since 0.2.1
     */
    public void updateView() {
        Direction direction = this.player.getDirection();
        Image image = this.player.getCurrentImage(direction);
        this.imageViewer.setImage(image);
    }
}

