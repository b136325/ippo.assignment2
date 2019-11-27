package ippo.assignment2.properties;

import ippo.assignment2.loaders.ResourceFileLoader;
import java.util.Properties;

/**
 * A singleton class of properties with property values from "properties/app.properties".
 *
 * @since 0.1.6
 */
public class PropertiesSingleton {

    /**
     * The object used to contain the loaded properties.
     *
     * @since 0.3.5
     */
    private Properties properties = new Properties();

    /**
     * The path to the properties configuration file (within the resources directory).
     *
     * @since 0.3.5
     */
    private final String propertiesPath =  "properties/app.properties";

    /**
     * A static reference to a concrete instance of the PropertiesSingleton.
     *
     * @since 0.3.5
     */
    private static PropertiesSingleton propertiesSingleton = null;

    /**
     * An instance of the ResourceFileLoader.
     *
     * @since 0.4.0
     */
    private ResourceFileLoader resourceFileLoader = new ResourceFileLoader();

    /**
     * The privately scoped constructor for the PropertiesSingleton class.
     * To access an instance of the class use 'getInstance' below.
     *
     * @since 0.1.6
     */
    private PropertiesSingleton() {
        this.load();
    }

    /**
     * A static method that may be called to access a concrete instance of the singleton.
     *
     * @return A concrete instance of the PropertiesSingleton.
     *
     * @since 0.3.5
     */
    public static PropertiesSingleton getInstance() {
        if (propertiesSingleton == null) {
            propertiesSingleton = new PropertiesSingleton();
        }
        return propertiesSingleton;
    }

    /**
     * A method that may be called to return the value associated with the received 'propertyName'.
     *
     * @param propertyName The name of the property whose value will be returned.
     * @return Either the value of the named property. Or null when the property is not found.
     *
     * @since 0.1.6
     */
    public String getValue(String propertyName) {
        String response = null;

        if (this.has(propertyName)) {
            response = this.properties.getProperty(propertyName);
        }

        return response;
    }

    /**
     * A simple 'utility' method that may be called to determine whether or not the received
     * 'propertyName' is a known property.
     *
     * @param propertyName The property name to check.
     * @return True or false.
     *
     * @since 0.1.6
     */
    public Boolean has(String propertyName) {
        return this.properties.containsKey(propertyName);
    }

    /**
     * This private method attempt to load the required properties config file,
     * whose path is defined by 'this.propertiesPath', into a Java.util Properties object.
     *
     * @since 0.1.6
     */
    private void load() {
        Properties properties = this.resourceFileLoader.loadPropertyFile(this.propertiesPath);
        this.properties.putAll(properties);
    }
}
