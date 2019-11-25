package ippo.assignment2.models;

import ippo.assignment2.collections.Items;
import ippo.assignment2.collections.Walls;
import javafx.scene.image.Image;

/**
 * @since 0.1.2
 */
public class Room {

    private Items items;
    private Walls walls;

    /**
     *
     * @param items
     * @param walls
     * @since 0.1.2
     */
    public Room(Items items, Walls walls) {
        this.items = items;
        this.walls = walls;
    }

    /**
     *
     * @param item
     * @since 0.1.2
     */
    public void add(Item item) {
        this.items.add(item);
    }

    /**
     *
     * @param direction
     * @return
     * @since 0.1.2
     */
    public Image getImage(Direction direction) {
        if (this.walls == null) {
            return null;
        }
        return this.walls.getImage(direction);
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
     * @param direction
     * @return
     * @since 0.1.2
     */
    public Wall getWall(Direction direction) {
        if (this.walls == null) {
            return null;
        }
        return this.walls.getWall(direction);
    }

    /**
     *
     * @param direction
     * @return
     * @since 0.1.2
     */
    public Boolean hasWall(Direction direction) {
        if (this.walls == null) {
            return false;
        }
        return this.walls.hasWall(direction);
    }

    /**
     *
     * @param item
     * @return
     * @since 0.1.2
     */
    public Boolean remove(Item item) {
        assert this.items != null : "Items is null";

        return this.items.remove(item);
    }
}
