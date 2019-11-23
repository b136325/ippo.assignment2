package ippo.assignment2.models;

import ippo.assignment2.collections.Items;
import ippo.assignment2.collections.Walls;
import java.awt.*;

public class Room {

    private Items items;
    private Walls walls;

    public Room(Items items, Walls walls) {
        this.items = items;
        this.walls = walls;
    }

    public void add(Item item) {
        this.items.add(item);
    }

    public Image getImage(Direction direction) {
        return this.walls.getImage(direction);
    }

    public Items getItems() {
        return this.items;
    }

    public Wall getWall(Direction direction) {
        return this.walls.getWall(direction);
    }

    public Boolean hasWall(Direction direction) {
        return this.walls.hasWall(direction);
    }

    public void remove(Item item) {
        this.remove(item);
    }
}
