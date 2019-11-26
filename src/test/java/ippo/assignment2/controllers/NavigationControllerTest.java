package ippo.assignment2.controllers;

import ippo.assignment2.helpers.ControllerTestHelper;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
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
    public Button backButton;
    public Button forwardButton;
    public Button leftButton;
    public Button rightButton;
    public TextField logger;

    /**
     * Construct mock data.
     *
     * @return The mock data to be passed to the NavigationController.
     *
     * @since 0.3.0
     */
    @Override
    public Player buildControllerTestData() {
        Player player = new Player(Direction.BACK, null, null, "Username1");
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
        this.backButton = (Button) this.findGuiElement("#backButton");
        this.forwardButton = (Button) this.findGuiElement("#forwardButton");
        this.leftButton = (Button) this.findGuiElement("#leftButton");
        this.rightButton = (Button) this.findGuiElement("#rightButton");
        this.logger = (TextField) this.findGuiElement("#logger");
    }

    /**
     * @since 0.3.0
     */
    @Test
    public void buttonTitleTest() {
        assertEquals(this.backButton.getText(), "Back");
        assertEquals(this.forwardButton.getText(), "Forward");
        assertEquals(this.leftButton.getText(), "Left");
        assertEquals(this.rightButton.getText(),"Right");
    }

    /**
     * @since 0.3.0
     */
    @Test
    public void buttonDisabilityTest() {
        assertFalse(this.backButton.isDisabled());
        assertFalse(this.forwardButton.isDisabled());
        assertFalse(this.leftButton.isDisabled());
        assertFalse(this.rightButton.isDisabled());
    }
}
