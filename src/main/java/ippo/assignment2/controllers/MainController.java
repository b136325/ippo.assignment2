package ippo.assignment2.controllers;

import ippo.assignment2.models.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Observer;
import java.util.ResourceBundle;

/**
 * @since 0.1.2
 */
public class MainController extends BaseController implements Initializable {

    @FXML
    private HeaderController headerController;

    @FXML
    private ImageController imageController;

    @FXML
    private NavigationController navigationController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @Override
    public void setPlayer(Player player) {
        super.setPlayer(player);

        this.headerController.setPlayer(this.player);
        this.imageController.setPlayer(this.player);
        this.navigationController.setPlayer(this.player);

        this.player.addObserver(this.headerController);
        this.player.addObserver(this.imageController);
        this.player.addObserver(this.navigationController);
    }
}
