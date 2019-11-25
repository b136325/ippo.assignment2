package ippo.assignment2.models;

import javafx.scene.image.Image;

/**
 * @since 0.1.2
 */

public class Item {
    private Image image;
    private String name;

    /**
     * @since 0.1.2
     */
    public Item(Image image, String name) {
        this.image = image;
        this.name = name;
    }

    /**
     * @since 0.1.2
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * @since 0.1.2
     */
    public String getName() {
        return this.name;
    }
}
