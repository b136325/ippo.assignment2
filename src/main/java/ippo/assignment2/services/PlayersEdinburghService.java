package ippo.assignment2.services;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.collections.WallsCollection;
import ippo.assignment2.models.*;
import javafx.scene.image.Image;

/**
 * A service that returns 'manually' constructed Edinburgh related model data.
 *
 * @since 0.1.7
 */
public class PlayersEdinburghService implements IService {

    /**
     * Return a populated Player model for a series of Edinburgh related rooms.
     *
     * @return A Player model.
     *
     * @since 0.4.2
     */
    public Player get(Boolean showImages) {

        // NOTE: The unit test for PlayersService will fail
        // due to a threading issue if images are included.
        showImages = showImages == null ? true : showImages;

        Room adamSmithRoom = this.createAdamSmithRoom(showImages);
        Room georgeFourRoom = this.createGeorgeFourthRoom(showImages);
        Room victoriaStreetTopRoom = this.createVictoriaStreetTopRoom(showImages);
        Room victoriaStreetMiddleRoom = this.createVictoriaStreetMiddleRoom(showImages);
        Room victoriaStreetBottomRoom = this.createVictoriaStreetBottomRoom(showImages);

        // Add relationships from the end SOUTH to the start.
        victoriaStreetBottomRoom.getWall(Direction.SOUTH).setRoom(victoriaStreetMiddleRoom);
        victoriaStreetMiddleRoom.getWall(Direction.SOUTH).setRoom(victoriaStreetTopRoom);
        victoriaStreetTopRoom.getWall(Direction.SOUTH).setRoom(georgeFourRoom);
        georgeFourRoom.getWall(Direction.SOUTH).setRoom(adamSmithRoom);

        adamSmithRoom.getWall(Direction.NORTH).setRoom(georgeFourRoom);
        georgeFourRoom.getWall(Direction.NORTH).setRoom(victoriaStreetTopRoom);
        victoriaStreetTopRoom.getWall(Direction.NORTH).setRoom(victoriaStreetMiddleRoom);
        victoriaStreetMiddleRoom.getWall(Direction.NORTH).setRoom(victoriaStreetBottomRoom);

        ItemsCollection playerItems = this.createPlayerItems(showImages);
        Player player = new Player(Direction.NORTH, playerItems, adamSmithRoom, "Username1");
        return player;
    }
    /**
     * Create items for the 'Adam Smith' room.
     *
     * @param showImages Indicates whether or not images should be shown.
     * @return A collection of items.
     *
     * @since 0.4.3
     */
    private ItemsCollection createAdamSmithItems(Boolean showImages) {
        Image goldImage = null;
        Image suitcaseImage = null;

        if (showImages == true) {
            goldImage = new Image("images/items/gold.png");
            suitcaseImage = new Image("images/items/suitcase.png");
        }

        Item goldItem = new Item(goldImage, "Gold");
        Item suitcaseItem = new Item(suitcaseImage, "Suitcase");

        ItemsCollection items = new ItemsCollection();
        items.add(goldItem);
        items.add(suitcaseItem);

        return items;
    }

    /**
     * Create a room based upon the Royal Mile around the Adam Smith monument.
     *
     * @param showImages Indicates whether or not images should be shown.
     * @return A room model.
     *
     * @since 0.4.2
     */
    private Room createAdamSmithRoom(Boolean showImages) {
        Image imageSouth = null;
        Image imageWest = null;
        Image imageEast = null;
        Image imageNorth = null;

        if (showImages == true) {
            imageSouth = new Image("images/edinburgh/adam_smith_south.jpg");
            imageWest = new Image("images/edinburgh/adam_smith_west.jpg");
            imageEast = new Image("images/edinburgh/adam_smith_east.jpg");
            imageNorth = new Image("images/edinburgh/adam_smith_north.jpg");
        }

        Wall wallSouth = new Wall(imageSouth, null, "SOUTH");
        Wall wallLeft = new Wall(imageWest, null, "WEST");
        Wall wallRight = new Wall(imageEast, null, "EAST");
        Wall wallNorth = new Wall(imageNorth, null, "NORTH");

        WallsCollection walls = new WallsCollection();
        walls.add(Direction.SOUTH, wallSouth);
        walls.add(Direction.WEST, wallLeft);
        walls.add(Direction.EAST, wallRight);
        walls.add(Direction.NORTH, wallNorth);

        ItemsCollection items = this.createAdamSmithItems(showImages);
        Room room = new Room(items, walls, "Adam Smith");
        return room;
    }

