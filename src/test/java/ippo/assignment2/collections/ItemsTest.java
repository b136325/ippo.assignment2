package ippo.assignment2.collections;

import ippo.assignment2.models.Item;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ItemsTest {

    @Test
    public void addTest() {
        ItemsCollection items = new ItemsCollection();
        assertTrue(items.count() == 0);

        Item item = new Item(null, null);
        items.add(item);

        assertTrue(items.count() == 1);
    }

    @Test
    public void countTest() {
        ItemsCollection items = new ItemsCollection();
        assertTrue(items.count() == 0);

        Item itemOne = new Item(null, null);
        items.add(itemOne);
        assertTrue(items.count() == 1);

        Item itemTwo = new Item(null, null);
        items.add(itemTwo);
        assertTrue(items.count() == 2);

        items.remove(itemTwo);
        assertTrue(items.count() == 1);

        assertFalse(items.remove(itemTwo));
        assertTrue(items.count() == 1);

        items.remove(itemOne);
        assertTrue(items.count() == 0);

        assertFalse(items.remove(itemOne));
        assertTrue(items.count() == 0);
    }

    @Test
    public void getTestFirstIndex() {
        ItemsCollection items = new ItemsCollection();
        Item itemOne = new Item(null, "ItemOne");
        items.add(itemOne);

        Item retrievedItemOne = items.get(0);
        assertNotNull(retrievedItemOne);
        assertTrue(retrievedItemOne.getName() == itemOne.getName());
        assertTrue(retrievedItemOne.hashCode() == itemOne.hashCode());
    }

    @Test
    public void hasTest() {
        ItemsCollection items = new ItemsCollection();
        Item itemOne = new Item(null, "ItemOne");
        items.add(itemOne);
        Item itemTwo = new Item(null, "ItemTwo");
        items.add(itemTwo);

        assertTrue(items.has(itemOne));
        assertTrue(items.has(itemTwo));

        Item itemThree = new Item(null, "ItemThree");
        assertFalse(items.has(itemThree));
    }

    @Test
    public void removeTest() {
        ItemsCollection items = new ItemsCollection();
        Item itemOne = new Item(null, "ItemOne");
        items.add(itemOne);
        Item itemTwo = new Item(null, "ItemTwo");
        items.add(itemTwo);

        assertTrue(items.has(itemOne));
        assertTrue(items.has(itemTwo));
        assertTrue(items.count() == 2);

        items.remove(itemOne);
        assertFalse(items.has(itemOne));
        assertTrue(items.has(itemTwo));
        assertTrue(items.count() == 1);
    }
}