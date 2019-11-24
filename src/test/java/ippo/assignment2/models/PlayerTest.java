package ippo.assignment2.models;

import ippo.assignment2.collections.Items;
import ippo.assignment2.collections.Walls;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @Test
    public void constructorValid() {
        Items items = new Items();
        Room room = new Room(null, null);
        PlayerObservable player = new PlayerObservable(Direction.LEFT, items, room);

        assertEquals(player.getDirection(), Direction.LEFT);
        assertEquals(player.getItems(), items);
        assertEquals(player.getRoom(), room);
    }

    @Test
    public void getCurrentImageAssertRoomNull() {
        PlayerObservable player = new PlayerObservable(Direction.LEFT, null, null);

        assertThrows(AssertionError.class, () -> {
            player.getCurrentImage(Direction.RIGHT);
        });
    }

    @Test
    public void getCurrentImageValid() {
        Wall wall = new Wall(null, null);
        Walls walls = new Walls();
        walls.add(Direction.RIGHT, wall);
        Room room = new Room(null, walls);
        PlayerObservable player = new PlayerObservable(Direction.LEFT, null, room);

        assertEquals(player.getCurrentImage(Direction.RIGHT), null);
    }

    @Test
    public void getDirectionInValid() {
        PlayerObservable player = new PlayerObservable(null, null, null);

        assertEquals(player.getDirection(), null);
    }

    @Test
    public void getDirectionValid() {
        PlayerObservable player = new PlayerObservable(Direction.BACK, null, null);

        assertEquals(player.getDirection(), Direction.BACK);
    }
    @Test
    public void getItemsInValid() {
        PlayerObservable player = new PlayerObservable(null, null, null);
        assertEquals(player.getItems(), null);
    }

    @Test
    public void getItemsValid() {
        Items items = new Items();
        PlayerObservable player = new PlayerObservable(null, items, null);
        assertEquals(player.getItems(), items);
    }

    @Test
    public void getRoomInValid() {
        Room room = new Room(null, null);
        PlayerObservable player = new PlayerObservable(null, null, room);
        assertEquals(player.getRoom(), room);
    }

    @Test
    public void getRoomValid() {
        PlayerObservable player = new PlayerObservable(null, null, null);
        assertEquals(player.getRoom(), null);
    }

    @Test
    public void moveForwardAssertRoomNull() {
        PlayerObservable player = new PlayerObservable(Direction.BACK, null, null);

        assertThrows(AssertionError.class, () -> {
            player.moveForward();
        });
    }

    @Test
    public void moveForwardInValid() {
        Room innerRoom = new Room(null, null);
        Wall wall = new Wall(null, innerRoom);
        Walls walls = new Walls();
        walls.add(Direction.LEFT, wall);
        Item item = new Item(null, null);
        Items roomItems = new Items();
        Room outerRoom = new Room(roomItems, walls);
        PlayerObservable player = new PlayerObservable(Direction.BACK, null, outerRoom);

        player.moveForward();
        assertEquals(player.getRoom(), outerRoom);
    }

    @Test
    public void moveForwardInValidWall() {
        Walls walls = new Walls();
        walls.add(Direction.LEFT, null);

        Item item = new Item(null, null);
        Items roomItems = new Items();
        Room outerRoom = new Room(roomItems, walls);
        PlayerObservable player = new PlayerObservable(Direction.BACK, null, outerRoom);

        player.moveForward();
        assertEquals(player.getRoom(), outerRoom);
    }

    @Test
    public void moveForwardValid() {
        Room innerRoom = new Room(null, null);
        Wall wall = new Wall(null, innerRoom);
        Walls walls = new Walls();
        walls.add(Direction.BACK, wall);
        Item item = new Item(null, null);
        Items roomItems = new Items();
        Room room = new Room(roomItems, walls);
        PlayerObservable player = new PlayerObservable(Direction.BACK, null, room);

        player.moveForward();
        assertEquals(player.getRoom(), innerRoom);
    }

    @Test
    public void moveForwardValidWallWithoutRoom() {
        Wall wall = new Wall(null, null);
        Walls walls = new Walls();
        walls.add(Direction.LEFT, wall);

        Item item = new Item(null, null);
        Items roomItems = new Items();
        Room outerRoom = new Room(roomItems, walls);
        PlayerObservable player = new PlayerObservable(Direction.LEFT, null, outerRoom);

        player.moveForward();
        assertEquals(player.getRoom(), outerRoom);
    }

    @Test
    public void pickUpAssertionThrownWhenItemsNull() {
        Item item = new Item(null, null);
        Items roomItems = new Items();
        Room roomNoItems = new Room(roomItems, null);
        PlayerObservable player = new PlayerObservable(null, null, roomNoItems);

        assertThrows(AssertionError.class, () -> {
            player.pickUp(item);
        });
    }

    @Test
    public void pickUpAssertionThrownWhenRoomNull() {
        Item item = new Item(null, null);
        Items playerItems = new Items();
        playerItems.add(item);
        PlayerObservable player = new PlayerObservable(null, playerItems, null);

        assertThrows(AssertionError.class, () -> {
            player.pickUp(item);
        });
    }

    @Test
    public void pickUpInValid() {
        Item item = new Item(null, null);
        Items roomItems = new Items();
        Room roomNoItems = new Room(roomItems, null);
        Items playerItems = new Items();
        PlayerObservable player = new PlayerObservable(null, playerItems, roomNoItems);

        assertEquals(player.pickUp(item), false);
        assertEquals(playerItems.has(item), false);
    }

    @Test
    public void pickUpValid() {
        Item item = new Item(null, null);
        Items roomItems = new Items();
        roomItems.add(item);
        Room roomNoItems = new Room(roomItems, null);
        Items playerItems = new Items();
        PlayerObservable player = new PlayerObservable(null, playerItems, roomNoItems);

        assertEquals(player.pickUp(item), true);
        assertEquals(playerItems.has(item), true);
    }

    @Test
    public void putDownAssertionThrownWhenItemsNull() {
        Item item = new Item(null, null);
        Room room = new Room(null, null);
        PlayerObservable player = new PlayerObservable(null, null, room);

        assertThrows(AssertionError.class, () -> {
            player.putDown(item);
        });
    }

    @Test
    public void putDownAssertionThrownWhenRoomNull() {
        Item item = new Item(null, null);
        Items playerItems = new Items();
        playerItems.add(item);
        PlayerObservable player = new PlayerObservable(null, playerItems, null);

        assertThrows(AssertionError.class, () -> {
            player.pickUp(item);
        });
    }

    @Test
    public void putDownInValid() {
        Item item = new Item(null, null);
        Items playerItems = new Items();
        Items roomItems = new Items();
        Room room = new Room(roomItems, null);
        PlayerObservable player = new PlayerObservable(null, playerItems, room);

        assertEquals(player.putDown(item), false);
        assertEquals(playerItems.has(item), false);
    }

    @Test
    public void putDownValid() {
        Item item = new Item(null, null);
        Items playerItems = new Items();
        playerItems.add(item);
        Items roomItems = new Items();
        Room room = new Room(roomItems, null);
        PlayerObservable player = new PlayerObservable(null, playerItems, room);

        assertEquals(player.putDown(item), true);
        assertEquals(playerItems.has(item), false);
    }

    @Test
    public void turnAssertionThrownWhenRoomNull() {
        Item item = new Item(null, null);
        Items playerItems = new Items();
        playerItems.add(item);
        PlayerObservable player = new PlayerObservable(null, playerItems, null);

        assertThrows(AssertionError.class, () -> {
            player.turn(Direction.BACK);
        });
    }

    @Test
    public void turnInvalid() {
        Wall wall = new Wall(null, null);
        Walls walls = new Walls();
        walls.add(Direction.BACK, wall);
        Room room = new Room(null, walls);
        PlayerObservable player = new PlayerObservable(null, null, room);
        player.turn(Direction.RIGHT);

        assertEquals(player.getDirection(), null);
    }

    @Test
    public void turnValid() {
        Wall wall = new Wall(null, null);
        Walls walls = new Walls();
        walls.add(Direction.BACK, wall);
        Room room = new Room(null, walls);
        PlayerObservable player = new PlayerObservable(null, null, room);
        player.turn(Direction.BACK);

        assertEquals(player.getDirection(), Direction.BACK);
    }
}
