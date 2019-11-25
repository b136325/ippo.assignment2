package ippo.assignment2.collections;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Wall;

public class WallsTest {

    @Test
    public void addTestWithDifferentDirectionKeys() {
        Walls walls = new Walls();
        assertTrue(walls.count() == 0);

        Wall wallOne = new Wall(null, null, "Wall One");
        walls.add(Direction.RIGHT, wallOne);
        assertTrue(walls.count() == 1);

        Wall wallTwo = new Wall(null, null, "Wall Two");
        walls.add(Direction.LEFT, wallTwo);
        assertTrue(walls.count() == 2);
    }

    @Test
    public void addTestWithSameDirectionKeys() {
        Walls walls = new Walls();
        assertTrue(walls.count() == 0);

        Wall wallOne = new Wall(null, null, "Wall One");
        walls.add(Direction.RIGHT, wallOne);
        assertTrue(walls.count() == 1);

        Wall wallTwo = new Wall(null, null, "Wall Two");
        walls.add(Direction.RIGHT, wallTwo);
        assertTrue(walls.count() == 1);
    }

    @Test
    public void countTest() {
        Walls walls = new Walls();
        assertTrue(walls.count() == 0);

        Wall wallOne = new Wall(null, null, "Wall One");
        walls.add(Direction.RIGHT, wallOne);
        assertTrue(walls.count() == 1);

        Wall wallTwo = new Wall(null, null, "Wall Two");
        walls.add(Direction.LEFT, wallTwo);
        assertTrue(walls.count() == 2);

        Wall wallThree = new Wall(null, null, "Wall Three");
        walls.add(Direction.BACK, wallTwo);
        assertTrue(walls.count() == 3);
    }

    @Test
    public void getImageTest() {
        Walls walls = new Walls();

        Wall wallOne = new Wall(null, null, "Wall One");
        walls.add(Direction.RIGHT, wallOne);

        Wall wallTwo = new Wall(null, null, "Wall Two");
        walls.add(Direction.LEFT, wallTwo);

        assertEquals(walls.getImage(Direction.LEFT), null);
    }

    @Test
    public void getWallTest() {
        Walls walls = new Walls();

        Wall wallOne = new Wall(null, null, "Wall One");
        walls.add(Direction.RIGHT, wallOne);

        Wall wallTwo = new Wall(null, null, "Wall Two");
        walls.add(Direction.LEFT, wallTwo);

        assertEquals(walls.getWall(Direction.RIGHT), wallOne);
        assertEquals(walls.getWall(Direction.LEFT), wallTwo);
    }

    @Test
    public void hasWallTest() {
        Walls walls = new Walls();

        Wall wallOne = new Wall(null, null, "Wall One");
        Wall wallTwo = new Wall(null, null, "Wall Two");
        Wall wallThree = new Wall(null, null, "Wall Three");

        walls.add(Direction.RIGHT, wallOne);
        walls.add(Direction.LEFT, wallTwo);

        assertTrue(walls.hasWall(Direction.RIGHT));
        assertTrue(walls.hasWall(Direction.LEFT));
        assertFalse(walls.hasWall(Direction.BACK));
        assertFalse(walls.hasWall(Direction.FORWARD));
    }
}