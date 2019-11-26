package ippo.assignment2.controllers;

import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Room;
import ippo.assignment2.models.Wall;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.*;

/**
 * An Observer controller for NavigationViewer.fxml.
 *
 * @since 0.1.2
 */
public class NavigationController extends AbstractObserverController implements IController {

    /**
     * A reference to the backButton (defined within NavigationViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button backButton;

    /**
     * A reference to the forwardButton (defined within NavigationViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button forwardButton;

    /**
     * A reference to the leftButton (defined within NavigationViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button leftButton;

    /**
     * A reference to the logger TextField (defined within NavigationViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private TextField logger;

    /**
     * A reference to the rightButton (defined within NavigationViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button rightButton;

    /**
     * A method that turns the player back.
     *
     * @since 0.1.3
     */
    @FXML
    public void goBack() {
        this.player.turn(Direction.BACK);
    }

    /**
     * A method that moves the player forward.
     *
     * @since 0.1.3
     */
    @FXML
    public void goForward() {
        this.player.moveForward();
        this.logger.setText(this.player.getRoom().toString());
    }

    /**
     * A method that turns the player left.
     *
     * @since 0.1.3
     */
    @FXML
    public void turnLeft() {
        this.player.turn(Direction.LEFT);
        this.logger.setText(this.player.getRoom().toString());
    }

    /**
     * A method that turns the player right.
     *
     * @since 0.1.3
     */
    @FXML
    public void turnRight() {
        this.player.turn(Direction.RIGHT);
        this.logger.setText(this.player.getRoom().toString());
    }

    /**
     * Update the view following a change to the model.
     *
     * @since 0.2.1
     */
    @Override
    public void updateView() {
        if (this.player != null) {

            // Construct an iterator containing all of the buttons.
            HashMap<Direction, Button> buttons = this.getButtons();
            Iterator buttonsIterator = buttons.entrySet().iterator();

            // Iterator across the buttons, calling
            // 'updateViewButtonVisibility' per button.
            while (buttonsIterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry)buttonsIterator.next();
                this.toggleButtonVisibility(mapElement);
            }
        }
    }

    /**
     * Build a HashMap of the navigation buttons.
     *
     * @return A HashMap of navigation buttons.
     *
     * @since 0.2.0
     */
    private HashMap<Direction, Button>  getButtons() {
        HashMap<Direction, Button> buttonsByDirection = new HashMap<Direction, Button>();

        buttonsByDirection.put(Direction.BACK, this.backButton);
        buttonsByDirection.put(Direction.FORWARD, this.forwardButton);
        buttonsByDirection.put(Direction.LEFT, this.leftButton);
        buttonsByDirection.put(Direction.RIGHT, this.rightButton);

        return buttonsByDirection;
    }

    /**
     * Toggle the visibility of a navigation button (identified
     * by a direction), depending upon whether or not the current
     * room contains a wall with a matching direction.
     *
     * @param mapElement A map whose key should be a Direction
     *                   and whose value should be a Button.
     *
     * @since 0.2.0
     */
    private void toggleButtonVisibility(Map.Entry mapElement) {
        Room room = null;

        if (this.player != null) {
            room = this.player.getRoom();
        }

        if (room != null) {
            // Find the button and direction from the received Map.
            Button button = (Button) mapElement.getValue();
            Direction direction = (Direction) mapElement.getKey();

            // Does the current room have a wall
            // with a direction that matches the
            // one associated with the button.
            Wall wall = room.getWall(direction);
            Boolean isDisabled = (wall == null);
            button.setDisable(isDisabled);
        }
    }
}
