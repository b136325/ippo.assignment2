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

    /**
     * A reference to the title TextField (defined within HeaderViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private TextField title;

    /**
     * A reference to the username TextField (defined within HeaderViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private TextField username;

    /**
     * Update the view following a change to the model.
     *
     * @since 0.2.1
     */
    @Override
    public void updateView() {
        try {
            this.updateViewTitle();
            this.updateViewUsername();
        } catch(Exception e) {
            // @TODO add a mechanism for logging errors.
        }
    }

    /**
     * Update the title within the HeaderViewer.
     *
     * @throws IOException When instantiating Properties fails.
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
     * Update the username within the HeaderViewer.
     *
     * @since 0.3.1
     */
    private void updateViewUsername() {
        String username = player.getUsername();

        if (username != null) {
            this.username.setText(username);
        }
    }
}
