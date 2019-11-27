package ippo.assignment2.models;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.collections.WallsCollection;
import javafx.scene.image.Image;

/**
 * A Room model class.
 *
 * @since 0.1.2
 */
public class Room {

    private ItemsCollection items;
    private String name;
    private WallsCollection walls;

    /**
     *
     * @param items
     * @param walls
     * @since 0.1.2
     */
    public Room(ItemsCollection items, WallsCollection walls, String name) {
        this.items = items;
        this.name = name;
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
    public ItemsCollection getItems() {
        return this.items;
    }

    /**
     * A 'getter' method that returns the room name.
     *
     * @return The room name or null.
     *
     * @since 0.4.0
     */
    public String getName() {
        return this.name;
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
