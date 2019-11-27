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
     * The constructor for the Room model class.
     *
     * @param items A collection of items within the room.
     * @param walls A collection of walls.
     * @param name The name of the room.
     *
     * @since 0.1.2
     */
    public Room(ItemsCollection items, WallsCollection walls, String name) {
        this.items = items;
        this.name = name;
        this.walls = walls;
    }

    /**
     * Add an item to a room.
     *
     * @param item The Item to be added.
     *
     * @since 0.1.2
     */
    public void add(Item item) {
        if (this.items != null) {
            this.items.add(item);
        }
    }

    /**
     * A 'getter' method that returns the image associated
     * with a wall by direction. Or null.
     *
     * @param direction The direction of the wall.
     * @return An Image or null.
     *
     * @since 0.1.2
     */
    public Image getImage(Direction direction) {
        if (this.walls == null) {
            return null;
        }
        return this.walls.getImage(direction);
    }

    /**
     * A 'getter' method that returns the Items collection
     * associated with the room.
     *
     * @return The Items collection or null.
     *
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
     * A 'getter' method that returns a wall by direction.
     *
     * @param direction The direction of the wall.
     * @return A Wall object or null.
     *
     * @since 0.1.2
     */
    public Wall getWall(Direction direction) {
        if (this.walls == null) {
            return null;
        }
        return this.walls.getWall(direction);
    }

    /**
     * A 'utility' method that returns true or false
     * depending upon whether or not the room has a
     * wall associated with the received direction.
     *
     * @param direction The direction to check.
     * @return True or false.
     *
     * @since 0.1.2
     */
    public Boolean hasWall(Direction direction) {
        if (this.walls == null) {
            return false;
        }
        return this.walls.hasWall(direction);
    }

    /**
     * A method that may be used to remove an
     * Item from the Items collection. Note
     * that this method requires that this.items
     * is not null.
     *
     * @param item The Item to be removed.
     * @return True when the item has been removed. Otherwise, false.
     *
     * @since 0.1.2
     */
    public Boolean remove(Item item) {
        assert this.items != null : "Items is null";

        return this.items.remove(item);
    }
}
