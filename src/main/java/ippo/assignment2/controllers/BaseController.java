package ippo.assignment2.controllers;

import ippo.assignment2.assertions.Assert;
import ippo.assignment2.models.Player;

/**
 * @since 0.2.0
 */
public class BaseController implements IController {

    protected Player player;

    /**
     *
     * @param player
     * @since 0.2.0
     */
    public void setPlayer(Player player) {
        Assert.player(player);
        this.player = player;
    }
}