    /**
     * Create a room based upon the start of George the Fourth Bridge.
     *
     * @param showImages Indicates whether or not images should be shown.
     * @return A room model.
     *
     * @since 0.4.2
     */
    private Room createGeorgeFourthRoom(Boolean showImages) {
        Image imageSouth = null;
        Image imageNorth = null;

        if (showImages == true) {
            imageSouth = new Image("images/edinburgh/george_four_south.jpg");
            imageNorth = new Image("images/edinburgh/george_four_north.jpg");
        }

        Wall wallSouth = new Wall(imageSouth, null, "SOUTH");
        Wall wallNorth = new Wall(imageNorth, null, "NORTH");

        WallsCollection walls = new WallsCollection();
        walls.add(Direction.SOUTH, wallSouth);
        walls.add(Direction.NORTH, wallNorth);

        Room room = new Room(null, walls, "George Fourth");
        return room;
    }

    /**
     * Create player items.
     *
     * @param showImages Indicates whether or not images should be shown.
     * @return A collection of items.
     *
     * @since 0.4.3
     */
    private ItemsCollection createPlayerItems(Boolean showImages) {
        Image homeImage = null;
        Image leafImage = null;
        
        if (showImages == true) {
            homeImage = new Image("images/items/home.png");
            leafImage = new Image("images/items/leaf.png");
        }

        Item homeItem = new Item(homeImage, "Home");
        Item leafItem = new Item(leafImage, "Leaf");

        ItemsCollection items = new ItemsCollection();
        items.add(homeItem);
        items.add(leafItem);

        return items;
    }

    /**
     * Create a room based upon the top of Victoria Street.
     *
     * @param showImages Indicates whether or not images should be shown.
     * @return A room model.
     *
     * @since 0.4.2
     */
    private Room createVictoriaStreetTopRoom(Boolean showImages) {
        Image imageSouth = null;
        Image imageNorth = null;

        if (showImages == true) {
            imageSouth = new Image("images/edinburgh/victoria_street_top_south.jpg");
            imageNorth = new Image("images/edinburgh/victoria_street_top_north.jpg");
        }

        Wall wallSouth = new Wall(imageSouth, null, "SOUTH");
        Wall wallNorth = new Wall(imageNorth, null, "NORTH");

        WallsCollection walls = new WallsCollection();
        walls.add(Direction.SOUTH, wallSouth);
        walls.add(Direction.NORTH, wallNorth);

        Room room = new Room(null, walls, "Victoria Street Top");
        return room;
    }

    /**
     * Create a items for the middle of Victoria Street.
     *
     * @param showImages Indicates whether or not images should be shown.
     * @return A collection of items.
     *
     * @since 0.4.3
     */
    private ItemsCollection createVictoriaStreetMiddleItems(Boolean showImages) {
        Image circlesImage = null;
        Image logoImage = null;

        if (showImages == true) {
            circlesImage = new Image("images/items/circles.png");
            logoImage = new Image("images/items/logo.png");
        }

        Item circlesItem = new Item(circlesImage, "Circles");
        Item logoItem = new Item(logoImage, "Logo");

        ItemsCollection items = new ItemsCollection();
        items.add(circlesItem);
        items.add(logoItem);

        return items;
    }

    /**
     * Create a room based upon the middle of Victoria Street.
     *
     * @param showImages Indicates whether or not images should be shown.
     * @return A room model.
     *
     * @since 0.4.2
     */
    private Room createVictoriaStreetMiddleRoom(Boolean showImages) {
        Image imageSouth = null;
        Image imageNorth = null;

        if (showImages == true) {
            imageSouth = new Image("images/edinburgh/victoria_street_mid_south.jpg");
            imageNorth = new Image("images/edinburgh/victoria_street_mid_north.jpg");
        }

        Wall wallSouth = new Wall(imageSouth, null, "SOUTH");
        Wall wallNorth = new Wall(imageNorth, null, "NORTH");

        WallsCollection walls = new WallsCollection();
        walls.add(Direction.SOUTH, wallSouth);
        walls.add(Direction.NORTH, wallNorth);

        ItemsCollection items = this.createVictoriaStreetMiddleItems(showImages);
        Room room = new Room(items, walls, "Victoria Street Middle");
        return room;
    }

    /**
     * Create a room based upon the bottom of Victoria Street.
     *
     * @param showImages Indicates whether or not images should be shown.
     * @return A room model.
     *
     * @since 0.4.2
     */
    private Room createVictoriaStreetBottomRoom(Boolean showImages) {
        Image imageSouth = null;
        Image imageWest = null;
        Image imageEast = null;

        if (showImages == true) {
            imageSouth = new Image("images/edinburgh/victoria_street_bottom_south.jpg");
            imageWest = new Image("images/edinburgh/victoria_street_bottom_west.jpg");
            imageEast = new Image("images/edinburgh/victoria_street_bottom_east.jpg");
        }

        Wall wallSouth = new Wall(imageSouth, null, "SOUTH");
        Wall wallWest = new Wall(imageWest, null, "Left");
        Wall wallEast = new Wall(imageEast, null, "Right");

        WallsCollection walls = new WallsCollection();
        walls.add(Direction.SOUTH, wallSouth);
        walls.add(Direction.WEST, wallWest);
        walls.add(Direction.EAST, wallEast);

        Room room = new Room(null, walls, "Victoria Street Bottom");
        return room;
    }
}
