package ippo.assignment2.loaders;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.Reader;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * A test class for the ResourceFileLoader.
 *
 * @since 0.4.0
 */
public class ResourceFileLoaderTest {

    /**
     * A reference to an instance of the ResourceFileLoader.
     * @since 0.4.0
     */
    public ResourceFileLoader resourceFileLoader = new ResourceFileLoader();

    /**
     * A test that attempts to load an unknown file; that is,
     * the tests attempts to load a file that does not exists,
     * and 'loadedFile' should equal null.
     *
     * @since 0.4.0
     */
    @Test
    public void loadFromPathInValid() {
        File loadedFile = this.resourceFileLoader.loadFromPath("css/UNKNOWN_FILE.css");
        assertNull(loadedFile);
    }

    /**
     * A test that attempts to load a file that does exists; such that,
     * 'loadedFile' should NOT be null.
     *
     * @since 0.4.0
     */
    @Test
    public void loadFromPathValid() {
        File loadedFile = this.resourceFileLoader.loadFromPath("css/bootstrap2.css");
        assertNotNull(loadedFile);
    }

    /**
     * A test that should not be able to load a JSON file by filename; such that,
     * 'loadedFile' should be null.
     *
     * @since 0.4.0
     */
    @Test
    public void loadJsonInValid() {
        File loadedFile = this.resourceFileLoader.loadJson("UNKNOWN_FILE.json");
        assertNull(loadedFile);
    }

    /**
     * A test that should successfully load a JSON file by filename.
     *
     * @since 0.4.0
     */
    @Test
    public void loadJsonValid() {
        File loadedFile = this.resourceFileLoader.loadJson("test.json");
        assertNotNull(loadedFile);
    }

    /**
     * A test that should successfully load a JSON file by filename.
     *
     * @since 0.4.0
     */
    @Test
    public void loadJsonReaderValid() {
        Reader loadedFileReader = this.resourceFileLoader.loadJsonReader("test.json");
        assertNotNull(loadedFileReader);
    }

    /**
     * A test that should successfully load a Properties file by filename.
     *
     * @since 0.4.0
     */
    @Test
    public void loadPropertyFileValid() {
        Properties properties = this.resourceFileLoader.loadPropertyFile("properties/app.properties");
        assertNotNull(properties);
    }
}
