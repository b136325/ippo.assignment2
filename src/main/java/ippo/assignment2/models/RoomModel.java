package ippo.assignment2.models;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.collections.WallsCollection;
import java.awt.*;

public class RoomModel {

    private ItemsCollection items;
    private WallsCollection walls;

    /**
     *
     * @param items
     * @param walls
     */
    public RoomModel(ItemsCollection items, WallsCollection walls) {
        this.items = items;
        this.walls = walls;
    }

    /**
     *
     * @param item
     */
    public void add(ItemModel item) {
        this.items.add(item);
    }

    /**
     *
     * @param direction
     * @return
     */
    public Image getImage(DirectionModel direction) {
        return this.walls.getImage(direction);
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
     * @param direction
     * @return
     */
    public WallModel getWall(DirectionModel direction) {
        return this.walls.getWall(direction);
    }

    /**
     *
     * @param direction
     * @return
     */
    public Boolean hasWall(DirectionModel direction) {
        return this.walls.hasWall(direction);
    }

    /**
     *
     * @param item
     * @return
     */
    public Boolean remove(ItemModel item) {
        assert this.items != null : "Items is null";

        return this.items.remove(item);
    }
}
