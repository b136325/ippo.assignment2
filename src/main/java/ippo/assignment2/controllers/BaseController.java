package ippo.assignment2.controllers;

import ippo.assignment2.models.Player;

/**
 * @since 0.2.0
 */
public class BaseController {

    protected Player player;

    /**
     *
     * @param player
     * @since 0.2.0
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
}
