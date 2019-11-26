package ippo.assignment2.controllers;

import ippo.assignment2.assertions.Assert;
import javafx.fxml.FXML;

/**
 *  An Observer controller for MainViewer.fxml.
 * @since 0.1.2
 */
public class MainController extends AbstractObserverController implements IController {

    @FXML
    private HeaderController headerController;

    @FXML
    private ImageController imageController;

    @FXML
    private NavigationController navigationController;

    @FXML
    private PlayerItemsController playerItemsController;

    @FXML
    private RoomItemsController roomItemsController;

    /**
     * @since 0.3.1
     */
    public void updateView() {
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
        Assert.roomItemsController(this.roomItemsController);
    }

    /**
     * @since 0.2.1
     */
    private void enableChildControllersToObservePlayerChanges() {
        this.player.addObserver(this.headerController);
        this.player.addObserver(this.imageController);
        this.player.addObserver(this.navigationController);
        this.player.addObserver(this.playerItemsController);
        this.player.addObserver(this.roomItemsController);
    }

    /**
     * @since 0.2.1
     */
    private void passPlayerToChildControllers() {
        this.headerController.setPlayer(this.player);
        this.imageController.setPlayer(this.player);
        this.navigationController.setPlayer(this.player);
        this.playerItemsController.setPlayer(this.player);
        this.roomItemsController.setPlayer(this.player);
    }
}
