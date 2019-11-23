package ippo.assignment2.controllers;

import ippo.assignment2.factories.Services;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Wall;
import ippo.assignment2.services.IService;
import ippo.assignment2.utils.Properties;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @since 0.1.2
 */
public class Image implements Initializable {

    @FXML
    private ImageView imageViewer;

    private Player player;
    /**
     *
     * @param url
     * @param resourceBundle
     * @since 0.1.3
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Properties properties = null;
        String propertyName = "image.service";
        IService service = null;
        Services serviceFactory = null;

        try {
            properties = new Properties();
        } catch (IOException e) {
            e.printStackTrace();
        }

        serviceFactory = new Services();
        service = serviceFactory.generateFromProperties(
                properties,
                propertyName
        );

        if (service != null) {
            try {
                this.player = service.get();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Direction currentDirection = this.player.getDirection();
        Wall currentWall = this.player.getRoom().getWall(currentDirection);

        this.imageViewer.setImage(currentWall.getImage());
    }
}
