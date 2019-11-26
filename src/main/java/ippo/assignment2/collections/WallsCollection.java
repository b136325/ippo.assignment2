package ippo.assignment2.collections;

import ippo.assignment2.assertions.AssertNotNull;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Wall;
import java.util.HashMap;
import javafx.scene.image.Image;

/**
 * A collection of Wall models keyed by Direction.
 *
 * @since 0.1.2
 */
public class WallsCollection {

    /**
     * An empty HashMap, which will be used to contain Wall models keyed by Direction.
     *
     * @since 0.1.2
     */
    private HashMap<Direction, Wall> walls = new HashMap<Direction, Wall>();

    /**
     * Add a new wall keyed by direction to the collection.
     *
     * @param direction The direction of the wall to be added.
     * @param walls The wall to be added.
     *
     * @since 0.1.2
     */
    public void add(Direction direction, Wall walls) {
        AssertNotNull.direction(direction);
        this.walls.put(direction, walls);
    }

    /**
     * Find the number of Wall objects within the collection.
     *
     * @return Either a positive integer or zero.
     *
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
     * Find the image associated with a Wall object by direction.
     *
     * @param direction The direction of the Wall object.
     * @return The image to be returned or null.
     *
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
     * Find a Wall object by direction.
     *
     * @param direction The direction of the Wall object to be found.
     * @return A Wall object or null.
     *
     * @since 0.1.2
     */
    public Wall getWall(Direction direction) {
        if (this.hasWall(direction)) {
            return this.walls.get(direction);
        }

        return null;
    }

    /**
     * Determine if a the received 'direction' exists within the collection.
     *
     * @param direction The 'direction' to check.
     * @return True or false.
     *
     * @since 0.1.2
     */
    public Boolean hasWall(Direction direction) {
        return this.walls.containsKey(direction);
    }
}
