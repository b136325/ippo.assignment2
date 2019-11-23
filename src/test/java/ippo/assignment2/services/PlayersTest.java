package ippo.assignment2.services;

import ippo.assignment2.collections.Items;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayersTest {
    Players playersService;

    public PlayersTest() {
        this.playersService = new Players();
    }

    @Test
    public void getValid() {
        Player player = this.playersService.get();
        assertTrue(player instanceof Player);
        assertTrue(player.getDirection() instanceof Direction);
        assertTrue(player.getItems() instanceof Items);
        assertTrue(player.getRoom() instanceof Room);
    }
}
