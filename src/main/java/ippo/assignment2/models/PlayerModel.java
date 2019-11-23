package ippo.assignment2.models;

import ippo.assignment2.collections.ItemsCollection;

import java.awt.*;

public class PlayerModel {
    private DirectionModel direction;
    private ItemsCollection items;
    private RoomModel room;

    /**
     *
     * @param direction
     * @param items
     * @param room
     */
    public PlayerModel(DirectionModel direction, ItemsCollection items, RoomModel room) {
        this.direction = direction;
        this.items = items;
        this.room = room;
    }

    /**
     *
     * @param direction
     * @return
     */
    public Image getCurrentImage(DirectionModel direction) {
        this.assertRoom();
        return this.room.getImage(direction);
    }

    /**
     *
     * @return
     */
    public DirectionModel getDirection() {
        return this.direction;
    }

    /**
     *
     * @return
     */
    public ItemsCollection getItems() {
        return this.items;
    }

    /**
     *
     * @return
     */
    public RoomModel getRoom() {
        return this.room;
    }

    /**
     *
     */
    public void moveForward() {
        this.assertRoom();
        WallModel wall = null;

        if (this.room.hasWall(this.direction)) {
            wall = this.room.getWall(direction);
        }

        if (wall != null && wall.hasRoom()) {
            this.room = wall.getRoom();
        }
    }

    /**
     *
     * @param item
     * @return
     */
    public Boolean pickUp(ItemModel item) {
        this.assertItems();
        this.assertRoom();
        Boolean response = false;

        if (this.room.remove(item)) {
            this.items.add(item);
            response = true;
        }
        return response;
    }

    /**
     *
     * @param item
     * @return
     */
    public Boolean putDown(ItemModel item) {
        this.assertItems();
        this.assertRoom();
        Boolean response = false;

        if (this.items.remove(item)) {
            this.room.add(item);
            response = true;
        }
        return response;
    }

    /**
     *
     * @param direction
     * @return
     */
    public Boolean turn(DirectionModel direction) {
        this.assertRoom();
        Boolean response = false;

        if (this.room.hasWall(direction)) {
            this.direction = direction;
            response = true;
        }

        return response;
    }

    /**
     *
     */
    private void assertItems() {
        assert this.items != null : "Items is null";
    }

    /**
     *
     */
    private void assertRoom() {
        assert this.room != null : "Room is null";
    }
}
