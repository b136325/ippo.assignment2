package ippo.assignment2.controllers;

import ippo.assignment2.helpers.ControllerTestHelper;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @since 0.3.0
 */
public class HeaderControllerTest extends ControllerTestHelper {
    public TextField title;

    /**
     *
     * @return
     * @since 0.3.0
     */
    @Override
    public Player buildControllerTestData() {
        Player player = new Player(Direction.BACK, null, null, "Username1");
        return player;
    }

    /**
     *
     * @return
     * @since 0.3.0
     */
    @Override
    public String getViewerFxmlPath() {
        return "/fxml/HeaderViewer.fxml";
    }


    @BeforeEach
    public void setUp() {
        this.title = (TextField) this.findGuiElement("#title");
    }

    @Test
    public void titleTest() {
        String expectedTitleText = this.properties.getValue("header.title");
        String foundTitleText = this.title.getText();

        assertEquals(foundTitleText, expectedTitleText);
    }
}
