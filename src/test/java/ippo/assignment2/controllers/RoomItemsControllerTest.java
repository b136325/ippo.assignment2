package ippo.assignment2.controllers;

import ippo.assignment2.helpers.ControllerTestHelper;
import ippo.assignment2.mocks.RoomItemsControllerMock;
import ippo.assignment2.models.Player;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test the view of the RoomItemsController.
 *
 * @since 0.3.0
 */
public class RoomItemsControllerTest extends ControllerTestHelper {

    public ImageView imageViewer1;
    public Button pickUpButton1;

    /**
     * Construct mock data.
     *
     * @return The mock data to be passed to the RoomItemsController.
     *
     * @since 0.3.0
     */
    @Override
    public Player buildControllerTestData() {
        return RoomItemsControllerMock.createMock();
    }

    /**
     * Return the path to the .fxml file associated with the RoomItemsController.
     *
     * @return The path to the associated .fxml file.
     *
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
        this.pickUpButton1 = (Button) this.findGuiElement("#pickUpButton1");
        this.imageViewer1 = (ImageView) this.findGuiElement("#imageViewer1");
    }

    /**
     * @since 0.3.0
     */
    @Test
    public void imageViewerTest() {
        assertNull(this.imageViewer1.getImage());
    }

    /**
     * @since 0.3.0
     */
    @Test
    public void pickUpButtonTest() {
        assertEquals(this.pickUpButton1.getText(), "Pick Up");
    }
}
