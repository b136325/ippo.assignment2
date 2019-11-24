package ippo.assignment2.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import ippo.assignment2.assertions.Assert;
import ippo.assignment2.models.PlayerObservable;

/**
 * @since 0.1.2
 */
public class MainController extends BaseController implements Initializable {

    @FXML
    private HeaderObserverController headerController;

    @FXML
    private ImageObserverController imageController;

    @FXML
    private NavigationObserverController navigationController;

    @FXML
    private PlayerItemsObserverController playerItemsController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @Override
    public void setPlayer(PlayerObservable player) {
        super.setPlayer(player);

        this.assertChildControllers();
        this.passPlayerToChildControllers();
        this.enableChildControllersToObservePlayerChanges();
    }

    /**
     * @since 0.2.1
     */
    private void assertChildControllers() {
        Assert.headerController(this.headerController);
        Assert.imageController(this.imageController);
        Assert.navigationController(this.navigationController);
        Assert.playerItemsController(this.playerItemsController);
    }

    /**
     * @since 0.2.1
     */
    private void passPlayerToChildControllers() {
        this.headerController.setPlayer(this.player);
        this.imageController.setPlayer(this.player);
        this.navigationController.setPlayer(this.player);
        this.playerItemsController.setPlayer(this.player);
    }

    /**
     * @since 0.2.1
     */
    private void enableChildControllersToObservePlayerChanges() {
        this.player.addObserver(this.headerController);
        this.player.addObserver(this.imageController);
        this.player.addObserver(this.navigationController);
        this.player.addObserver(this.playerItemsController);
    }
}
