package ippo.assignment2.models;

import java.awt.*;

public class Wall {
    private Image image;
    private Room room;

    /**
     *
     * @param image
     * @param room
     */
    public Wall(Image image, Room room) {
        this.image = image;
        this.room = room;
    }

    /**
     *
     * @return
     */
    public Image getImage() {
        return this.image;
    }

    /**
     *
     * @return
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     *
     * @return
     */
    public Boolean hasRoom() {
        return this.room != null;
    }
}
