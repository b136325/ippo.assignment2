package ippo.assignment2.controllers;

import ippo.assignment2.models.Player;
import ippo.assignment2.models.Wall;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.*;

import ippo.assignment2.models.Direction;

/**
 * @since 0.1.2
 */
public class NavigationController extends BaseController implements Observer , Initializable {

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
     *
     * @param location
     * @param resources
     * @since 0.2.0
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    /**
     * @since 0.2.0
     */
    public HashMap<Direction, Button>  getButtons() {
        HashMap<Direction, Button> buttonsByDirection = new HashMap<Direction, Button>();

        buttonsByDirection.put(Direction.BACK, this.backButton);
        buttonsByDirection.put(Direction.FORWARD, this.forwardButton);
        buttonsByDirection.put(Direction.LEFT, this.leftButton);
        buttonsByDirection.put(Direction.RIGHT, this.rightButton);

        return buttonsByDirection;
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
     * @since 0.2.0
     */
    public void setButtonsVisibility() {
        if (this.player != null) {

            HashMap<Direction, Button> buttons = this.getButtons();
            Iterator buttonsIterator = buttons.entrySet().iterator();

            while (buttonsIterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry)buttonsIterator.next();
                this.setButtonVisibility(mapElement);
            }
        }
    }

    /**
     * @since 0.2.0
     */
    public void setButtonVisibility(Map.Entry mapElement) {
        if (this.player != null) {

            Button button = (Button) mapElement.getValue();
            Direction direction = (Direction) mapElement.getKey();

            Wall wall = this.player.getRoom().getWall(direction);
            Boolean isDisabled = (wall == null);
            button.setDisable(isDisabled);
        }
    }
    /**
     *
     * @param player
     * @since 0.2.0
     */
    @Override
    public void setPlayer(Player player) {
        super.setPlayer(player);
        this.setButtonsVisibility();
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

    /**
     *
     * @param o
     * @param arg
     * @since 0.2.0
     */
    @Override
    public void update(Observable o, Object arg) {
        Player player = (Player)o;
        this.setPlayer(player);
    }
}
