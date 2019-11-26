package ippo.assignment2.services;

import ippo.assignment2.collections.ItemsCollection;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayersTest {
    PlayersService playersService;

    public PlayersTest() {
        this.playersService = new PlayersService();
    }

    @Test
    public void getValid() throws IOException {
        Player player = this.playersService.get(false);
        assertTrue(player instanceof Player);
        assertTrue(player.getDirection() instanceof Direction);
        assertTrue(player.getItems() instanceof ItemsCollection);
        assertTrue(player.getRoom() instanceof Room);
    }
}
