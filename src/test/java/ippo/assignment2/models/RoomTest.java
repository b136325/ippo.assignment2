package ippo.assignment2.models;

import ippo.assignment2.collections.Items;
import ippo.assignment2.collections.Walls;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class RoomTest {

    @Test
    public void constructorNullTest() {
        Room room = new Room(null, null);
        assertNull(room.getItems());
        assertTrue(room.getWall(Direction.BACK) == null);
        assertTrue(room.getWall(Direction.FORWARD) == null);
        assertTrue(room.getWall(Direction.LEFT) == null);
        assertTrue(room.getWall(Direction.RIGHT) == null);
    }

    @Test
    public void constructorNotNullTest() {
        Wall wall = new Wall(null, null, null);
        Walls walls = new Walls();
        walls.add(Direction.RIGHT, wall);
        Items items = new Items();
        Room room = new Room(items, walls);

        assertEquals(room.getItems(), items);
        assertTrue(room.getItems().hashCode() == items.hashCode());
        assertTrue(room.getWall(Direction.RIGHT) == wall);
        assertTrue(room.getWall(Direction.RIGHT).hashCode() == wall.hashCode());
        assertNull(room.getWall(Direction.BACK));
        assertNull(room.getWall(Direction.FORWARD));
        assertNull(room.getWall(Direction.LEFT));
    }

    @Test
    public void addTest() {
        Items items = new Items();
        Room room = new Room(items, null);
        assertTrue(room.getItems().count() == 0);

        Item itemOne = new Item(null, "Item One");
        room.add(itemOne);
        assertTrue(room.getItems().count() == 1);

        Item itemTwo = new Item(null, "Item Two");
        room.add(itemTwo);
        assertTrue(room.getItems().count() == 2);
    }

    @Test
    public void getImageInvalid() {
        Wall wall = new Wall(null, null, null);
        Walls walls = new Walls();
        walls.add(Direction.RIGHT, wall);
        Room room = new Room(null, walls);

        assertTrue(room.getImage(Direction.RIGHT) == null);
    }

    @Test
    public void getImageValid() {
        Walls walls = new Walls();
        Room room = new Room(null, walls);

        assertTrue(room.getImage(Direction.RIGHT) == null);
    }

    @Test
    public void getItemsInvalid() {
        Walls walls = new Walls();
        Room room = new Room(null, walls);

        assertTrue(room.getItems() == null);
    }

    @Test
    public void getItemsValid() {
        Walls walls = new Walls();
        Items items = new Items();
        Room room = new Room(items, walls);

        assertTrue(room.getItems() == items);
        assertTrue(room.getItems().hashCode() == items.hashCode());
    }

    @Test
    public void getWallInvalid() {
        Walls walls = new Walls();
        Room room = new Room(null, walls);

        assertNull(room.getWall(Direction.BACK));
        assertNull(room.getWall(Direction.FORWARD));
        assertNull(room.getWall(Direction.LEFT));
        assertNull(room.getWall(Direction.RIGHT));
    }

    @Test
    public void getWallValid() {
        Wall wallRight = new Wall(null, null, "Wall Right");
        Walls walls = new Walls();
        walls.add(Direction.RIGHT, wallRight);
        Room room = new Room(null, walls);

        assertTrue(room.getWall(Direction.RIGHT) == wallRight);
        assertTrue(room.getWall(Direction.RIGHT).hashCode() == wallRight.hashCode());

        assertNull(room.getWall(Direction.BACK));
        assertNull(room.getWall(Direction.FORWARD));
        assertNull(room.getWall(Direction.LEFT));
    }

    @Test
    public void hasWallInvalid() {
        Walls walls = new Walls();
        Room room = new Room(null, walls);

        assertFalse(room.hasWall(Direction.BACK));
        assertFalse(room.hasWall(Direction.FORWARD));
        assertFalse(room.hasWall(Direction.LEFT));
        assertFalse(room.hasWall(Direction.RIGHT));
    }

    @Test
    public void hasWallNoWalls() {
        Room room = new Room(null, null);

        assertFalse(room.hasWall(Direction.BACK));
        assertFalse(room.hasWall(Direction.FORWARD));
        assertFalse(room.hasWall(Direction.LEFT));
        assertFalse(room.hasWall(Direction.RIGHT));
    }

    @Test
    public void removeTest() {
        Items items = new Items();
        Room room = new Room(items, null);

        Item itemOne = new Item(null, "Item One");
        Item itemTwo = new Item(null, "Item Two");
        Item itemThree = new Item(null, "Item Three");

        room.add(itemOne);
        room.add(itemTwo);
        room.add(itemThree);

        assertTrue(room.getItems().count() == 3);

        room.remove(itemOne);
        assertTrue(room.getItems().count() == 2);
        assertFalse(room.remove(itemOne));

        room.remove(itemTwo);
        assertTrue(room.getItems().count() == 1);
        assertFalse(room.remove(itemTwo));

        room.remove(itemThree);
        assertTrue(room.getItems().count() == 0);
        assertFalse(room.remove(itemThree));
    }
}
