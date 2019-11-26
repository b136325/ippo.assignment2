package ippo.assignment2.controllers;

import ippo.assignment2.utils.Properties;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;

/**
 * An Observer controller for HeaderViewer.fxml.
 * @since 0.1.2
 */
public class HeaderController extends AbstractObserverController implements IController {

    @FXML
    private TextField title;

    @FXML
    private TextField username;

    /**
     *
     * @since 0.3.1
     */
    @Override
    public void updateView() {
        try {
            this.updateViewTitle();
            this.updateViewUsername();
        } catch(Exception e) {

        }
    }

    /**
     *
     * @throws IOException
     * @since 0.3.1
     */
    private void updateViewTitle() throws IOException {
        Properties properties = new Properties();
        String propertyName = "header.title";

        if (properties.has(propertyName)) {
            String propertyValue = properties.getValue(propertyName);
            this.title.setText(propertyValue);
        }
    }

    /**
     *
     * @throws IOException
     * @since 0.3.1
     */
    private void updateViewUsername() {
        String username = player.getUsername();

        if (username != null) {
            this.username.setText(username);
        }
    }
}
