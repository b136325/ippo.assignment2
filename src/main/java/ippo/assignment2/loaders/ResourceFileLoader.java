package ippo.assignment2.loaders;

import ippo.assignment2.loggers.ExceptionLogger;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Properties;

/**
 * A class whose methods may be used to load resources.
 *
 * @since 0.4.0
 */
public class ResourceFileLoader {

    /**
     * A reference to an instance of the ExceptionLogger.
     *
     * @since 0.4.0
     */
    private ExceptionLogger exceptionLogger = new ExceptionLogger();

    /**
     * Find a resource as a File object from the received 'resourceFilePath'.
     *
     * @param resourceFilePath The path to the file from within the resources directory.
     * @return A File object representing the loaded file.
     *
     * @since 0.4.0
     */
    public File loadFromPath(String resourceFilePath) {
        ClassLoader classLoader = getClass().getClassLoader();
        File resourceFile = null;
        URL resource = null;

        resource = classLoader.getResource(resourceFilePath);

        if (resource != null) {
            resourceFile = new File(resource.getFile());
        }

        return resourceFile;
    }

    /**
     * A convenience method that returns a File object representing
     * the file named 'jsonFileName' from within 'resources/JSON'.
     *
     * @param jsonFileName The name of the JSON file to be loaded.
     * @return A file object representing the loaded JSON file.
     *
     * @since 0.4.0
     */
    public File loadJson(String jsonFileName) {
        String resourceFilePath = "JSON/" + jsonFileName;
        return this.loadFromPath(resourceFilePath);
    }

    /**
     * A convenience method that return a Reader object representing
     * the file name 'jsonFileName'.
     *
     * @param jsonFileName The name of the JSON file to be loaded.
     * @return A Reader object containing the JSON file.
     *
     * @since 0.4.0
     */
    public Reader loadJsonReader(String jsonFileName) {
        Reader jsonFileReader = null;

        try {
            File jsonFile = this.loadJson(jsonFileName);
            jsonFile.createNewFile();
            jsonFileReader = new FileReader(jsonFile);

        } catch (Exception e) {
            this.exceptionLogger.log(e);
        }

        return jsonFileReader;
    }

    /**
     * A method that loads a property file from the received 'resourceFilePath'.
     * the file name 'jsonFileName'.
     *
     * @param resourceFilePath The path (from within the resource directory) of the file to be loaded.
     * @return A Properties object.
     *
     * @since 0.4.0
     */
    public Properties loadPropertyFile(String resourceFilePath) {
        Properties properties = null;

        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resourceFilePath);
            properties = new java.util.Properties();
            properties.load(inputStream);
        } catch(Exception e) {
            this.exceptionLogger.log(e);
        }

        return properties;
    }
}
