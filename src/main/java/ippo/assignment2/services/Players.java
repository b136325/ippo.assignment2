package ippo.assignment2.services;

import ippo.assignment2.collections.Items;
import ippo.assignment2.collections.Walls;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Item;
import ippo.assignment2.models.PlayerObservable;
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
    public PlayerObservable get(Boolean showImages) throws IOException {

        showImages = showImages == null ? true : showImages;

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

        Image imageLeft = null;
        Image imageRight = null;

        if (showImages == true) {
            imageLeft = new Image("https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/05/04/16/glasgow-main.jpg");
            imageRight = new Image("https://sprudge.com/wp-content/uploads/2019/04/Edinburgh.jpg");
        }
        Wall wallLeft = new Wall(imageLeft, innerRoom);
        Wall wallRight = new Wall(imageRight, null);

        Walls walls = new Walls();
        walls.add(Direction.LEFT, wallLeft);
        walls.add(Direction.RIGHT, wallRight);

        Room room = new Room(roomItems, walls);

        PlayerObservable player = new PlayerObservable(Direction.RIGHT, playerItems, room);

        return player;
    }
}
