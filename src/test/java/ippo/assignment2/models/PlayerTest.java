package ippo.assignment2.models;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.collections.WallsCollection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @Test
    public void constructorValid() {
        ItemsCollection items = new ItemsCollection();
        Room room = new Room(null, null, null);
        Player player = new Player(Direction.WEST, items, room, null);

        assertEquals(player.getDirection(), Direction.WEST);
        assertEquals(player.getItems(), items);
        assertEquals(player.getRoom(), room);
    }

    @Test
    public void getCurrentImageAssertRoomNull() {
        Player player = new Player(Direction.WEST, null, null, null);

        assertThrows(AssertionError.class, () -> {
            player.getCurrentImage(Direction.EAST);
        });
    }

    @Test
    public void getCurrentImageValid() {
        Wall wall = new Wall(null, null, null);
        WallsCollection walls = new WallsCollection();
        walls.add(Direction.EAST, wall);
        Room room = new Room(null, walls, null);
        Player player = new Player(Direction.WEST, null, room, null);

        assertEquals(player.getCurrentImage(Direction.EAST), null);
    }

    @Test
    public void getDirectionInValid() {
        Player player = new Player(null, null, null, null);

        assertEquals(player.getDirection(), null);
    }

    @Test
    public void getDirectionValid() {
        Player player = new Player(Direction.SOUTH, null, null, null);

        assertEquals(player.getDirection(), Direction.SOUTH);
    }
    @Test
    public void getItemsInValid() {
        Player player = new Player(null, null, null, null);
        assertEquals(player.getItems(), null);
    }

    @Test
    public void getItemsValid() {
        ItemsCollection items = new ItemsCollection();
        Player player = new Player(null, items, null, null);
        assertEquals(player.getItems(), items);
    }

    @Test
    public void getRoomInValid() {
        Room room = new Room(null, null, null);
        Player player = new Player(null, null, room, null);
        assertEquals(player.getRoom(), room);
    }

    @Test
    public void getRoomValid() {
        Player player = new Player(null, null, null, null);
        assertEquals(player.getRoom(), null);
    }

    @Test
    public void moveForwardAssertRoomNull() {
        Player player = new Player(Direction.SOUTH, null, null, null);

        assertThrows(AssertionError.class, () -> {
            player.moveForward();
        });
    }

    @Test
    public void moveForwardInValid() {
        Room innerRoom = new Room(null, null, null);
        Wall wall = new Wall(null, innerRoom, null);
        WallsCollection walls = new WallsCollection();
        walls.add(Direction.WEST, wall);
        Item item = new Item(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        Room outerRoom = new Room(roomItems, walls, null);
        Player player = new Player(Direction.SOUTH, null, outerRoom, null);

        player.moveForward();
        assertEquals(player.getRoom(), outerRoom);
    }

    @Test
    public void moveForwardInValidWall() {
        WallsCollection walls = new WallsCollection();
        walls.add(Direction.WEST, null);

        Item item = new Item(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        Room outerRoom = new Room(roomItems, walls, null);
        Player player = new Player(Direction.SOUTH, null, outerRoom, null);

        player.moveForward();
        assertEquals(player.getRoom(), outerRoom);
    }

    @Test
    public void moveForwardValid() {
        Room innerRoom = new Room(null, null, null);
        Wall wall = new Wall(null, innerRoom, null);
        WallsCollection walls = new WallsCollection();
        walls.add(Direction.SOUTH, wall);
        Item item = new Item(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        Room room = new Room(roomItems, walls, null);
        Player player = new Player(Direction.SOUTH, null, room, null);

        player.moveForward();
        assertEquals(player.getRoom(), innerRoom);
    }

    @Test
    public void moveForwardValidWallWithoutRoom() {
        Wall wall = new Wall(null, null, null);
        WallsCollection walls = new WallsCollection();
        walls.add(Direction.WEST, wall);

        Item item = new Item(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        Room outerRoom = new Room(roomItems, walls, null);
        Player player = new Player(Direction.WEST, null, outerRoom, null);

        player.moveForward();
        assertEquals(player.getRoom(), outerRoom);
    }

    @Test
    public void pickUpAssertionThrownWhenItemsNull() {
        Item item = new Item(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        Room roomNoItems = new Room(roomItems, null, null);
        Player player = new Player(null, null, roomNoItems, null);

        assertThrows(AssertionError.class, () -> {
            player.pickUp(item);
        });
    }

    @Test
    public void pickUpAssertionThrownWhenRoomNull() {
        Item item = new Item(null, null);
        ItemsCollection playerItems = new ItemsCollection();
        playerItems.add(item);
        Player player = new Player(null, playerItems, null, null);

        assertThrows(AssertionError.class, () -> {
            player.pickUp(item);
        });
    }

    @Test
    public void pickUpInValid() {
        Item item = new Item(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        Room roomNoItems = new Room(roomItems, null, null);
        ItemsCollection playerItems = new ItemsCollection();
        Player player = new Player(null, playerItems, roomNoItems, null);

        assertEquals(player.pickUp(item), false);
        assertEquals(playerItems.has(item), false);
    }

    @Test
    public void pickUpValid() {
        Item item = new Item(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        roomItems.add(item);
        Room roomNoItems = new Room(roomItems, null, null);
        ItemsCollection playerItems = new ItemsCollection();
        Player player = new Player(null, playerItems, roomNoItems, null);

        assertEquals(player.pickUp(item), true);
        assertEquals(playerItems.has(item), true);
    }

    @Test
    public void putDownAssertionThrownWhenItemsNull() {
        Item item = new Item(null, null);
        Room room = new Room(null, null, null);
        Player player = new Player(null, null, room, null);

        assertThrows(AssertionError.class, () -> {
            player.putDown(item);
        });
    }

    @Test
    public void putDownAssertionThrownWhenRoomNull() {
        Item item = new Item(null, null);
        ItemsCollection playerItems = new ItemsCollection();
        playerItems.add(item);
        Player player = new Player(null, playerItems, null, null);

        assertThrows(AssertionError.class, () -> {
            player.pickUp(item);
        });
    }

    @Test
    public void putDownInValid() {
        Item item = new Item(null, null);
        ItemsCollection playerItems = new ItemsCollection();
        ItemsCollection roomItems = new ItemsCollection();
        Room room = new Room(roomItems, null, null);
        Player player = new Player(null, playerItems, room, null);

        assertEquals(player.putDown(item), false);
        assertEquals(playerItems.has(item), false);
    }

    @Test
    public void putDownValid() {
        Item item = new Item(null, null);
        ItemsCollection playerItems = new ItemsCollection();
        playerItems.add(item);
        ItemsCollection roomItems = new ItemsCollection();
        Room room = new Room(roomItems, null, null);
        Player player = new Player(null, playerItems, room, null);

        assertEquals(player.putDown(item), true);
        assertEquals(playerItems.has(item), false);
    }

    @Test
    public void turnAssertionThrownWhenRoomNull() {
        Item item = new Item(null, null);
        ItemsCollection playerItems = new ItemsCollection();
        playerItems.add(item);
        Player player = new Player(null, playerItems, null, null);

        assertThrows(AssertionError.class, () -> {
            player.turn(Direction.SOUTH);
        });
    }

    @Test
    public void turnInvalid() {
        Wall wall = new Wall(null, null, null);
        WallsCollection walls = new WallsCollection();
        walls.add(Direction.SOUTH, wall);
        Room room = new Room(null, walls, null);
        Player player = new Player(null, null, room, null);
        player.turn(Direction.EAST);

        assertEquals(player.getDirection(), null);
    }

    @Test
    public void turnValid() {
        Wall wall = new Wall(null, null, null);
        WallsCollection walls = new WallsCollection();
        walls.add(Direction.SOUTH, wall);
        Room room = new Room(null, walls, null);
        Player player = new Player(null, null, room, null);
        player.turn(Direction.SOUTH);

        assertEquals(player.getDirection(), Direction.SOUTH);
    }
}
