package ippo.assignment2.controllers;

import ippo.assignment2.assertions.AssertNotNull;
import javafx.fxml.FXML;

/**
 *  An Observer controller for MainViewer.fxml.
 *
 * @since 0.1.2
 */
public class MainController extends AbstractObserverController implements IController {

    /**
     * A reference to the child headerController (defined within HeaderViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private HeaderController headerController;

    /**
     * A reference to the child imageController (defined within ImageViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private ImageController imageController;

    /**
     * A reference to the child navigationController (defined within NavigationViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private NavigationController navigationController;

    /**
     * A reference to the child playerItemsController (defined within PlayerItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private PlayerItemsController playerItemsController;

    /**
     * A reference to the child roomItemsController (defined within RoomItemsViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private RoomItemsController roomItemsController;

    /**
     * Update the view following a change to the model.
     *
     * @since 0.2.1
     */
    public void updateView() {
        this.assertChildControllers();
        this.passPlayerToChildControllers();
        this.enableChildControllersToObservePlayerChanges();
    }

    /**
     * Ensure that all of the child controllers are valid.
     *
     * @since 0.2.1
     */
    private void assertChildControllers() {
        AssertNotNull.controller(this.headerController);
        AssertNotNull.controller(this.imageController);
        AssertNotNull.controller(this.navigationController);
        AssertNotNull.controller(this.playerItemsController);
        AssertNotNull.controller(this.roomItemsController);
    }

    /**
     * Register the child controllers to observe player model changes.
     *
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
     * Pass 'this.player' to the child controllers.
     *
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
