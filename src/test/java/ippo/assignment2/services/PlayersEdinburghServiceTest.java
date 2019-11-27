package ippo.assignment2.services;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A test class for the PlayersEdinburghService.
 *
 * @since 0.4.0
 */
public class PlayersEdinburghServiceTest {
    PlayersEdinburghService playersEdinburghService;

    /**
     * The constructor for PlayersEdinburghServiceTest.
     *
     * @since 0.4.0
     */
    public PlayersEdinburghServiceTest() {
        this.playersEdinburghService = new PlayersEdinburghService();
    }

    /**
     * Ensure that the service returns a valid player model.
     *
     * @since 0.4.0
     */
    @Test
    public void getValid() {
        Player player = this.playersEdinburghService.get(false);
        assertTrue(player instanceof Player);
        assertTrue(player.getDirection() instanceof Direction);
        assertTrue(player.getRoom() instanceof Room);
    }
}
