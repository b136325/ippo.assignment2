package ippo.assignment2.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PropertiesTest {

    private Properties properties;

    public PropertiesTest() throws IOException {
        this.properties = new Properties();
    }

    @Test
    public void hasValueFalse() {
        assertFalse(this.properties.has("UNKNOWN_PROPERTY_KEY"));
    }

    @Test
    public void hasValueTrue() {
        assertTrue(this.properties.has("navigation.service"));
    }
}