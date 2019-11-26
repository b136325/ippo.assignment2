package ippo.assignment2.collections;

import ippo.assignment2.models.Item;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * A collection of unique Item models.
 *
 * @since 0.1.2
 */
public class ItemsCollection {

    /**
     * An empty HashSet, which will be used to contain unique Item objects.
     *
     * @since 0.1.2
     */
    private HashSet<Item> items = new HashSet<>();

    /**
     * Add an Item object to the collection.
     *
     * @param item The Item object to be added.
     *
     * @since 0.1.2
     */
    public void add(Item item) {
        this.items.add(item);
    }

    /**
     * Return the number of Item objects within the collection.
     *
     * @return The number of Item objects within the collection or zero.
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
     * Retrieve an Item by index (starting at zero).
     *
     * @param index The index of the Item to ve retrieved.
     * @return An Item or null.
     *
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
     * Check whether or not an Item exists within the collection.
     *
     * @param item The Item to be checked.
     * @return True or false depending upon whether or not the
     *         received Item exists within the collection.
     *
     * @since 0.1.2
     */
    public Boolean has(Item item) {
        return this.items.contains(item);
    }

    /**
     * Remove an Item object from the collection.
     *
     * @param item The Item object to be removed.
     * @return True or false depending upon whether or not the Item was removed.
     *         False will be returned when the Item object did not exist, already,
     *         within the collection.
     *
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
