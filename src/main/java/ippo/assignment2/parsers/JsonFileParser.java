package ippo.assignment2.parsers;

import ippo.assignment2.loggers.ExceptionLogger;
import ippo.assignment2.loaders.ResourceFileLoader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.Reader;

/**
 * A JSON file parser.
 *
 * @since 0.4.0
 */
public class JsonFileParser {

    /**
     * A reference to an instance of the ExceptionLogger.
     *
     * @since 0.4.0
     */
    ExceptionLogger exceptionLogger = new ExceptionLogger();

    /**
     * A reference to an instance of the ResourceFileLoader.
     *
     * @since 0.4.0
     */
    ResourceFileLoader resourceFileLoader = new ResourceFileLoader();

    /**
     * Parse the JSON file whose path is defined by the received 'jsonFilePath'.
     *
     * @param jsonFileName The path of the JSON file to be parsed.
     * @return A JSONObject representing the parsed JSON.
     *
     * @since 0.4.0
     */
    public JSONObject parse(String jsonFileName) {
        JSONObject jsonObject = null;
        JSONParser jsonParser = new JSONParser();
        Reader jsonFileReader  = this.resourceFileLoader.loadJsonReader(jsonFileName);

        try {
            jsonObject = (JSONObject) jsonParser.parse(jsonFileReader);
        } catch(Exception e) {
            this.exceptionLogger.log(e);
        }

        return jsonObject;
    }
}
