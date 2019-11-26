package ippo.assignment2.controllers;

import ippo.assignment2.models.Player;
import java.util.Observable;

/**
 * An interface for concrete controllers.
 *
 * @since 0.3.0
 */
public interface IController {
    void setPlayer(Player player);
    void update(Observable o, Object arg);
    void updateView();
}
