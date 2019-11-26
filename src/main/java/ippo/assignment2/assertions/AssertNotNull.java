package ippo.assignment2.assertions;

import ippo.assignment2.collections.Items;
import ippo.assignment2.controllers.*;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;

/**
 * A class of static assertion 'not null' methods.
 *
 * @since 0.2.1
 */
public class AssertNotNull {

    /**
     * Assert that the received 'headerController' param is not null.
     *
     * @param headerController The controller to be checked.
     * @throws AssertionError if the controller is null.
     *
     * @since 0.2.1
     */
    public static void headerController(HeaderController headerController) {
        assert headerController != null : "HeaderController is null";
    }

    /**
     * Assert that the received 'imageController' param is not null.
     *
     * @param imageController The controller to be checked.
     * @throws AssertionError if the controller is null.
     *
     * @since 0.2.1
     */
    public static void imageController(ImageController imageController) {
        assert imageController != null : "ImageController is null";
    }

    /**
     * Assert that the received 'items' param is not null.
     *
     * @param items The items object to be checked.
     * @throws AssertionError if the object is null.
     *
     * @since 0.2.1
     */
    public static void items(Items items) {
        assert items != null : "Items is null";
    }

    /**
     * Assert that the received 'navigationController' param is not null.
     *
     * @param navigationController The controller to be checked.
     * @throws AssertionError if the controller is null.
     *
     * @since 0.2.1
     */
    public static void navigationController(NavigationController navigationController) {
        assert navigationController != null : "NavigationController is null";
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
     * Assert that the received 'playerItemsController' param is not null.
     *
     * @param playerItemsController The controller to be checked.
     * @throws AssertionError if the controller is null.
     *
     * @since 0.2.1
     */
    public static void playerItemsController(PlayerItemsController playerItemsController) {
        assert playerItemsController != null : "PlayerItemsController is null";
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

    /**
     * Assert that the received 'roomItemsController' param is not null.
     *
     * @param roomItemsController The controller to be checked.
     * @throws AssertionError if the controller is null.
     *
     * @since 0.2.1
     */
    public static void roomItemsController(RoomItemsController roomItemsController) {
        assert roomItemsController != null : "RoomItemsController is null";
    }
}
