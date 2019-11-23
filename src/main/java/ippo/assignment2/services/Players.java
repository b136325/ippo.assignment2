package ippo.assignment2.services;

import ippo.assignment2.collections.Items;
import ippo.assignment2.collections.Walls;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Item;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;
import ippo.assignment2.models.Wall;

/**
 * @since 0.1.7
 */
public class Players implements IService {

    /**
     *
     * @return
     * @since 0.1.7
     */
    public Player get() {

        Wall innerWallLeft = new Wall(null, null);
        Wall innerWallRight = new Wall(null, null);

        Walls innerRoomWalls = new Walls();
        innerRoomWalls.add(Direction.LEFT, innerWallLeft);
        innerRoomWalls.add(Direction.RIGHT, innerWallRight);

        Room innerRoom = new Room(null, innerRoomWalls);

        Item playerItem = new Item(null, "playerItem");
        Items playerItems = new Items();
        playerItems.add(playerItem);

        Item roomItem = new Item(null, "roomItem");
        Items roomItems = new Items();
        roomItems.add(roomItem);

        Wall wallLeft = new Wall(null, innerRoom);
        Wall wallRight = new Wall(null, null);

        Walls walls = new Walls();
        walls.add(Direction.LEFT, wallLeft);
        walls.add(Direction.RIGHT, wallRight);

        Room room = new Room(roomItems, walls);

        Player player = new Player(Direction.RIGHT, playerItems, room);

        return player;
    }
}
