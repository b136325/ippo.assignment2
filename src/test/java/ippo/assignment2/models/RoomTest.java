package ippo.assignment2.models;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.collections.WallsCollection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class RoomTest {

    @Test
    public void constructorNullTest() {
        Room room = new Room(null, null, null);
        assertNull(room.getItems());
        assertTrue(room.getWall(Direction.SOUTH) == null);
        assertTrue(room.getWall(Direction.NORTH) == null);
        assertTrue(room.getWall(Direction.WEST) == null);
        assertTrue(room.getWall(Direction.EAST) == null);
    }

    @Test
    public void constructorNotNullTest() {
        Wall wall = new Wall(null, null, null);
        WallsCollection walls = new WallsCollection();
        walls.add(Direction.EAST, wall);
        ItemsCollection items = new ItemsCollection();
        Room room = new Room(items, walls, null);

        assertEquals(room.getItems(), items);
        assertTrue(room.getItems().hashCode() == items.hashCode());
        assertTrue(room.getWall(Direction.EAST) == wall);
        assertTrue(room.getWall(Direction.EAST).hashCode() == wall.hashCode());
        assertNull(room.getWall(Direction.SOUTH));
        assertNull(room.getWall(Direction.NORTH));
        assertNull(room.getWall(Direction.WEST));
    }

    @Test
    public void addTest() {
        ItemsCollection items = new ItemsCollection();
        Room room = new Room(items, null, null);
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
        WallsCollection walls = new WallsCollection();
        walls.add(Direction.EAST, wall);
        Room room = new Room(null, walls, null);

        assertTrue(room.getImage(Direction.EAST) == null);
    }

    @Test
    public void getImageValid() {
        WallsCollection walls = new WallsCollection();
        Room room = new Room(null, walls, null);

        assertTrue(room.getImage(Direction.EAST) == null);
    }

    @Test
    public void getItemsInvalid() {
        WallsCollection walls = new WallsCollection();
        Room room = new Room(null, walls, null);

        assertTrue(room.getItems() == null);
    }

    @Test
    public void getItemsValid() {
        WallsCollection walls = new WallsCollection();
        ItemsCollection items = new ItemsCollection();
        Room room = new Room(items, walls, null);

        assertTrue(room.getItems() == items);
        assertTrue(room.getItems().hashCode() == items.hashCode());
    }

    @Test
    public void getWallInvalid() {
        WallsCollection walls = new WallsCollection();
        Room room = new Room(null, walls, null);

        assertNull(room.getWall(Direction.SOUTH));
        assertNull(room.getWall(Direction.NORTH));
        assertNull(room.getWall(Direction.WEST));
        assertNull(room.getWall(Direction.EAST));
    }

    @Test
    public void getWallValid() {
        Wall wallRight = new Wall(null, null, "Wall Right");
        WallsCollection walls = new WallsCollection();
        walls.add(Direction.EAST, wallRight);
        Room room = new Room(null, walls, null);

        assertTrue(room.getWall(Direction.EAST) == wallRight);
        assertTrue(room.getWall(Direction.EAST).hashCode() == wallRight.hashCode());

        assertNull(room.getWall(Direction.SOUTH));
        assertNull(room.getWall(Direction.NORTH));
        assertNull(room.getWall(Direction.WEST));
    }

    @Test
    public void hasWallInvalid() {
        WallsCollection walls = new WallsCollection();
        Room room = new Room(null, walls, null);

        assertFalse(room.hasWall(Direction.SOUTH));
        assertFalse(room.hasWall(Direction.NORTH));
        assertFalse(room.hasWall(Direction.WEST));
        assertFalse(room.hasWall(Direction.EAST));
    }

    @Test
    public void hasWallNoWalls() {
        Room room = new Room(null, null, null);

        assertFalse(room.hasWall(Direction.SOUTH));
        assertFalse(room.hasWall(Direction.NORTH));
        assertFalse(room.hasWall(Direction.WEST));
        assertFalse(room.hasWall(Direction.EAST));
    }

    @Test
    public void removeTest() {
        ItemsCollection items = new ItemsCollection();
        Room room = new Room(items, null, null);

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
