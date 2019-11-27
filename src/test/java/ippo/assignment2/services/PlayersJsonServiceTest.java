package ippo.assignment2.services;

import ippo.assignment2.models.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * A test class for the PlayersJsonService.
 *
 * @since 0.4.1
 */
public class PlayersJsonServiceTest {
    public PlayersJsonService playersJsonService;

    /**
     * The constructor for the PlayersJsonServiceTest.
     *
     * @since 0.4.1
     */
    public PlayersJsonServiceTest() {
        this.playersJsonService = new PlayersJsonService();
    }

    /**
     * Ensure that a valid player model is returned
     * from the PlayersJsonService.
     *
     * NOTE: For this test to work the 'app.service.jsonFileName'
     * property must equal 'test.json'.
     *
     * @since 0.4.1
     */
    @Test
    public void getValid() {
        Player player = this.playersJsonService.get(false);
        assertNotNull(player);
    }
}
