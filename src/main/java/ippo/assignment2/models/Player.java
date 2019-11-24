package ippo.assignment2.models;

import javafx.scene.image.Image;
import java.util.Observable;

import ippo.assignment2.collections.Items;

public class Player extends Observable {
    private Direction direction;
    private Items items;
    private Room room;

    /**
     *
     * @param direction
     * @param items
     * @param room
     */
    public Player(Direction direction, Items items, Room room) {
        this.direction = direction;
        this.items = items;
        this.room = room;
    }

    /**
     *
     * @param direction
     * @return
     */
    public Image getCurrentImage(Direction direction) {
        this.assertRoom();
        return this.room.getImage(direction);
    }

    /**
     *
     * @return
     */
    public Direction getDirection() {
        return this.direction;
    }

    /**
     *
     * @return
     */
    public Items getItems() {
        return this.items;
    }

    /**
     *
     * @return
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     *
     */
    public void moveForward() {
        this.assertRoom();
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
     */
    public Boolean pickUp(Item item) {
        this.assertItems();
        this.assertRoom();
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
     */
    public Boolean putDown(Item item) {
        this.assertItems();
        this.assertRoom();
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
     */
    public Boolean turn(Direction direction) {
        this.assertRoom();
        Boolean response = false;

        if (this.room.hasWall(direction)) {
            this.direction = direction;
            response = true;
        }

        this.setChanged();
        this.notifyObservers();

        return response;
    }

    /**
     * @since 0.2.0
     */
    private void assertItems() {
        assert this.items != null : "Items is null";
    }

    /**
     * @since 0.2.0
     */
    private void assertRoom() {
        assert this.room != null : "Room is null";
    }
}
