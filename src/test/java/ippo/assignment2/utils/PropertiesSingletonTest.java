package ippo.assignment2.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PropertiesSingletonTest {

    private PropertiesSingleton propertiesSingleton;

    public PropertiesSingletonTest() {
        this.propertiesSingleton = PropertiesSingleton.getInstance();
    }

    @Test
    public void hasValueFalse() {
        assertFalse(this.propertiesSingleton.has("UNKNOWN_PROPERTY_KEY"));
    }

    @Test
    public void hasValueTrue() {
        assertTrue(this.propertiesSingleton.has("navigation.service"));
    }

    @Test
    public void singletonReturnsMatchingObjects() {
        PropertiesSingleton propertiesSingletonA = PropertiesSingleton.getInstance();
        PropertiesSingleton propertiesSingletonB = PropertiesSingleton.getInstance();
        assertEquals(propertiesSingletonA, propertiesSingletonB);
    }
}