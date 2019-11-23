package ippo.assignment2.collections;

import java.util.HashMap;

import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Wall;
import java.awt.*;

public class Walls {
    private HashMap<Direction, Wall> walls = new HashMap<Direction, Wall>();

    public void add(Direction direction, Wall walls) {
        this.walls.put(direction, walls);
    }

    public Image getImage(Direction direction) {
        Wall wall = this.getWall(direction);

        if (wall != null) {
            return wall.getImage();
        }

        return null;
    }

    public Wall getWall(Direction direction) {
        if (this.hasWall(direction)) {
            return this.walls.get(direction);
        }

        return null;
    }

    public Boolean hasWall(Direction direction) {
        return this.walls.containsKey(direction);
    }
}
