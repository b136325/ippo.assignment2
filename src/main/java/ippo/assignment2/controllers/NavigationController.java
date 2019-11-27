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
     * A reference to the (movement) forwardButton (defined within NavigationViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Button forwardButton;

    /**
     * A reference to the (orientation) northButton (defined within NavigationViewer.fxml).
     *
     * @since 0.4.3
     */
    @FXML
    private Button northButton;

    /**
     * A reference to the (orientation) eastButton (defined within NavigationViewer.fxml).
     *
     * @since 0.4.3
     */
    @FXML
    private Button eastButton;

    /**
     * A reference to the (orientation) southButton (defined within NavigationViewer.fxml).
     *
     * @since 0.4.3
     */
    @FXML
    private Button southButton;

    /**
     * A reference to the (orientation) westButton (defined within NavigationViewer.fxml).
     *
     * @since 0.4.3
     */
    @FXML
    private Button westButton;

    /**
     * A reference to the logger TextField (defined within NavigationViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private TextField logger;

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
     * A method that directs the player northwards.
     *
     * @since 0.4.3
     */
    @FXML
    public void turnNorth() {
        this.player.turn(Direction.NORTH);
        this.logger.setText(this.player.getRoom().toString());
    }

    /**
     * A method that directs the player eastwards.
     *
     * @since 0.4.3
     */
    @FXML
    public void turnEast() {
        this.player.turn(Direction.EAST);
        this.logger.setText(this.player.getRoom().toString());
    }

    /**
     * A method that directs the player southwards.
     *
     * @since 0.4.3
     */
    @FXML
    public void turnSouth() {
        this.player.turn(Direction.SOUTH);
        this.logger.setText(this.player.getRoom().toString());
    }

    /**
     * A method that directs the player southwards.
     *
     * @since 0.4.3
     */
    @FXML
    public void turnWest() {
        this.player.turn(Direction.WEST);
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

            // Update the 
            this.toggleForwardButtonDisablement();
            
            // Construct an iterator containing all of the buttons.
            HashMap<Direction, Button> buttons = this.getButtons();
            Iterator buttonsIterator = buttons.entrySet().iterator();

            // Iterator across the buttons, calling
            // 'updateViewButtonVisibility' per button.
            while (buttonsIterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry)buttonsIterator.next();
                this.toggleDirectionButtonDisablement(mapElement);
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

        buttonsByDirection.put(Direction.NORTH, this.northButton);
        buttonsByDirection.put(Direction.EAST, this.eastButton);
        buttonsByDirection.put(Direction.SOUTH, this.southButton);
        buttonsByDirection.put(Direction.WEST, this.westButton);

        return buttonsByDirection;
    }

    /**
     * Toggle the disablement of a direction button (identified
     * by a direction), depending upon whether or not the current
     * room contains a wall with a matching direction.
     *
     * @param mapElement A map whose key should be a Direction
     *                   and whose value should be a Button.
     *
     * @since 0.2.0
     */
    private void toggleDirectionButtonDisablement(Map.Entry mapElement) {
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

            // However, if the direction of the button currently being
            // examined matches the player's direction, such that,
            // the button is associated with the current wall, then
            // prevent the button from being re-clicked.
            if (direction == this.player.getDirection()) {
                button.setDisable(true);
            }
        }
    }

    /**
     * Toggle the disablement of the forward button.
     *
     * @since 0.4.3
     */
    private void toggleForwardButtonDisablement() {
        Direction playersCurrentDirection = this.player.getDirection();
        Room room = this.player.getRoom();

        // If there is not current room, then ensure that 'forward' button is disabled.
        if (room == null) {
            this.forwardButton.setDisable(true);
            return;
        }

        // If the current wall is null, then ensure that 'forward' button is disabled.
        Wall currentFacingWall = room.getWall(playersCurrentDirection);
        if (currentFacingWall == null) {
            this.forwardButton.setDisable(true);
            return;
        }

        // If nextRoom is null, then ensure that 'forward' button is disabled.
        Room nextRoom = currentFacingWall.getRoom();
        if (nextRoom == null) {
            this.forwardButton.setDisable(true);
            return;
        }

        this.forwardButton.setDisable(false);
    }
}
