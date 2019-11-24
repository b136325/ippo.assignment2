package ippo.assignment2.services;

import ippo.assignment2.collections.Items;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.PlayerObservable;
import ippo.assignment2.models.Room;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayersTest {
    Players playersService;

    public PlayersTest() {
        this.playersService = new Players();
    }

    @Test
    public void getValid() throws IOException {
        PlayerObservable player = this.playersService.get(false);
        assertTrue(player instanceof PlayerObservable);
        assertTrue(player.getDirection() instanceof Direction);
        assertTrue(player.getItems() instanceof Items);
        assertTrue(player.getRoom() instanceof Room);
    }
}
