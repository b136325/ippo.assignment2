package ippo.assignment2.collections;

import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Wall;
import java.util.HashMap;
import javafx.scene.image.Image;

/**
 * A collection of Wall models.
 * @since 0.1.2
 */
public class Walls {

    /**
     * @since 0.1.2
     */
    private HashMap<Direction, Wall> walls = new HashMap<Direction, Wall>();

    /**
     *
     * @param direction
     * @param walls
     * @since 0.1.2
     */
    public void add(Direction direction, Wall walls) {
        this.walls.put(direction, walls);
    }

    /**
     *
     * @return
     * @since 0.2.8
     */
    public Integer count() {
        Integer count = this.walls.size();
        if (count == null) {
            count = 0;
        }
        return count;
    }

    /**
     *
     * @param direction
     * @return
     * @since 0.1.2
     */
    public Image getImage(Direction direction) {
        Wall wall = this.getWall(direction);

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
    public Wall getWall(Direction direction) {
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
    public Boolean hasWall(Direction direction) {
        return this.walls.containsKey(direction);
    }
}
