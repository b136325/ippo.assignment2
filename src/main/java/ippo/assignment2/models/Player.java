package ippo.assignment2.models;

import ippo.assignment2.assertions.Assert;
import ippo.assignment2.collections.Items;
import javafx.scene.image.Image;
import java.util.Observable;

/**
 * @since 0.1.2
 */
public class Player extends Observable {
    private Direction direction;
    private Items items;
    private Room room;
    private String username;

    /**
     *
     * @param direction
     * @param items
     * @param room
     * @since 0.1.2
     */
    public Player(Direction direction, Items items, Room room, String username) {
        this.direction = direction;
        this.items = items;
        this.room = room;
        this.username = username;
    }

    /**
     *
     * @param direction
     * @return
     * @since 0.1.2
     */
    public Image getCurrentImage(Direction direction) {
        Assert.room(this.room);
        return this.room.getImage(direction);
    }

    /**
     *
     * @return
     * @since 0.1.2
     */
    public Direction getDirection() {
        return this.direction;
    }

    /**
     *
     * @return
     * @since 0.1.2
     */
    public Items getItems() {
        return this.items;
    }

    /**
     *
     * @return
     * @since 0.1.2
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     *
     * @return
     * @since 0.3.0
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @since 0.1.2
     */
    public void moveForward() {
        Assert.room(this.room);
        Wall wall = null;

        if (this.room.hasWall(this.direction)) {
            wall = this.room.getWall(direction);
        }

        if (wall != null && wall.hasRoom()) {
            this.room = wall.getRoom();
        }

        this.setChanged();
        this.notifyObservers();
    }

    /**
     *
     * @param item
     * @return
     * @since 0.1.2
     */
    public Boolean pickUp(Item item) {
        Assert.items(this.items);
        Assert.room(this.room);
        Boolean response = false;

        if (this.room.remove(item)) {
            this.items.add(item);
            response = true;
        }

        this.setChanged();
        this.notifyObservers();

        return response;
    }

    /**
     *
     * @param item
     * @return
     * @since 0.1.2
     */
    public Boolean putDown(Item item) {
        Assert.items(this.items);
        Assert.room(this.room);
        Boolean response = false;

        if (this.items.remove(item)) {
            this.room.add(item);
            response = true;
        }

        this.setChanged();
        this.notifyObservers();

        return response;
    }

    /**
     *
     * @param direction
     * @return
     * @since 0.1.2
     */
    public Boolean turn(Direction direction) {
        Assert.room(this.room);
        Boolean response = false;

        if (this.room.hasWall(direction)) {
            this.direction = direction;
            response = true;
        }

        this.setChanged();
        this.notifyObservers();

        return response;
    }
}
