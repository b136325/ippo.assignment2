package ippo.assignment2.utils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @since 0.1.6
 */
public class Properties {
    private final String propertiesPath =  "properties/app.properties";
    private java.util.Properties properties = new java.util.Properties();

    /**
     *
     * @throws IOException
     * @since 0.1.6
     */
    public Properties() throws IOException {
        this.load();
    }

    /**
     *
     * @param propertyName
     * @return
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
     *
     * @param propertyName
     * @return
     * @since 0.1.6
     */
    public Boolean has(String propertyName) {
        return this.properties.containsKey(propertyName);
    }

    /**
     *
     * @throws IOException
     * @since 0.1.6
     */
    private void load() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(this.propertiesPath);
        java.util.Properties properties = new java.util.Properties();
        properties.load(inputStream);

        this.properties.putAll(properties);
    }
}
