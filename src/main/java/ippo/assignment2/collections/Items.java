package ippo.assignment2.collections;

import ippo.assignment2.models.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @since 0.1.2
 */
public class Items {
    private HashSet<Item> items = new HashSet<>();

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
     * @since 0.2.1
     */
    public Integer count() {
        Integer count = this.items.size();

        if (count == null) {
            count = 0;
        }

        return count;
    }

    /**
     *
     * @param index
     * @return
     * @since 0.2.7
     */
    public Item get(Integer index) {
        try {
            List<Item> itemsList = new ArrayList<>(this.items);
            return itemsList.get(index);
        } catch(Exception e) {
            return null;
        }
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
