package ippo.assignment2.collections;

import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Wall;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WallsTest {

    @Test
    public void addTestWithDifferentDirectionKeys() {
        WallsCollection walls = new WallsCollection();
        assertTrue(walls.count() == 0);

        Wall wallOne = new Wall(null, null, "Wall One");
        walls.add(Direction.NORTH, wallOne);
        assertTrue(walls.count() == 1);

        Wall wallTwo = new Wall(null, null, "Wall Two");
        walls.add(Direction.SOUTH, wallTwo);
        assertTrue(walls.count() == 2);
    }

    @Test
    public void addTestWithSameDirectionKeys() {
        WallsCollection walls = new WallsCollection();
        assertTrue(walls.count() == 0);

        Wall wallOne = new Wall(null, null, "Wall One");
        walls.add(Direction.NORTH, wallOne);
        assertTrue(walls.count() == 1);

        Wall wallTwo = new Wall(null, null, "Wall Two");
        walls.add(Direction.NORTH, wallTwo);
        assertTrue(walls.count() == 1);
    }

    @Test
    public void countTest() {
        WallsCollection walls = new WallsCollection();
        assertTrue(walls.count() == 0);

        Wall wallOne = new Wall(null, null, "Wall One");
        walls.add(Direction.NORTH, wallOne);
        assertTrue(walls.count() == 1);

        Wall wallTwo = new Wall(null, null, "Wall Two");
        walls.add(Direction.EAST, wallTwo);
        assertTrue(walls.count() == 2);

        Wall wallThree = new Wall(null, null, "Wall Three");
        walls.add(Direction.SOUTH, wallTwo);
        assertTrue(walls.count() == 3);
    }

    @Test
    public void getImageTest() {
        WallsCollection walls = new WallsCollection();

        Wall wallOne = new Wall(null, null, "Wall One");
        walls.add(Direction.NORTH, wallOne);

        Wall wallTwo = new Wall(null, null, "Wall Two");
        walls.add(Direction.SOUTH, wallTwo);

        assertEquals(walls.getImage(Direction.SOUTH), null);
    }

    @Test
    public void getWallTest() {
        WallsCollection walls = new WallsCollection();

        Wall wallOne = new Wall(null, null, "Wall One");
        walls.add(Direction.NORTH, wallOne);

        Wall wallTwo = new Wall(null, null, "Wall Two");
        walls.add(Direction.SOUTH, wallTwo);

        assertEquals(walls.getWall(Direction.NORTH), wallOne);
        assertEquals(walls.getWall(Direction.SOUTH), wallTwo);
    }

    @Test
    public void hasWallTest() {
        WallsCollection walls = new WallsCollection();

        Wall wallOne = new Wall(null, null, "Wall One");
        Wall wallTwo = new Wall(null, null, "Wall Two");

        walls.add(Direction.NORTH, wallOne);
        walls.add(Direction.SOUTH, wallTwo);

        assertTrue(walls.hasWall(Direction.NORTH));
        assertTrue(walls.hasWall(Direction.SOUTH));
        assertFalse(walls.hasWall(Direction.EAST));
        assertFalse(walls.hasWall(Direction.WEST));
    }
}