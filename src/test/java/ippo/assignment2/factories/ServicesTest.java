package ippo.assignment2.factories;

import ippo.assignment2.services.IService;
import ippo.assignment2.services.Players;
import ippo.assignment2.utils.Properties;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServicesTest {

    private Services servicesFactory;

    public ServicesTest() {
        this.servicesFactory = new Services();
    }

    @Test
    public void generateNull() {
        assertNull(this.servicesFactory.generate("UNKNOWN_SERVICE"));
    }

    @Test
    public void generatePlayersService() {
        assertTrue(this.servicesFactory.generate("Players") instanceof Players);
    }

    @Test
    public void generateFromPropertiesNull() throws IOException {
        Properties properties = new Properties();
        String propertyName = "UNKNOWN_PROPERTY_NAME";
        assertNull(this.servicesFactory.generateFromProperties(properties, propertyName));
    }

    @Test
    public void generateFromPropertiesPlayersService() throws IOException {
        Properties properties = new Properties();
        String propertyName = "navigation.service";
        IService service = this.servicesFactory.generateFromProperties(properties, propertyName);
        assertTrue(service instanceof Players);
    }
}
