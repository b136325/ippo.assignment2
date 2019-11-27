package ippo.assignment2.builders;

import ippo.assignment2.models.Player;
import ippo.assignment2.parsers.JsonFileParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JsonModelBuilderTest {

    /**
     * @since 0.3.0
     */
    @Test
    public void titleTest() {
        JsonFileParser jsonFileParser = new JsonFileParser();
        JsonModelBuilder jsonModelBuilder = new JsonModelBuilder(jsonFileParser, "test.json", false);
        Player player = jsonModelBuilder.build();
        assertNotNull(player);
    }
}
