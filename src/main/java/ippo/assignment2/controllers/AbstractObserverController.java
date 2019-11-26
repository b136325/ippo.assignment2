package ippo.assignment2.controllers;

import ippo.assignment2.assertions.AssertNotNull;
import ippo.assignment2.models.Player;
import java.util.Observable;
import java.util.Observer;

/**
 * An abstract parent class for the controllers, which implements Observer functionality.
 *
 * @since 0.2.0
 */
public abstract class AbstractObserverController implements Observer {

    /**
     * A concrete instance of the Player model.
     *
     * @since 0.2.1
     */
    protected Player player;

    /**
     * A method that the returns the player associated with the controller.
     *
     * @return The player associated with the controller or null.
     *
     * @since 0.2.0
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * A method that the receives a 'player' which will be used to
     * update the view associated with the controller.
     *
     * @param player The player to be passed to the controller.
     * @throws AssertionError When 'player' is null.
     *
     * @since 0.2.0
     */
    public void setPlayer(Player player) {
        AssertNotNull.player(player);
        this.player = player;
        this.updateView();
    }

    /**
     * This method implements the Observer interface.
     * It will triggered when the Player model changes,
     * and it calls 'setPlayer' with the updated model.
     *
     * @param o The updated Observable (or Player).
     * @param arg
     *
     * @since 0.2.0
     */
    @Override
    public void update(Observable o, Object arg) {
        Player player = (Player)o;
        this.setPlayer(player);
    }

    /**
     * This method will update the view following a change to the model,
     * and it will be called (via 'setPlayer') when the model changes.
     * This method must be implemented in controller extending from
     * AbstractObserverController.
     *
     * @since 0.2.1
     */
    abstract void updateView();
}
