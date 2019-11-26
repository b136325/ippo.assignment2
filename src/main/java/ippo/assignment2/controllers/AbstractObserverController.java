package ippo.assignment2.controllers;

import ippo.assignment2.assertions.Assert;
import ippo.assignment2.models.Player;
import java.util.Observable;
import java.util.Observer;

/**
 * An abstract parent class for the controllers, which implements Observer functionality.
 * @since 0.2.0
 */
public abstract class AbstractObserverController implements Observer {

    protected Player player;

    /**
     *
     * @param player
     * @since 0.2.0
     */
    public void setPlayer(Player player) {
        Assert.player(player);
        this.player = player;
        this.updateView();
    }

    /**
     *
     * @param o
     * @param arg
     * @since 0.2.0
     */
    @Override
    public void update(Observable o, Object arg) {
        Player player = (Player)o;
        this.setPlayer(player);
    }

    /**
     * @since 0.3.1
     */
    abstract void updateView();
}
