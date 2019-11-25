package ippo.assignment2.models;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void constructorNullTest() {
        Item item = new Item(null, null);
        assertNull(item.getImage());
        assertNull(item.getName());
    }

    @Test
    public void getNameTest() {
        String itemName = "Item One";
        Item itemOne = new Item(null, itemName);
        assertNull(itemOne.getImage());
        assertTrue(itemOne.getName() == itemName);
    }
}
