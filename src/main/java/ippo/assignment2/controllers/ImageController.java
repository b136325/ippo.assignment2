package ippo.assignment2.controllers;

import ippo.assignment2.models.Direction;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * An Observer controller for ImageViewer.fxml.
 * @since 0.1.2
 */
public class ImageController extends AbstractObserverController implements IController {

    @FXML
    private ImageView imageViewer;

    /**
     * @since 0.2.0
     */
    public void updateView() {
        Direction direction = this.player.getDirection();
        Image image = this.player.getCurrentImage(direction);
        this.imageViewer.setImage(image);
    }
}

