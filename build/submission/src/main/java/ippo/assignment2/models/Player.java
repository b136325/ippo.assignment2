package ippo.assignment2.models;

import ippo.assignment2.collections.Items;

import java.awt.*;

public class Player {
    private Direction direction;
    private Items items;
    private Room room;

    public Player(Items items, Room room) {
        this.items = items;
        this.room = room;
    }

    public Image getCurrentImage(Direction direction) {
        return this.room.getImage(direction);
    }

    public void moveForward() {
        Wall wall = null;

        if (this.room.hasWall(this.direction)) {
            wall = this.room.getWall(direction);
        }

        if (wall != null && wall.hasRoom()) {
            this.room = wall.getRoom();
        }
    }

    public void pickup(Item item) {
        this.room.remove(item);
        this.items.add(item);
    }

    public void putdown(Item item) {
        this.items.remove(item);
        this.room.add(item);
    }

    public void turn(Direction direction) {
        if (this.room.hasWall(direction)) {
            this.direction = direction;
        }
    }
}
