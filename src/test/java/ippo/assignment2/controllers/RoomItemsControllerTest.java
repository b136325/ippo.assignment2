package ippo.assignment2.controllers;

import ippo.assignment2.helpers.ControllerTestHelper;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @since 0.3.0
 */
public class RoomItemsControllerTest extends ControllerTestHelper {

    private ImageView imageViewer;
    private Button pickUpButton;

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
        return "/fxml/RoomItemsViewer.fxml";
    }

    /**
     * @since 0.3.0
     */
    @BeforeEach
    public void setUp() {
        this.pickUpButton= (Button) this.findGuiElement("#pickUpButton");
        this.imageViewer = (ImageView) this.findGuiElement("#imageViewer");
    }

    /**
     * @since 0.3.0
     */
    @Test
    public void imageViewerTest() {
        assertNull(this.imageViewer.getImage());
    }

    /**
     * @since 0.3.0
     */
    @Test
    public void pickUpButtonTest() {
        assertEquals(this.pickUpButton.getText(), "Pick up");
    }
}
