package ippo.assignment2.builders;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.collections.WallsCollection;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Item;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;
import ippo.assignment2.models.Wall;
import ippo.assignment2.parsers.JsonFileParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * A class the builds models from the JSON file defined by 'jsonFileName'.
 *
 * @since 0.4.0
 */
public class JsonModelBuilder {
    private String jsonFileName;
    private JsonFileParser jsonFileParser;
    private Boolean loadImages;

    /**
     * The constructor for the model builder.
     *
     * @param jsonFileParser A JSON file parser.
     * @param jsonFileName The name of the JSON file (within resources/JSON).
     * @param loadImages A flag indicating whether or not images should be loaded.
     *
     * @since 0.4.0
     */
    public JsonModelBuilder(JsonFileParser jsonFileParser, String jsonFileName, Boolean loadImages) {
        this.jsonFileParser = jsonFileParser;
        this.jsonFileName = jsonFileName;
        this.loadImages = loadImages;
    }

    /**
     * Build the models based upon the JSON file whose name is 'jsonFileName'.
     * The 'build' method below extracts from the JSON 'items' (player items)
     * and 'rooms' objects, and passes them to 'buildPlayerItems' and 'buildRooms'
     * for further processing.
     *
     * @return A single player model.
     */
    public Player build() {
        ItemsCollection playerItems;
        ArrayList<Room> rooms = new ArrayList<>();

        JSONObject jsonObject = this.jsonFileParser.parse(this.jsonFileName);
        JSONObject itemsJSON = (JSONObject) jsonObject.get("items");
        JSONObject roomsJSON = (JSONObject) jsonObject.get("rooms");

        this.buildRooms(roomsJSON, rooms);
        playerItems = this.buildPlayerItems(itemsJSON);

        return new Player(null, playerItems, rooms.get(0), "Username1");
    }

    /**
     * Build the items associated with the player.
     *
     * @param itemsJSON A JSONObject representing the JSON player items.
     * @return An ItemsCollection of player items.
     *
     * @since 0.4.0
     */
    public ItemsCollection buildPlayerItems(JSONObject itemsJSON) {
        ItemsCollection items = new ItemsCollection();
        Collection itemsCollection = itemsJSON.values();
        Iterator itemsCollectionIteration = itemsCollection.iterator();

        while (itemsCollectionIteration.hasNext()) {
            JSONObject itemJSON = (JSONObject) itemsCollectionIteration.next();
            String imageName = (String) itemJSON.get("image");
            String resourcesImagePath = "images/" + imageName;
            Image itemImage = null;

            if (this.loadImages == true) {
                itemImage = new Image(resourcesImagePath);
            }

            Item item = new Item(itemImage, null);
            items.add(item);
        }
        return items;
    }

    /**
     * Construct a single Room model.
     *
     * @param roomJSON A JSONObject representing a room.
     * @param roomName The name of the room.
     * @return A Room model.
     *
     * @since 0.4.0
     */
    public Room buildRoom(JSONObject roomJSON, String roomName) {
        ItemsCollection items = new ItemsCollection();
        WallsCollection walls = new WallsCollection();

        if (roomJSON.containsKey("contents")) {
            JSONArray roomContentsJSON = (JSONArray) roomJSON.get("contents");
            this.buildRoomContents(roomContentsJSON, items);
        }

        if (roomJSON.containsKey("exits")) {
            JSONObject roomExitsJSON = (JSONObject) roomJSON.get("exits");
            this.buildRoomExits(roomExitsJSON, walls);
        }

        if (roomJSON.containsKey("views")) {
            JSONObject roomViewsJSON = (JSONObject) roomJSON.get("views");
            this.buildRoomViews(roomViewsJSON, walls);
        }

        return new Room(items, walls, roomName);
    }

    /**
     * Build the contents (or items) for a room, and do so by updating
     * the received ItemsCollection.
     *
     * @param roomContentsJSON A JSOnObject representing the contents (or items).
     * @param items An ItemsCollection of room items.
     */
    public void buildRoomContents(JSONArray roomContentsJSON, ItemsCollection items) {
        Iterator roomContentsIterator = roomContentsJSON.iterator();

        while (roomContentsIterator.hasNext()) {
            String itemName = (String) roomContentsIterator.next();
            Item item = new Item(null, itemName);
            items.add(item);
        }
    }

    /**
     * Build a Wall model for each exit.
     *
     * @param roomExits A JSONObject representing all of the exists.
     * @param walls A WallsCollection which will be updated with each exit.
     *
     * @since 0.4.0
     */
    public void buildRoomExits(JSONObject roomExits, WallsCollection walls) {
        Iterator existsIterator = roomExits.keySet().iterator();

        while (existsIterator.hasNext()) {
            String exitName = (String) existsIterator.next();
            String nextRoomName = (String) roomExits.get(exitName);

            Room nextRoom = new Room(null, null, nextRoomName);
            Wall exitWall = new Wall(null, nextRoom, exitName);
            Direction direction = Direction.valueOf(exitName.toUpperCase());
            walls.add(direction, exitWall);
        }
    }

    /**
     * Build all rooms.
     *
     * @param roomsJSON A JSONObject representing all of the rooms.
     * @param rooms An ArrayList of rooms, which will be updated.
     *
     * @since 0.4.0
     */
    public void buildRooms(JSONObject roomsJSON, ArrayList<Room> rooms) {
        Iterator roomsIterator = roomsJSON.keySet().iterator();

        while (roomsIterator.hasNext()) {
            String roomName = (String) roomsIterator.next();
            JSONObject roomJSON = (JSONObject) roomsJSON.get(roomName);

            rooms.add(this.buildRoom(roomJSON, roomName));
        }
    }

    /**
     * Build the views (or walls) for a single room.
     *
     * @param roomViewsJSON A JSONObject representing the views (or walls).
     * @param walls A WallsCollection, which will be updated.
     *
     * @since 0.4.0
     */
    public void buildRoomViews(JSONObject roomViewsJSON, WallsCollection walls) {
        Iterator roomsViewsIterator = roomViewsJSON.keySet().iterator();

        while (roomsViewsIterator.hasNext()) {
            String viewName = (String) roomsViewsIterator.next();
            String imageName = (String) roomViewsJSON.get(viewName);
            String resourceImagePath = "images/" + imageName;
            Image image = null;

            if (this.loadImages == true) {
                image = new Image(resourceImagePath);
            }

            Wall viewWall = new Wall(image, null, viewName);
            Direction direction = Direction.valueOf(viewName.toUpperCase());
            walls.add(direction, viewWall);
        }
    }
}
