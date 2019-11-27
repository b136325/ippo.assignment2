package ippo.assignment2.services;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.collections.WallsCollection;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Item;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;
import ippo.assignment2.models.Wall;
import javafx.scene.image.Image;

/**
 * A service that returns 'manually' constructed model data.
 *
 * @since 0.1.7
 */
public class PlayersService implements IService {

    /**
     * Return a populated Player model with the current room and any player items.
     *
     * @return A Player model.
     *
     * @since 0.1.7
     */
    public Player get(Boolean showImages) {

        // NOTE: The unit test for PlayersService will fail
        // due to a threading issue if images are included.
        showImages = showImages == null ? true : showImages;

        // INNER ROOM
        WallsCollection innerRoomWalls = this.createInnerRoomWallsCollection();
        Room innerRoom = new Room(null, innerRoomWalls, null);

        // OUTER ROOM
        ItemsCollection outerRoomItems = this.createOuterRoomItemsCollection(showImages);
        WallsCollection outerRoomWalls = this.createOuterRoomWallsCollection(showImages, innerRoom);
        Room outerRoom = new Room(outerRoomItems, outerRoomWalls, null);

        // BACK REFERENCE BETWEEN INNER AND OUTER ROOM
        Wall innerBackWall = innerRoomWalls.getWall(Direction.SOUTH);
        innerBackWall.setRoom(outerRoom);

        // PLAYER
        ItemsCollection playerItems = this.createPlayerItems(showImages);
        Player player = new Player(Direction.NORTH, playerItems, outerRoom, "Username1");

        return player;
    }

    /**
     * Create a collection of Wall objects for the 'inner room'
     *
     * @return A Walls collection.
     *
     * @since 0.4.1
     */
    private WallsCollection createInnerRoomWallsCollection() {
        WallsCollection innerRoomWalls = new WallsCollection();

        Wall innerWallBack = new Wall(null, null, "BACK WALL");
        Wall innerWallRight = new Wall(null, null, "RIGHT WALL");

        innerRoomWalls.add(Direction.SOUTH, innerWallBack);
        innerRoomWalls.add(Direction.NORTH, innerWallRight);

        return innerRoomWalls;
    }

    /**
     * Create a collection of Item objects associated with the 'outer room'
     *
     * @return An Items collection.
     *
     * @since 0.4.1
     */
    private ItemsCollection createOuterRoomItemsCollection(Boolean showImages) {
        ItemsCollection outerRoomItems = new ItemsCollection();
        Image outerRoomItemOneImage = null;

        if (showImages == true) {
            outerRoomItemOneImage = new Image("images/scotland/dundee.jpg");
        }

        Item outerRoomItem = new Item(outerRoomItemOneImage, "roomItem");
        outerRoomItems.add(outerRoomItem);

        return outerRoomItems;
    }

    /**
     * Create a collection of Walls objects associated with the 'outer room'
     *
     * @return A Walls collection.
     *
     * @since 0.4.1
     */
    private WallsCollection createOuterRoomWallsCollection(Boolean showImages, Room innerRoom) {
        Image outerRoomImageForward = null;
        Image outerRoomImageLeft = null;
        Image outerRoomImageRight = null;
        WallsCollection walls = new WallsCollection();

        if (showImages == true) {
            outerRoomImageForward = new Image("images/scotland/glasgow.jpg");
            outerRoomImageLeft = new Image("images/scotland/edinburgh.jpg");
            outerRoomImageRight = new Image("images/scotland/dundee.jpg");
        }

        Wall wallForward = new Wall(outerRoomImageForward, null, "OUTER FORWARD WALL");
        Wall wallLeft = new Wall(outerRoomImageLeft, innerRoom, "OUTER LEFT WALL");
        Wall wallRight = new Wall(outerRoomImageRight, null, "OUTER RIGHT WALL");

        walls.add(Direction.NORTH, wallForward);
        walls.add(Direction.WEST, wallLeft);
        walls.add(Direction.EAST, wallRight);

        return walls;
    }

    /**
     * Create a collection of Item objects associated with the player.
     *
     * @return An Items collection.
     *
     * @since 0.4.1
     */
    private ItemsCollection createPlayerItems(Boolean showImages) {
        ItemsCollection playerItems = new ItemsCollection();
        Image playerItemOneImage = null;
        Image playerItemTwoImage = null;

        if (showImages == true) {
            playerItemOneImage = new Image("images/scotland/edinburgh.jpg");
            playerItemTwoImage = new Image("images/scotland/glasgow.jpg");
        }

        Item playerItemOne = new Item(playerItemOneImage, "playerItemOne");
        Item playerItemTwo = new Item(playerItemTwoImage, "playerItemTwo");

        playerItems.add(playerItemOne);
        playerItems.add(playerItemTwo);

        return playerItems;
    }
}
