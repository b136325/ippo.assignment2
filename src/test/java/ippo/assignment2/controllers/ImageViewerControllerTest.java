package ippo.assignment2.controllers;

import ippo.assignment2.helpers.ControllerTestHelper;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Player;
import ippo.assignment2.models.Room;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test the view of the ImageViewerController.
 *
 * @since 0.3.0
 */
public class ImageViewerControllerTest extends ControllerTestHelper {
    public ImageView imageViewer;

    /**
     * Construct mock data.
     *
     * @return The mock data to be passed to the ImageViewerController.
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
     * Return the path to the .fxml file associated with the ImageViewerController.
     *
     * @return The path to the associated .fxml file.
     *
     * @since 0.3.0
     */
    @Override
    public String getViewerFxmlPath() {
        return "/fxml/ImageViewer.fxml";
    }

    /**
     * @since 0.3.0
     */
    @BeforeEach
    public void setUp() {
        this.imageViewer = (ImageView) this.findGuiElement("#imageViewer");
    }

    /**
     * @since 0.3.0
     */
    @Test
    public void imageViewerHasNullImageTest() {
        assertNull(this.imageViewer.getImage());
    }
}
