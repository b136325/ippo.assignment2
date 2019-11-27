package ippo.assignment2.mocks;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.collections.WallsCollection;
import ippo.assignment2.models.*;
import javafx.scene.image.Image;

/**
 * A class whose static methods return mock data for tests concerning the RoomItemsController.
 *
 * @since 0.3.3
 */
public class RoomItemsControllerMock {

    /**
     * Return a 'complex' set of mock data containing a player with multiple children.
     *
     * @return
     *
     * @since 0.3.3
     */
    public static Player createMock() {
        // Construct the item Images.
        Image imageOne = new Image("/images/edinburgh.jpg");
        Image imageTwo = new Image("/images/glasgow.jpg");
        Image imageThree = new Image("/images/dundee.jpg");

        // Construct the Item objects.
        Item itemOne = new Item(imageOne, "Edinburgh");
        Item itemTwo = new Item(imageTwo, "Glasgow");
        Item itemThree = new Item(imageThree, "Dundee");

        // Add the constructed Item object to an Items collection.
        ItemsCollection playerItems = new ItemsCollection();
        playerItems.add(itemOne);
        playerItems.add(itemTwo);
        playerItems.add(itemThree);

        // Construct two Wall objects for the current room.
        Wall wallRight = new Wall(null, null, "Right");
        Wall wallLeft = new Wall(null, null, "Left");

        // Create a WallsCollection and populate it with the Wall objects created above.
        WallsCollection walls = new WallsCollection();
        walls.add(Direction.RIGHT, wallRight);
        walls.add(Direction.LEFT, wallLeft);

        // Create an ItemsCollection for the room items.
        ItemsCollection roomItems = new ItemsCollection();

        // Create the currentRoom and populate it with the roomItems and the walls.
        Room currentRoom = new Room(roomItems, walls, null);

        // Create a player object and populate it with the playerItems and the currentRoom.
        Player player = new Player(Direction.BACK, playerItems, currentRoom, "Username1");
        return player;
    }
}
