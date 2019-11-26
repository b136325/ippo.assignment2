package ippo.assignment2.controllers;

import ippo.assignment2.helpers.ControllerTestHelper;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;
import ippo.assignment2.utils.PropertiesSingleton;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test the view of the MainController.
 *
 * @since 0.3.0
 */
public class MainControllerTest extends ControllerTestHelper {
    public PropertiesSingleton properties = PropertiesSingleton.getInstance();
    public Label title;

    /**
     * Construct mock data.
     *
     * @return The mock data to be passed to the MainController.
     *
     * @since 0.3.0
     */
    @Override
    public Player buildControllerTestData() {
        Room room = new Room(null, null);
        Player player = new Player(Direction.BACK, null, room, "Username1");
        return player;
    }

    /**
     * Return the path to the .fxml file associated with the MainController.
     *
     * @return The path to the associated .fxml file.
     *
     * @since 0.3.0
     */
    @Override
    public String getViewerFxmlPath() {
        return "/fxml/MainViewer.fxml";
    }

    /**
     *
     * @throws IOException
     * @since 0.3.0
     */
    @BeforeEach
    public void setUp() throws IOException {
        this.title = (Label) this.findGuiElement("#title");
    }

    /**
     * @since 0.3.0
     */
    @Test
    public void titleTest() {
        String expectedTitleText = this.properties.getValue("header.title");
        String foundTitleText = this.title.getText();
        assertEquals(foundTitleText, expectedTitleText);
    }
}
