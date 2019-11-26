package ippo.assignment2.models;

import javafx.scene.image.Image;

/**
 * The Item model, which represents items that may be 'owned' by either players or rooms.
 *
 * @since 0.1.2
 */

public class Item {

    /**
     * The image associated with the item.
     *
     * @since 0.1.2
     */
    private Image image;

    /**
     * The name of the item.
     *
     * @since 0.1.2
     */
    private String name;

    /**
     * The constructor for Item object.
     *
     * @param image The image associated with the Item object.
     * @param name The name of the Item object.
     *
     * @since 0.1.2
     */
    public Item(Image image, String name) {
        this.image = image;
        this.name = name;
    }

    /**
     * A 'getter' that returns the image associated with the Item.
     *
     * @return The image associated with the Item or null.
     *
     * @since 0.1.2
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * A 'getter' that returns the name of the Item.
     *
     * @return The name of the Item or null.
     *
     * @since 0.1.2
     */
    public String getName() {
        return this.name;
    }
}
