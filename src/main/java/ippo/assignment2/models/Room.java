package ippo.assignment2.models;

import ippo.assignment2.collections.Items;
import ippo.assignment2.collections.Walls;
import java.awt.*;

public class Room {

    private Items items;
    private Walls walls;

    /**
     *
     * @param items
     * @param walls
     */
    public Room(Items items, Walls walls) {
        this.items = items;
        this.walls = walls;
    }

    /**
     *
     * @param item
     */
    public void add(Item item) {
        this.items.add(item);
    }

    /**
     *
     * @param direction
     * @return
     */
    public Image getImage(Direction direction) {
        return this.walls.getImage(direction);
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
     * @param direction
     * @return
     */
    public Wall getWall(Direction direction) {
        return this.walls.getWall(direction);
    }

    /**
     *
     * @param direction
     * @return
     */
    public Boolean hasWall(Direction direction) {
        return this.walls.hasWall(direction);
    }

    /**
     *
     * @param item
     * @return
     */
    public Boolean remove(Item item) {
        assert this.items != null : "Items is null";

        return this.items.remove(item);
    }
}
