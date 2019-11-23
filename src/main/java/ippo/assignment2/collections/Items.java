package ippo.assignment2.collections;

import ippo.assignment2.models.Item;

import java.util.*;

public class Items {
    private Set<Item> items = new HashSet<Item>();

    public void add(Item item) {
        this.items.add(item);
    }

    public Boolean has(Item item) {
        return this.items.contains(item);
    }

    public Boolean remove(Item item) {
        Boolean response = false;

        if (this.items.contains(item)) {
            this.items.remove(item);
            response = true;
        }
        return response;
    }
}
