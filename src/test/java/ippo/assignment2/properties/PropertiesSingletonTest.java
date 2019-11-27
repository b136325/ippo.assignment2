package ippo.assignment2.properties;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * A test class for the PropertiesSingleton.
 *
 * @since 0.4.0
 */
public class PropertiesSingletonTest {

    /**
     * A reference to an instance of the PropertiesSingleton.
     *
     * @since 0.4.0
     */
    public PropertiesSingleton propertiesSingleton = PropertiesSingleton.getInstance();

    /**
     * Ensure that 'has' will return false for an invalid property key.
     *
     * @since 0.4.0
     */
    @Test
    public void hasValueFalse() {
        assertFalse(this.propertiesSingleton.has("UNKNOWN_PROPERTY_KEY"));
    }

    /**
     * Ensure that 'has' will return true for an valid property key.
     *
     * @since 0.4.0
     */
    @Test
    public void hasValueTrue() {
        assertTrue(this.propertiesSingleton.has("navigation.service"));
    }

    /**
     * Ensure that the 'getInstance' method always returns the same object.
     *
     * @since 0.4.0
     */
    @Test
    public void singletonReturnsMatchingObjects() {
        PropertiesSingleton propertiesSingletonA = PropertiesSingleton.getInstance();
        PropertiesSingleton propertiesSingletonB = PropertiesSingleton.getInstance();
        assertEquals(propertiesSingletonA, propertiesSingletonB);
        assertEquals(propertiesSingletonA.hashCode(), propertiesSingletonB.hashCode());
    }
}