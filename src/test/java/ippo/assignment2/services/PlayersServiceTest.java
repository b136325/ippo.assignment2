package ippo.assignment2.services;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A test class for the PlayersService.
 *
 * @since 0.4.0
 */
public class PlayersServiceTest {
    PlayersService playersService;

    /**
     * The constructor for PlayersServiceTest.
     *
     * @since 0.4.0
     */
    public PlayersServiceTest() {
        this.playersService = new PlayersService();
    }

    /**
     * Ensure that the service returns a valid player model.
     *
     * @since 0.4.0
     */
    @Test
    public void getValid() {
        Player player = this.playersService.get(false);
        assertTrue(player instanceof Player);
        assertTrue(player.getDirection() instanceof Direction);
        assertTrue(player.getItems() instanceof ItemsCollection);
        assertTrue(player.getRoom() instanceof Room);
    }
}
