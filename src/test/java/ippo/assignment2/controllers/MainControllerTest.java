package ippo.assignment2.controllers;

import ippo.assignment2.helpers.ControllerTestHelper;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;
import ippo.assignment2.utils.Properties;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @since 0.3.0
 */
public class MainControllerTest extends ControllerTestHelper {
    public TextField title;

    /**
     *
     * @return
     * @since 0.3.0
     */
    @Override
    public Player buildControllerTestData() {
        Room room = new Room(null, null);
        Player player = new Player(Direction.BACK, null, room, "Username1");
        return player;
    }

    /**
     *
     * @return
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
        this.properties = new Properties();
        this.title = (TextField) this.findGuiElement("#title");
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
