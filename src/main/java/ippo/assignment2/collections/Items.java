package ippo.assignment2.collections;

import ippo.assignment2.models.Item;

import java.util.*;

/**
 * @since 0.1.2
 */
public class Items {
    private HashMap<Integer, Item> items = new HashMap<Integer, Item>();

    /**
     *
     * @param item
     * @since 0.1.2
     */
    public void add(Item item) {
        Integer index = this.count() + 1;
        this.items.put(index, item);
    }

    /**
     *
     * @since 0.2.1
     */
    public Integer count() {
        return this.items.size();
    }

    /**
     *
     * @param index
     * @return
     * @since 0.2.7
     */
    public Item get(Integer index) {
        Item item = null;
        if (this.items.containsKey(index)) {
            item = this.items.get(index);
        }
        return item;
    }

    /**
     *
     * @param item
     * @return
     * @since 0.1.2
     */
    public Boolean has(Item item) {
        return this.items.containsValue(item);
    }

    /**
     *
     * @param item
     * @return
     * @since 0.1.2
     */
    public Boolean remove(Item item) {
        Boolean response = false;

        if (this.items.containsValue(item)) {
            this.items.remove(item);
            response = true;
        }
        return response;
    }
}
