package ippo.assignment2.services;

import ippo.assignment2.builders.JsonModelBuilder;
import ippo.assignment2.models.Player;
import ippo.assignment2.parsers.JsonFileParser;
import ippo.assignment2.properties.PropertiesSingleton;

/**
 * A PlayersService whose models have been constructed from JSON.
 *
 * @since 0.4.1
 */
public class PlayersJsonService implements IService {
    private String jsonFileName;
    private JsonFileParser jsonFileParser;
    private PropertiesSingleton properties;

    /**
     * The constructor for the PlayersJsonService.
     *
     * @since 0.4.1
     */
    public PlayersJsonService() {
        this.properties = PropertiesSingleton.getInstance();
        this.jsonFileName = this.properties.getValue("app.service.jsonFileName");
        this.jsonFileParser = new JsonFileParser();
    }
    /**
     * Retrieve a Player model from the JSON resource defined by
     * the "app.service.jsonFileName" property name.
     *
     * @param showImages A Boolean flag determining whether or not images should be added.
     * @return Player The Player model to be returned.
     *
     * @since 0.4.1
     */
    public Player get(Boolean showImages) {
        if (this.jsonFileName == null || this.jsonFileParser == null) {
            return null;
        }

        JsonModelBuilder jsonModelBuilder = new JsonModelBuilder(
            this.jsonFileParser,
            this.jsonFileName,
            showImages
        );

        return jsonModelBuilder.build();
    }
}
