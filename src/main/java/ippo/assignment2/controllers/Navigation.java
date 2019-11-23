package ippo.assignment2.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ippo.assignment2.factories.Services;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import ippo.assignment2.services.IService;
import ippo.assignment2.utils.Properties;
import javafx.scene.control.TextField;

/**
 * @since 0.1.2
 */
public class Navigation implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Button forwardButton;

    @FXML
    private Button leftButton;

    @FXML
    private TextField logger;

    @FXML
    private Button rightButton;

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
        String propertyName = "navigation.service";
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
            this.player = service.get();
        }
    }

    /**
     * @since 0.1.3
     */
    @FXML
    public void goBack() {
        this.player.turn(Direction.BACK);
    }

    /**
     * @since 0.1.3
     */
    @FXML
    public void goForward() {
        this.player.moveForward();
        this.logger.setText(this.player.getRoom().toString());
    }

    /**
     * @since 0.1.2
     */
    @FXML
    public void turnLeft() {
        this.player.turn(Direction.LEFT);
        this.logger.setText(this.player.getRoom().toString());
    }

    /**
     * @since 0.1.3
     */
    @FXML
    public void turnRight() {
        this.player.turn(Direction.RIGHT);
        this.logger.setText(this.player.getRoom().toString());
    }
}
