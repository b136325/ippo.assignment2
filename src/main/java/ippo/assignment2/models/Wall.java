package ippo.assignment2.models;

import javafx.scene.image.Image;

/**
 * @since 0.2.8
 */
public class Wall {
    private Image image;
    private String name;
    private Room room;

    /**
     *
     * @param image
     * @param room
     * @since 0.2.8
     */
    public Wall(Image image, Room room, String name) {
        this.image = image;
        this.room = room;
        this.name = name;
    }

    /**
     *
     * @retun
     * @since 0.2.8
     */
    public Image getImage() {
        return this.image;
    }

    /**
     *
     * @return
     * @since 0.2.8
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return
     * @since 0.2.8
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     *
     * @return
     * @since 0.2.8
     */
    public Boolean hasRoom() {
        return this.room != null;
    }
}
