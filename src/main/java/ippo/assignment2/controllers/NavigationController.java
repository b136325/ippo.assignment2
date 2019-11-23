package ippo.assignment2.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import ippo.assignment2.collections.WallsCollection;
import ippo.assignment2.models.DirectionModel;
import ippo.assignment2.models.PlayerModel;
import ippo.assignment2.models.WallModel;
import ippo.assignment2.models.RoomModel;

/**
 * @since 0.1.2
 */
public class NavigationController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Button forwardButton;

    @FXML
    private Button leftButton;

    @FXML
    private Button rightButton;

    private PlayerModel player;

    /**
     *
     * @param url
     * @param resourceBundle
     * @since 0.1.3
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WallModel leftWall = new WallModel(null, null);
        WallModel rightWall = new WallModel(null, null);
        WallsCollection walls = new WallsCollection();
        walls.add(DirectionModel.LEFT, leftWall);
        walls.add(DirectionModel.RIGHT, rightWall);
        RoomModel room = new RoomModel(null, walls);

        this.player = new PlayerModel(null, null, room);
    }

    /**
     * @since 0.1.3
     */
    @FXML
    public void goBack() {
        this.player.turn(DirectionModel.BACK);
    }

    /**
     * @since 0.1.3
     */
    @FXML
    public void goForward() {
        this.player.moveForward();
    }

    /**
     * @since 0.1.2
     */
    @FXML
    public void turnLeft() {
        this.player.turn(DirectionModel.LEFT);
    }

    /**
     * @since 0.1.3
     */
    @FXML
    public void turnRight() {
        this.player.turn(DirectionModel.RIGHT);
    }
}
