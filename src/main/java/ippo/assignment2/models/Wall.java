package ippo.assignment2.models;

import javafx.scene.image.Image;

/**
 * A class for Wall objects.
 *
 * @since 0.2.8
 */
public class Wall {
    private Image image;
    private String name;
    private Room room;

    /**
     * The constructor for Wall objects.
     *
     * @param image The image to be associated with the wall.
     * @param room The room (if applicable) that can be accessed by going forward
     *             through a door in the wall.
     *
     * @since 0.2.8
     */
    public Wall(Image image, Room room, String name) {
        this.image = image;
        this.room = room;
        this.name = name;
    }

    /**
     * A 'getter' method that returns the Image associated with the wall.
     *
     * @retun An Image or null.
     *
     * @since 0.2.8
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * A 'getter' method that returns the name associated with the wall.
     *
     * @return The name of the wall.
     *
     * @since 0.2.8
     */
    public String getName() {
        return this.name;
    }

    /**
     * A 'getter' method that returns a room associated with the wall.
     *
     * @return The Room object associated with a wall.
     *
     * @since 0.2.8
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     * A method that returns true or false depending upon whether
     * or not the wall has been associated with a room.
     *
     * @return True or false.
     *
     * @since 0.2.8
     */
    public Boolean hasRoom() {
        return this.room != null;
    }

    /**
     * A 'setter' method that may be used to associated the wall with a room.
     *
     * @since 0.2.8
     */
    public void setRoom(Room room) {
        this.room = room;
    }
}
