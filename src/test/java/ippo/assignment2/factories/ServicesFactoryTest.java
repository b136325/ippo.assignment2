package ippo.assignment2.factories;

import ippo.assignment2.services.IService;
import ippo.assignment2.services.PlayersService;
import ippo.assignment2.properties.PropertiesSingleton;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * A Junit based test of the Services Factory.
 *
 * @since 0.3.2
 */
public class ServicesFactoryTest {

    /**
     * A reference to an instance of the ServicesFactory.
     *
     * @since 0.3.2
     */
    private ServicesFactory servicesFactory;

    public ServicesFactoryTest() {
        this.servicesFactory = new ServicesFactory();
    }

    @Test
    public void createServiceNull() {
        assertNull(this.servicesFactory.createService("UNKNOWN_SERVICE"));
    }

    @Test
    public void createPlayersService() {
        assertTrue(this.servicesFactory.createService("Players") instanceof PlayersService);
    }

    @Test
    public void createServiceFromPropertiesNull() throws IOException {
        PropertiesSingleton properties = PropertiesSingleton.getInstance();
        String propertyName = "UNKNOWN_PROPERTY_NAME";
        assertNull(this.servicesFactory.createServiceFromProperties(properties, propertyName));
    }

    @Test
    public void createServiceFromPropertiesPlayersService() throws IOException {
        PropertiesSingleton properties = PropertiesSingleton.getInstance();
        String propertyName = "navigation.service";
        IService service = this.servicesFactory.createServiceFromProperties(properties, propertyName);
        assertTrue(service instanceof PlayersService);
    }
}
