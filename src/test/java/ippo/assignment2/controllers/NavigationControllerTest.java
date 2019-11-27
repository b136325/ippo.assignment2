package ippo.assignment2.controllers;

import ippo.assignment2.helpers.ControllerTestHelper;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Test the view of the NavigationController.
 *
 * @since 0.3.0
 */
public class NavigationControllerTest extends ControllerTestHelper {

    /**
     * A reference to the (movement) forwardButton (defined within NavigationViewer.fxml).
     *
     * @since 0.4.3
     */
    private Button forwardButton;

    /**
     * A reference to the (orientation) northButton (defined within NavigationViewer.fxml).
     *
     * @since 0.4.3
     */
    private Button northButton;

    /**
     * A reference to the (orientation) eastButton (defined within NavigationViewer.fxml).
     *
     * @since 0.4.3
     */
    private Button eastButton;

    /**
     * A reference to the (orientation) southButton (defined within NavigationViewer.fxml).
     *
     * @since 0.4.3
     */
    private Button southButton;

    /**
     * A reference to the (orientation) westButton (defined within NavigationViewer.fxml).
     *
     * @since 0.4.3
     */
    private Button westButton;

    /**
     * A reference to the logger TextField (defined within NavigationViewer.fxml).
     *
     * @since 0.2.1
     */
    private TextField logger;

    /**
     * Construct mock data.
     *
     * @return The mock data to be passed to the NavigationController.
     *
     * @since 0.3.0
     */
    @Override
    public Player buildControllerTestData() {
        Player player = new Player(Direction.SOUTH, null, null, "Username1");
        return player;
    }

    /**
     * Return the path to the .fxml file associated with the NavigationController.
     *
     * @return The path to the associated .fxml file.
     *
     * @since 0.3.0
     */
    @Override
    public String getViewerFxmlPath() {
        return "/fxml/NavigationViewer.fxml";
    }

    /**
     * @since 0.3.0
     */
    @BeforeEach
    public void setUp() {
        // MOVEMENT
        this.forwardButton = (Button) this.findGuiElement("#forwardButton");

        // DIRECTION
        this.northButton = (Button) this.findGuiElement("#northButton");
        this.eastButton = (Button) this.findGuiElement("#eastButton");
        this.southButton = (Button) this.findGuiElement("#southButton");
        this.westButton = (Button) this.findGuiElement("#westButton");

        this.logger = (TextField) this.findGuiElement("#logger");
    }

    /**
     * @since 0.3.0
     */
    @Test
    public void buttonTitleTest() {
        // MOVEMENT
        assertEquals(this.forwardButton.getText(), "Forwards");

        // DIRECTION
        assertEquals(this.northButton.getText(), "North");
        assertEquals(this.eastButton.getText(), "East");
        assertEquals(this.southButton.getText(), "South");
        assertEquals(this.westButton.getText(), "West");
    }

    /**
     * @since 0.3.0
     */
    @Test
    public void buttonDisabilityTest() {
        assertFalse(this.northButton.isDisabled());
        assertFalse(this.eastButton.isDisabled());
        assertFalse(this.southButton.isDisabled());
        assertFalse(this.westButton.isDisabled());
    }
}
