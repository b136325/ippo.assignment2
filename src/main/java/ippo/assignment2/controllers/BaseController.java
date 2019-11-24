package ippo.assignment2.controllers;

import ippo.assignment2.assertions.Assert;
import ippo.assignment2.models.PlayerObservable;

/**
 * @since 0.2.0
 */
public class BaseController {

    protected PlayerObservable player;

    /**
     *
     * @param player
     * @since 0.2.0
     */
    public void setPlayer(PlayerObservable player) {
        Assert.player(this.player);
        this.player = player;
    }
}
