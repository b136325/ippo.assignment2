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
        RoomModel room = new RoomModel(null, null);
        PlayerModel player = new PlayerModel(DirectionModel.LEFT, items, room);

        assertEquals(player.getDirection(), DirectionModel.LEFT);
        assertEquals(player.getItems(), items);
        assertEquals(player.getRoom(), room);
    }

    @Test
    public void getCurrentImageAssertRoomNull() {
        PlayerModel player = new PlayerModel(DirectionModel.LEFT, null, null);

        assertThrows(AssertionError.class, () -> {
            player.getCurrentImage(DirectionModel.RIGHT);
        });
    }

    @Test
    public void getCurrentImageValid() {
        WallModel wall = new WallModel(null, null);
        WallsCollection walls = new WallsCollection();
        walls.add(DirectionModel.RIGHT, wall);
        RoomModel room = new RoomModel(null, walls);
        PlayerModel player = new PlayerModel(DirectionModel.LEFT, null, room);

        assertEquals(player.getCurrentImage(DirectionModel.RIGHT), null);
    }

    @Test
    public void getDirectionInValid() {
        PlayerModel player = new PlayerModel(null, null, null);

        assertEquals(player.getDirection(), null);
    }

    @Test
    public void getDirectionValid() {
        PlayerModel player = new PlayerModel(DirectionModel.BACK, null, null);

        assertEquals(player.getDirection(), DirectionModel.BACK);
    }
    @Test
    public void getItemsInValid() {
        PlayerModel player = new PlayerModel(null, null, null);
        assertEquals(player.getItems(), null);
    }

    @Test
    public void getItemsValid() {
        ItemsCollection items = new ItemsCollection();
        PlayerModel player = new PlayerModel(null, items, null);
        assertEquals(player.getItems(), items);
    }

    @Test
    public void getRoomInValid() {
        RoomModel room = new RoomModel(null, null);
        PlayerModel player = new PlayerModel(null, null, room);
        assertEquals(player.getRoom(), room);
    }

    @Test
    public void getRoomValid() {
        PlayerModel player = new PlayerModel(null, null, null);
        assertEquals(player.getRoom(), null);
    }

    @Test
    public void moveForwardAssertRoomNull() {
        PlayerModel player = new PlayerModel(DirectionModel.BACK, null, null);

        assertThrows(AssertionError.class, () -> {
            player.moveForward();
        });
    }

    @Test
    public void moveForwardInValid() {
        RoomModel innerRoom = new RoomModel(null, null);
        WallModel wall = new WallModel(null, innerRoom);
        WallsCollection walls = new WallsCollection();
        walls.add(DirectionModel.LEFT, wall);
        ItemModel item = new ItemModel(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        RoomModel outerRoom = new RoomModel(roomItems, walls);
        PlayerModel player = new PlayerModel(DirectionModel.BACK, null, outerRoom);

        player.moveForward();
        assertEquals(player.getRoom(), outerRoom);
    }

    @Test
    public void moveForwardInValidWall() {
        WallsCollection walls = new WallsCollection();
        walls.add(DirectionModel.LEFT, null);

        ItemModel item = new ItemModel(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        RoomModel outerRoom = new RoomModel(roomItems, walls);
        PlayerModel player = new PlayerModel(DirectionModel.BACK, null, outerRoom);

        player.moveForward();
        assertEquals(player.getRoom(), outerRoom);
    }

    @Test
    public void moveForwardValid() {
        RoomModel innerRoom = new RoomModel(null, null);
        WallModel wall = new WallModel(null, innerRoom);
        WallsCollection walls = new WallsCollection();
        walls.add(DirectionModel.BACK, wall);
        ItemModel item = new ItemModel(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        RoomModel room = new RoomModel(roomItems, walls);
        PlayerModel player = new PlayerModel(DirectionModel.BACK, null, room);

        player.moveForward();
        assertEquals(player.getRoom(), innerRoom);
    }

    @Test
    public void moveForwardValidWallWithoutRoom() {
        WallModel wall = new WallModel(null, null);
        WallsCollection walls = new WallsCollection();
        walls.add(DirectionModel.LEFT, wall);

        ItemModel item = new ItemModel(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        RoomModel outerRoom = new RoomModel(roomItems, walls);
        PlayerModel player = new PlayerModel(DirectionModel.LEFT, null, outerRoom);

        player.moveForward();
        assertEquals(player.getRoom(), outerRoom);
    }

    @Test
    public void pickUpAssertionThrownWhenItemsNull() {
        ItemModel item = new ItemModel(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        RoomModel roomNoItems = new RoomModel(roomItems, null);
        PlayerModel player = new PlayerModel(null, null, roomNoItems);

        assertThrows(AssertionError.class, () -> {
            player.pickUp(item);
        });
    }

    @Test
    public void pickUpAssertionThrownWhenRoomNull() {
        ItemModel item = new ItemModel(null, null);
        ItemsCollection playerItems = new ItemsCollection();
        playerItems.add(item);
        PlayerModel player = new PlayerModel(null, playerItems, null);

        assertThrows(AssertionError.class, () -> {
            player.pickUp(item);
        });
    }

    @Test
    public void pickUpInValid() {
        ItemModel item = new ItemModel(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        RoomModel roomNoItems = new RoomModel(roomItems, null);
        ItemsCollection playerItems = new ItemsCollection();
        PlayerModel player = new PlayerModel(null, playerItems, roomNoItems);

        assertEquals(player.pickUp(item), false);
        assertEquals(playerItems.has(item), false);
    }

    @Test
    public void pickUpValid() {
        ItemModel item = new ItemModel(null, null);
        ItemsCollection roomItems = new ItemsCollection();
        roomItems.add(item);
        RoomModel roomNoItems = new RoomModel(roomItems, null);
        ItemsCollection playerItems = new ItemsCollection();
        PlayerModel player = new PlayerModel(null, playerItems, roomNoItems);

        assertEquals(player.pickUp(item), true);
        assertEquals(playerItems.has(item), true);
    }

    @Test
    public void putDownAssertionThrownWhenItemsNull() {
        ItemModel item = new ItemModel(null, null);
        RoomModel room = new RoomModel(null, null);
        PlayerModel player = new PlayerModel(null, null, room);

        assertThrows(AssertionError.class, () -> {
            player.putDown(item);
        });
    }

    @Test
    public void putDownAssertionThrownWhenRoomNull() {
        ItemModel item = new ItemModel(null, null);
        ItemsCollection playerItems = new ItemsCollection();
        playerItems.add(item);
        PlayerModel player = new PlayerModel(null, playerItems, null);

        assertThrows(AssertionError.class, () -> {
            player.pickUp(item);
        });
    }

    @Test
    public void putDownInValid() {
        ItemModel item = new ItemModel(null, null);
        ItemsCollection playerItems = new ItemsCollection();
        ItemsCollection roomItems = new ItemsCollection();
        RoomModel room = new RoomModel(roomItems, null);
        PlayerModel player = new PlayerModel(null, playerItems, room);

        assertEquals(player.putDown(item), false);
        assertEquals(playerItems.has(item), false);
    }

    @Test
    public void putDownValid() {
        ItemModel item = new ItemModel(null, null);
        ItemsCollection playerItems = new ItemsCollection();
        playerItems.add(item);
        ItemsCollection roomItems = new ItemsCollection();
        RoomModel room = new RoomModel(roomItems, null);
        PlayerModel player = new PlayerModel(null, playerItems, room);

        assertEquals(player.putDown(item), true);
        assertEquals(playerItems.has(item), false);
    }

    @Test
    public void turnAssertionThrownWhenRoomNull() {
        ItemModel item = new ItemModel(null, null);
        ItemsCollection playerItems = new ItemsCollection();
        playerItems.add(item);
        PlayerModel player = new PlayerModel(null, playerItems, null);

        assertThrows(AssertionError.class, () -> {
            player.turn(DirectionModel.BACK);
        });
    }

    @Test
    public void turnInvalid() {
        WallModel wall = new WallModel(null, null);
        WallsCollection walls = new WallsCollection();
        walls.add(DirectionModel.BACK, wall);
        RoomModel room = new RoomModel(null, walls);
        PlayerModel player = new PlayerModel(null, null, room);
        player.turn(DirectionModel.RIGHT);

        assertEquals(player.getDirection(), null);
    }

    @Test
    public void turnValid() {
        WallModel wall = new WallModel(null, null);
        WallsCollection walls = new WallsCollection();
        walls.add(DirectionModel.BACK, wall);
        RoomModel room = new RoomModel(null, walls);
        PlayerModel player = new PlayerModel(null, null, room);
        player.turn(DirectionModel.BACK);

        assertEquals(player.getDirection(), DirectionModel.BACK);
    }
}
