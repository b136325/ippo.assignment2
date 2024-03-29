package ippo.assignment2.factories;

import ippo.assignment2.services.IService;
import ippo.assignment2.services.PlayersEdinburghService;
import ippo.assignment2.services.PlayersJsonService;
import ippo.assignment2.services.PlayersService;
import ippo.assignment2.properties.PropertiesSingleton;

/**
 * A simple concrete factory that creates IService objects.
 *
 * @since 0.1.7
 */
public class ServicesFactory {

    /**
     * Create and return an instance of the service named 'servicesName'
     *
     * @param serviceName The name of the service to be returned.
     * @return An instance of a service or null.
     *
     * @since 0.1.7
     */
    public static IService createService(String serviceName) {
        IService service = null;

        switch(serviceName) {
            case "PlayersService":
                service = new PlayersService();
                break;
            case "PlayersEdinburghService":
                service = new PlayersEdinburghService();
                break;
            case "PlayersJsonService":
                service = new PlayersJsonService();
                break;
        }

        return service;
    }

    /**
     * Create and return an instance of the service named
     * by the property value associated with 'propertyName'.
     *
     * @param properties An object of properties.
     * @param propertyName The name of the property whose value represents a service.
     * @return  An instance of a service or null.
     *
     * @since 0.1.7
     */
    public static IService createServiceFromProperties(PropertiesSingleton properties, String propertyName) {
        String serviceClassName = null;
        IService service = null;

        if (properties.has(propertyName)) {
            serviceClassName = properties.getValue(propertyName);
        }

        if (serviceClassName != null) {
            service = createService(serviceClassName);
        }

        return service;
    }
}
