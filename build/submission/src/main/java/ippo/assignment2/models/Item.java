package ippo.assignment2.models;

import java.awt.*;

public class Item {
    private Image image;
    private String name;

    public Item(Image image, String name) {
        this.image = image;
        this.name = name;
    }

    public Image getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }
}
