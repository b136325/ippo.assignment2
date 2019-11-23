package ippo.assignment2.models;

import ippo.assignment2.collections.Items;

import java.awt.*;

public class Player {
    private Direction direction;
    private Items items;
    private Room room;

    public Player(Direction direction, Items items, Room room) {
        this.direction = direction;
        this.items = items;
        this.room = room;
    }

    public Image getCurrentImage(Direction direction) {
        this.assertRoom();
        return this.room.getImage(direction);
    }

    public Direction getDirection() {
        return this.direction;
    }

    public Items getItems() {
        return this.items;
    }

    public Room getRoom() {
        return this.room;
    }

    public void moveForward() {
        this.assertRoom();
        Wall wall = null;

        if (this.room.hasWall(this.direction)) {
            wall = this.room.getWall(direction);
        }

        if (wall != null && wall.hasRoom()) {
            this.room = wall.getRoom();
        }
    }

    public Boolean pickUp(Item item) {
        this.assertItems();
        this.assertRoom();
        Boolean response = false;

        if (this.room.remove(item)) {
            this.items.add(item);
            response = true;
        }
        return response;
    }

    public Boolean putDown(Item item) {
        this.assertItems();
        this.assertRoom();
        Boolean response = false;

        if (this.items.remove(item)) {
            this.room.add(item);
            response = true;
        }
        return response;
    }

    public Boolean turn(Direction direction) {
        this.assertRoom();
        Boolean response = false;

        if (this.room.hasWall(direction)) {
            this.direction = direction;
            response = true;
        }

        return response;
    }

    private void assertItems() {
        assert this.items != null : "Items is null";
    }

    private void assertRoom() {
        assert this.room != null : "Room is null";
    }
}
