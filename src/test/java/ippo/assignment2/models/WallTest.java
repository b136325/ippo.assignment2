package ippo.assignment2.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WallTest {

    @Test
    public void constructorNullTest() {
        Wall wall = new Wall(null, null, null);
        assertNull(wall.getImage());
        assertNull(wall.getRoom());
        assertNull(wall.getName());
    }

    @Test
    public void getNameTestInvalid() {
        Wall wall = new Wall(null, null, null);
        assertNull(wall.getName());
    }

    @Test
    public void getNameTestValid() {
        String wallName = "Wall One";
        Wall wall = new Wall(null, null, wallName);
        assertNull(wall.getImage());
        assertNull(wall.getRoom());
        assertTrue(wall.getName() == wallName);
    }

    @Test
    public void getNameTestValidWithRoom() {
        String wallName = "Wall One";
        Room room = new Room(null, null);
        Wall wall = new Wall(null, room, wallName);
        assertTrue(wall.getName() == wallName);
    }

    @Test
    public void getRoomTestInvalid() {
        Wall wall = new Wall(null, null, null);
        assertNull(wall.getRoom());
    }

    @Test
    public void getRoomTestValid() {
        Room room = new Room(null, null);
        Wall wall = new Wall(null, room, null);
        assertTrue(wall.getRoom() == room);
        assertTrue(wall.getRoom().hashCode() == room.hashCode());
    }

    @Test
    public void getRoomTestValidWithName() {
        String wallName = "Wall One";
        Room room = new Room(null, null);
        Wall wall = new Wall(null, room, wallName);
        assertTrue(wall.getRoom() == room);
    }

    @Test
    public void hasRoomInvalid() {
        Wall wall = new Wall(null, null, null);
        assertFalse(wall.hasRoom());
    }

    @Test
    public void hasRoomValid() {
        Room room = new Room(null, null);
        Wall wall = new Wall(null, room, null);
        assertTrue(wall.hasRoom());
    }
}
