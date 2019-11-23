package ippo.assignment2.models;

import java.awt.*;

public class WallModel {
    private Image image;
    private RoomModel room;

    /**
     *
     * @param image
     * @param room
     */
    public WallModel(Image image, RoomModel room) {
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
    public RoomModel getRoom() {
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
