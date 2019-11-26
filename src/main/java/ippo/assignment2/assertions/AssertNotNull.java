package ippo.assignment2.assertions;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.controllers.*;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;

/**
 * A class of static assertion 'not null' methods.
 *
 * @since 0.2.1
 */
public class AssertNotNull {

    /**
     * Assert that the received instance of IController is not null.
     *
     * @param controller The controller to be checked.
     * @throws AssertionError if the controller is null.
     *
     * @since 0.3.2
     */
    public static void controller(IController controller) {
        assert controller != null : "Controller is null";
    }

    /**
     * Assert that the received instance of direction is not null.
     *
     * @param direction The direction to be checked.
     * @throws AssertionError if the direction is null.
     *
     * @since 0.3.2
     */
    public static void direction(Direction direction) {
        assert direction != null : "Direction is null";
    }

    /**
     * Assert that the received 'items' param is not null.
     *
     * @param items The items object to be checked.
     * @throws AssertionError if the object is null.
     *
     * @since 0.2.1
     */
    public static void items(ItemsCollection items) {
        assert items != null : "Items is null";
    }

    /**
     * Assert that the received 'player' param is not null.
     *
     * @param player The player to be checked.
     * @throws AssertionError if the player is null.
     *
     * @since 0.2.1
     */
    public static void player(Player player) {
        assert player != null : "Player is null";
    }

    /**
     * Assert that the received 'room' param is not null.
     *
     * @param room The Room object to be checked.
     * @throws AssertionError if the room is null.
     *
     * @since 0.2.1
     */
    public static void room(Room room) {
        assert room != null : "Room is null";
    }
}
