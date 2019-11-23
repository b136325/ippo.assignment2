package ippo.assignment2.collections;

import ippo.assignment2.models.Item;

import java.util.*;

/**
 * @since 0.1.2
 */
public class Items {
    private Set<Item> items = new HashSet<Item>();

    /**
     *
     * @param item
     * @since 0.1.2
     */
    public void add(Item item) {
        this.items.add(item);
    }

    /**
     *
     * @param item
     * @return
     * @since 0.1.2
     */
    public Boolean has(Item item) {
        return this.items.contains(item);
    }

    /**
     *
     * @param item
     * @return
     * @since 0.1.2
     */
    public Boolean remove(Item item) {
        Boolean response = false;

        if (this.items.contains(item)) {
            this.items.remove(item);
            response = true;
        }
        return response;
    }
}
