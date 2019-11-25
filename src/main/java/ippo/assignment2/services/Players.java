package ippo.assignment2.services;

import ippo.assignment2.collections.Items;
import ippo.assignment2.collections.Walls;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Item;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;
import ippo.assignment2.models.Wall;

import javafx.scene.image.Image;
import java.io.IOException;

/**
 * @since 0.1.7
 */
public class Players implements IService {

    public static Players valueOf(String value) {
        return new Players();
    }
    /**
     *
     * @return
     * @since 0.1.7
     */
    public Player get(Boolean showImages) throws IOException {

        showImages = showImages == null ? true : showImages;

        Wall innerWallLeft = new Wall(null, null, "LEFT WALL");
        Wall innerWallRight = new Wall(null, null, "RIGHT WALL");

        Walls innerRoomWalls = new Walls();
        innerRoomWalls.add(Direction.LEFT, innerWallLeft);
        innerRoomWalls.add(Direction.RIGHT, innerWallRight);

        Room innerRoom = new Room(null, innerRoomWalls);

        Image playerItemOneImage = new Image(
                "https://i.guim.co.uk/img/media/72e7a42d0fdc7820d1a5e7a8f0baef1fc4ea50d9/0_491_3054_1832/master/3054.jpg?width=620&quality=45&auto=format&fit=max&dpr=2&s=836c679577a4d05899b78b63e088fae6"
        );
        Item playerItemOne = new Item(playerItemOneImage, "playerItemOne");

        Image playerItemTwoImage = new Image(
                "https://i.guim.co.uk/img/media/48fca4d8ef0949ab5d3ed3e4ac885ffb655a69a3/0_159_3298_1979/master/3298.jpg?width=620&quality=45&auto=format&fit=max&dpr=2&s=f406663d3ac3c6c38834ded9ccb69e40"
        );
        Item playerItemTwo = new Item(playerItemTwoImage, "playerItemTwo");

        Items playerItems = new Items();
        playerItems.add(playerItemOne);
        playerItems.add(playerItemTwo);

        Item roomItem = new Item(null, "roomItem");
        Items roomItems = new Items();
        roomItems.add(roomItem);

        Image imageLeft = null;
        Image imageRight = null;

        if (showImages == true) {
            imageLeft = new Image(
                    "https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/05/04/16/glasgow-main.jpg"
            );
            imageRight = new Image("https://sprudge.com/wp-content/uploads/2019/04/Edinburgh.jpg");
        }
        Wall wallLeft = new Wall(imageLeft, innerRoom, "INNER LEFT WALL");
        Wall wallRight = new Wall(imageRight, null, "INNER RIGHT WALL");

        Walls walls = new Walls();
        walls.add(Direction.LEFT, wallLeft);
        walls.add(Direction.RIGHT, wallRight);

        Room room = new Room(roomItems, walls);

        Player player = new Player(Direction.RIGHT, playerItems, room);

        return player;
    }
}
