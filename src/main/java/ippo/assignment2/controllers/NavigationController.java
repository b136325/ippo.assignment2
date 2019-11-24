package ippo.assignment2.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import ippo.assignment2.models.Direction;

import java.util.Observable;
import java.util.Observer;

/**
 * @since 0.1.2
 */
public class NavigationController extends BaseController implements Observer {

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

    @Override
    public void update(Observable o, Object arg) {

    }
}
