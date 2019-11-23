package ippo.assignment2.collections;

import java.util.HashMap;

import ippo.assignment2.models.DirectionModel;
import ippo.assignment2.models.WallModel;
import java.awt.*;

/**
 * @since 0.1.2
 */
public class WallsCollection {

    /**
     * @since 0.1.2
     */
    private HashMap<DirectionModel, WallModel> walls = new HashMap<DirectionModel, WallModel>();

    /**
     *
     * @param direction
     * @param walls
     * @since 0.1.2
     */
    public void add(DirectionModel direction, WallModel walls) {
        this.walls.put(direction, walls);
    }

    /**
     *
     * @param direction
     * @return
     * @since 0.1.2
     */
    public Image getImage(DirectionModel direction) {
        WallModel wall = this.getWall(direction);

        if (wall != null) {
            return wall.getImage();
        }

        return null;
    }

    /**
     *
     * @param direction
     * @return
     * @since 0.1.2
     */
    public WallModel getWall(DirectionModel direction) {
        if (this.hasWall(direction)) {
            return this.walls.get(direction);
        }

        return null;
    }

    /**
     *
     * @param direction
     * @return
     * @since 0.1.2
     */
    public Boolean hasWall(DirectionModel direction) {
        return this.walls.containsKey(direction);
    }
}
