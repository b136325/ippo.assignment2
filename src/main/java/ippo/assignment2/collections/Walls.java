package ippo.assignment2.collections;

import java.util.HashMap;

import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Wall;
import javafx.scene.image.Image;

/**
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
