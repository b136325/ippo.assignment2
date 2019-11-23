package ippo.assignment2.collections;

import ippo.assignment2.models.Item;

import java.util.*;

public class Items {
    private Set<Item> items = new HashSet<>();

    public void add(Item item) {
        this.items.add(item);
    }

    public void remove(Item item) {
        if (this.items.contains(item)) {
            this.items.remove(item);
        }
    }
}
