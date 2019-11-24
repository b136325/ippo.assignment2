package ippo.assignment2.assertions;

import ippo.assignment2.collections.Items;
import ippo.assignment2.controllers.*;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;

/**
 * @since 0.2.1
 */
public class Assert {

    /**
     *
     * @param headerController
     * @since 0.2.1
     */
    public static void headerController(HeaderController headerController) {
        assert headerController != null : "HeaderController is null";
    }

    /**
     *
     * @param imageController
     * @since 0.2.1
     */
    public static void imageController(ImageController imageController) {
        assert imageController != null : "ImageController is null";
    }

    /**
     *
     * @param items
     * @since 0.2.1
     */
    public static void items(Items items) {
        assert items != null : "Items is null";
    }

    /**
     *
     * @param navigationController
     * @since 0.2.1
     */
    public static void navigationController(NavigationController navigationController) {
        assert navigationController != null : "NavigationController is null";
    }

    /**
     *
     * @param player
     * @since 0.2.1
     */
    public static void player(Player player) {
        assert player != null : "Player is null";
    }

    /**
     *
     * @param playerItemsController
     * @since 0.2.1
     */
    public static void playerItemsController(PlayerItemsController playerItemsController) {
        assert playerItemsController != null : "PlayerItemsController is null";
    }

    /**
     *
     * @param room
     * @since 0.2.1
     */
    public static void room(Room room) {
        assert room != null : "Room is null";
    }

    /**
     *
     * @param roomItemsController
     * @since 0.2.2
     */
    public static void roomItemsController(RoomItemsController roomItemsController) {
        assert roomItemsController != null : "RoomItemsController is null";
    }
}
