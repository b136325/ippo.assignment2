package ippo.assignment2.models;

import ippo.assignment2.assertions.AssertNotNull;
import ippo.assignment2.collections.ItemsCollection;
import javafx.scene.image.Image;
import java.util.Observable;

/**
 * The player model.
 *
 * @since 0.1.2
 */
public class Player extends Observable {
    private Direction direction;
    private ItemsCollection items;
    private Room room;
    private String username;

    /**
     * The constructor for the player model.
     *
     * @param direction The player's initial direction.
     * @param items A collection of the player's items.
     * @param room The room currently 'occupied' by the player.
     * @param username The player's username.
     *
     * @since 0.1.2
     */
    public Player(Direction direction, ItemsCollection items, Room room, String username) {
        this.direction = direction;
        this.items = items;
        this.room = room;
        this.username = username;
    }

    /**
     * Find the current image by direction.
     *
     * @param direction The direction with which to find the current image.
     * @return The image associated with the received direction or null.
     * @throws AssertionError When this.room is null.
     *
     * @since 0.1.2
     */
    public Image getCurrentImage(Direction direction) {
        AssertNotNull.room(this.room);
        return this.room.getImage(direction);
    }

    /**
     * Find the player's current direction.
     *
     * @return The player's current direction or null.
     *
     * @since 0.1.2
     */
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Find the player's collection of items.
     *
     * @return A collection of items or null.
     *
     * @since 0.1.2
     */
    public ItemsCollection getItems() {
        return this.items;
    }

    /**
     * Find the room currently 'occupied' by the player.
     *
     * @return A room object or null.
     *
     * @since 0.1.2
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     * Find the player's username.
     *
     * @return The player's username or null.
     *
     * @since 0.3.0
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Enable the player to move forward to the next room.
     *
     * @throws AssertionError When this.room is null.
     *
     * @since 0.1.2
     */
    public void moveForward() {
        AssertNotNull.room(this.room);
        Wall wall = null;

        if (this.room.hasWall(this.direction)) {
            wall = this.room.getWall(direction);
        }

        if (wall != null && wall.hasRoom()) {
            this.room = wall.getRoom();
        }

        // Notify observing controllers that the model has changed.
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Pick up an item from the current room.
     *
     * @param item The item to be picked up.
     * @return True or false depending upon whether or not
     *         the item was picked up successfully.
     *
     * @throws AssertionError When this.items is null.
     * @throws AssertionError When this.room is null.
     *
     * @since 0.1.2
     */
    public Boolean pickUp(Item item) {
        AssertNotNull.items(this.items);
        AssertNotNull.room(this.room);
        Boolean response = false;

        if (this.room.remove(item)) {
            this.items.add(item);
            response = true;
        }

        // Notify observing controllers that the model has changed.
        this.setChanged();
        this.notifyObservers();

        return response;
    }

    /**
     * Put down an item into the current room.
     *
     * @param item The item to be placed in the room.
     * @return True or false depending upon whether or not
     *         the item was placed successfully.
     *
     * @throws AssertionError When this.items is null.
     * @throws AssertionError When this.room is null.
     *
     * @since 0.1.2
     */
    public Boolean putDown(Item item) {
        AssertNotNull.items(this.items);
        AssertNotNull.room(this.room);
        Boolean response = false;

        if (this.items.remove(item)) {
            this.room.add(item);
            response = true;
        }

        // Notify observing controllers that the model has changed.
        this.setChanged();
        this.notifyObservers();

        return response;
    }

    /**
     * Enable a player to turn by direction.
     *
     * @param direction The direction to turn.
     * @return True or false depending upon whether or not the player was turned.
     * @throws AssertionError When this.room is null.
     *
     * @since 0.1.2
     */
    public Boolean turn(Direction direction) {
        AssertNotNull.room(this.room);
        Boolean response = false;

        if (this.room.hasWall(direction)) {
            this.direction = direction;
            response = true;
        }

        // Notify observing controllers that the model has changed.
        this.setChanged();
        this.notifyObservers();

        return response;
    }
}
