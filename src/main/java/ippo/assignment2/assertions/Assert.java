package ippo.assignment2.assertions;

import ippo.assignment2.collections.Items;
import ippo.assignment2.controllers.HeaderObserverController;
import ippo.assignment2.controllers.ImageObserverController;
import ippo.assignment2.controllers.NavigationObserverController;
import ippo.assignment2.controllers.PlayerItemsObserverController;
import ippo.assignment2.models.PlayerObservable;
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
    public static void headerController(HeaderObserverController headerController) {
        assert headerController != null : "HeaderController is null";
    }

    /**
     *
     * @param imageController
     * @since 0.2.1
     */
    public static void imageController(ImageObserverController imageController) {
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
    public static void navigationController(NavigationObserverController navigationController) {
        assert navigationController != null : "NavigationController is null";
    }

    /**
     *
     * @param player
     * @since 0.2.1
     */
    public static void player(PlayerObservable player) {
        assert player != null : "Player is null";
    }

    /**
     *
     * @param playerItemsController
     * @since 0.2.1
     */
    public static void playerItemsController(PlayerItemsObserverController playerItemsController) {
        assert playerItemsController != null : "PlayerItemsController is null";
    }

    /**
     *
     * @param room
     * @since 0.2.1
     */
    public static void room(Room room) {
        assert room != null : "Items is null";
    }
}
