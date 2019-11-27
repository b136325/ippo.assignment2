package ippo.assignment2.parsers;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * A test class for the JSON file parser.
 *
 * @since 0.4.0
 */
public class JsonFileParserTest {
    private JsonFileParser jsonFileParser = new JsonFileParser();
    private String jsonFileName = "test.json";

    /**
     * Ensure that the test.json file can be parsed.
     *
     * @since 0.4.0
     */
    @Test
    public void parseValid() {
        JSONObject json = this.jsonFileParser.parse(this.jsonFileName);
        assertNotNull(json);
    }
}
