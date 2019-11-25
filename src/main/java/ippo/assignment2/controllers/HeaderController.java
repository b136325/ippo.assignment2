package ippo.assignment2.controllers;

import ippo.assignment2.models.Player;
import ippo.assignment2.utils.Properties;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

/**
 * @since 0.1.2
 */
public class HeaderController extends BaseController implements Observer, Initializable {

    private Properties properties;

    @FXML
    private TextField title;

    @FXML
    private TextField username;

    /**
     *
     * @param location
     * @param resources
     * @since 0.2.0
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String propertyName = "header.title";
        try {
            this.properties = new Properties();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (this.properties.has(propertyName)) {
            String propertyValue = this.properties.getValue(propertyName);
            this.title.setText(propertyValue);
        }
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
        String username = player.getUsername();

        if (username != null) {
            this.username.setText(username);
        }
    }
}
