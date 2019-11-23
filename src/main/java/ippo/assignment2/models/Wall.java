package ippo.assignment2.models;

import java.awt.*;

public class Wall {
    private Image image;
    private Room room;

    public Wall(Image image, Room room) {
        this.image = image;
        this.room = room;
    }

    public Image getImage() {
        return this.image;
    }

    public Room getRoom() {
        return this.room;
    }

    public Boolean hasRoom() {
        return this.room != null;
    }
}
