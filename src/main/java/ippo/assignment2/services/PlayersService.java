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
 * @since 0.1.7
 */
public class PlayersService implements IService {

    /**
     *
     * @return
     * @since 0.1.7
     */
    public Player get(Boolean showImages) {

        showImages = showImages == null ? true : showImages;

        Wall innerWallLeft = new Wall(null, null, "LEFT WALL");
        Wall innerWallRight = new Wall(null, null, "RIGHT WALL");

        WallsCollection innerRoomWalls = new WallsCollection();
        innerRoomWalls.add(Direction.LEFT, innerWallLeft);
        innerRoomWalls.add(Direction.RIGHT, innerWallRight);

        Room innerRoom = new Room(null, innerRoomWalls);

        Image playerItemOneImage = new Image("images/edinburgh.jpg");
        Item playerItemOne = new Item(playerItemOneImage, "playerItemOne");

        Image playerItemTwoImage = new Image(
                "images/glasgow.jpg"
        );
        Item playerItemTwo = new Item(playerItemTwoImage, "playerItemTwo");

        ItemsCollection playerItems = new ItemsCollection();
        playerItems.add(playerItemOne);
        playerItems.add(playerItemTwo);

        Image roomItemOneImage = new Image(
                "images/dundee.jpg"
        );
        Item roomItem = new Item(roomItemOneImage, "roomItem");
        ItemsCollection roomItems = new ItemsCollection();
        roomItems.add(roomItem);

        Image imageLeft = null;
        Image imageRight = null;

        if (showImages == true) {
            imageLeft = new Image(
                    "images/edinburgh.jpg"
            );
            imageRight = new Image("images/dundee.jpg");
        }
        Wall wallLeft = new Wall(imageLeft, innerRoom, "INNER LEFT WALL");
        Wall wallRight = new Wall(imageRight, null, "INNER RIGHT WALL");

        WallsCollection walls = new WallsCollection();
        walls.add(Direction.LEFT, wallLeft);
        walls.add(Direction.RIGHT, wallRight);

        Room room = new Room(roomItems, walls);

        Player player = new Player(Direction.RIGHT, playerItems, room, "Username1");

        return player;
    }
}
