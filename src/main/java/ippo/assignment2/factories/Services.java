package ippo.assignment2.factories;

import ippo.assignment2.services.IService;
import ippo.assignment2.services.Players;
import ippo.assignment2.utils.Properties;

/**
 * @since 0.1.7
 */
public class Services {

    /**
     *
     * @param serviceName
     * @return
     * @since 0.1.7
     */
    public IService generate(String serviceName) {
        IService service = null;

        switch(serviceName) {
            case "Players":
                service = new Players();
        }

        return service;
    }

    /**
     *
     * @param properties
     * @param propertyName
     * @return
     * @since 0.1.7
     */
    public IService generateFromProperties(Properties properties, String propertyName) {
        String serviceClassName = null;
        IService service = null;

        if (properties.has(propertyName)) {
            serviceClassName = properties.getValue(propertyName);
        }

        if (serviceClassName != null) {
            service = this.generate(serviceClassName);
        }

        return service;
    }
}
