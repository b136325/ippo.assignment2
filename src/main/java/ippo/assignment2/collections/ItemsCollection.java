package ippo.assignment2.collections;

import ippo.assignment2.models.ItemModel;

import java.util.*;

/**
 * @since 0.1.2
 */
public class ItemsCollection {
    private Set<ItemModel> items = new HashSet<ItemModel>();

    /**
     *
     * @param item
     * @since 0.1.2
     */
    public void add(ItemModel item) {
        this.items.add(item);
    }

    /**
     *
     * @param item
     * @return
     * @since 0.1.2
     */
    public Boolean has(ItemModel item) {
        return this.items.contains(item);
    }

    /**
     *
     * @param item
     * @return
     * @since 0.1.2
     */
    public Boolean remove(ItemModel item) {
        Boolean response = false;

        if (this.items.contains(item)) {
            this.items.remove(item);
            response = true;
        }
        return response;
    }
}
