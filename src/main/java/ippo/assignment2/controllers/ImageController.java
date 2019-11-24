package ippo.assignment2.controllers;

import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

/**
 * @since 0.1.2
 */
public class ImageController extends BaseController implements Observer, Initializable {

    @FXML
    private ImageView imageViewer;

    /**
     *
     * @param location
     * @param resources
     * @since 0.2.0
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    /**
     *
     * @param player
     * @since 0.2.0
     */
    @Override
    public void setPlayer(Player player) {
        super.setPlayer(player);
        this.showImage();
    }

    /**
     * @since 0.2.0
     */
    public void showImage() {
        Direction direction = this.player.getDirection();
        Image image = this.player.getCurrentImage(direction);
        this.imageViewer.setImage(image);
    }

    /**
     *
     * @param o
     * @param args
     * @since 0.2.0
     */
    @Override
    public void update(Observable o, Object args) {
        Player player = (Player)o;
        this.setPlayer(player);
    }
}
