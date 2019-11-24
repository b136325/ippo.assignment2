package ippo.assignment2.controllers;

import ippo.assignment2.models.Player;
import ippo.assignment2.services.Players;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @since 0.1.2
 */
public class MainController extends BaseController implements Initializable {

    @FXML
    private HeaderController headerController;

    @FXML
    private ImageController imageController;

    private Player player;

    @FXML
    private Players playerServices;

    @FXML
    private NavigationController navigationController;

    /**
     *
     * @param url
     * @param resourceBundle
     * @since 0.1.3
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.player = this.playerServices.get(true);

            headerController.setPlayer(this.player);
            imageController.setPlayer(this.player);
            navigationController.setPlayer(this.player);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
