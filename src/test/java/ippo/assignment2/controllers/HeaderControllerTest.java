package ippo.assignment2.controllers;

import ippo.assignment2.helpers.ControllerTestHelper;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test the view of the HeaderController.
 *
 * @since 0.3.0
 */
public class HeaderControllerTest extends ControllerTestHelper {

    /**
     * A reference to the title Label (defined within HeaderViewer.fxml).
     *
     * @since 0.3.5
     */
    public Label title;

    /**
     * A reference to the username Label (defined within HeaderViewer.fxml).
     *
     * @since 0.3.5
     */
    public Label username;

    /**
     * Construct mock data.
     *
     * @return The mock data to be passed to the HeaderController.
     *
     * @since 0.3.0
     */
    @Override
    public Player buildControllerTestData() {
        Player player = new Player(Direction.BACK, null, null, "Username1");
        return player;
    }

    /**
     * Return the path to the .fxml file associated with the HeaderController.
     *
     * @return The path to the associated .fxml file.
     *
     * @since 0.3.0
     */
    @Override
    public String getViewerFxmlPath() {
        return "/fxml/HeaderViewer.fxml";
    }


    @BeforeEach
    public void setUp() {
        this.title = (Label) this.findGuiElement("#title");
        this.username = (Label) this.findGuiElement("#username");
    }

    @Test
    public void titleTest() {
        String expectedTitleText = this.properties.getValue("header.title");
        String foundTitleText = this.title.getText();
        assertEquals(foundTitleText, expectedTitleText);
    }

    @Test
    public void usernameTest() {
        assertEquals(this.username.getText(), "Username1");
    }
}
