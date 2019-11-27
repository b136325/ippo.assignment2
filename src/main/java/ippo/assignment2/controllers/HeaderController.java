package ippo.assignment2.controllers;

import ippo.assignment2.loggers.ExceptionLogger;
import ippo.assignment2.properties.PropertiesSingleton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * An Observer controller for HeaderViewer.fxml.
 * @since 0.1.2
 */
public class HeaderController extends AbstractObserverController implements IController {

    /**
     * An instance of the ExceptionLogger.
     *
     * @since 0.4.4
     */
    private ExceptionLogger exceptionLogger = new ExceptionLogger();

    /**
     * A reference to the title Label (defined within HeaderViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Label title;

    /**
     * A reference to the username Label (defined within HeaderViewer.fxml).
     *
     * @since 0.2.1
     */
    @FXML
    private Label username;

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
            this.exceptionLogger.log(e);
        }
    }

    /**
     * Update the title within the HeaderViewer.
     *
     * @since 0.3.1
     */
    private void updateViewTitle() {
        PropertiesSingleton properties = PropertiesSingleton.getInstance();
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
