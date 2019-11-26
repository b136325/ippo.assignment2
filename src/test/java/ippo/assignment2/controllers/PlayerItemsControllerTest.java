package ippo.assignment2.controllers;

import ippo.assignment2.helpers.ControllerTestHelper;
import ippo.assignment2.mocks.PlayerItemsControllerMock;
import ippo.assignment2.models.Player;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test the view of the PlayerItemsController.
 *
 * @since 0.3.0
 */
public class PlayerItemsControllerTest extends ControllerTestHelper {

    private Label counter;
    private ImageView imageViewer1;
    private ImageView imageViewer2;
    private ImageView imageViewer3;
    private ImageView imageViewer4;
    private Button putDownButton1;
    private Button putDownButton2;
    private Button putDownButton3;
    private Button putDownButton4;

    /**
     * Retrieve mock data from PlayerItemsControllerMock.
     *
     * @return The mock data to be passed to the PlayerItemsController.
     *
     * @since 0.3.0
     */
    @Override
    public Player buildControllerTestData() {
        return PlayerItemsControllerMock.createSimpleDataMock();
    }

    /**
     * Return the path to the .fxml file associated with the PlayerItemsController.
     *
     * @return The path to the associated .fxml file.
     *
     * @since 0.3.0
     */
    @Override
    public String getViewerFxmlPath() {
        return "/fxml/PlayerItemsViewer.fxml";
    }

    /**
     * Populate local properties (fields) with references to the image and button elements.
     *
     * @since 0.3.0
     */
    @BeforeEach
    public void setUp() {
        this.counter = (Label) this.findGuiElement("#counter");
        this.imageViewer1 = (ImageView) this.findGuiElement("#imageViewer1");
        this.imageViewer2 = (ImageView) this.findGuiElement("#imageViewer2");
        this.imageViewer3 = (ImageView) this.findGuiElement("#imageViewer3");
        this.imageViewer4 = (ImageView) this.findGuiElement("#imageViewer4");
        this.putDownButton1 = (Button) this.findGuiElement("#putDownButton1");
        this.putDownButton2 = (Button) this.findGuiElement("#putDownButton2");
        this.putDownButton3 = (Button) this.findGuiElement("#putDownButton3");
        this.putDownButton4 = (Button) this.findGuiElement("#putDownButton4");
    }

    /**
     * Test that the counter contains the expected number of items.
     *
     * @since 0.3.0
     */
    @Test
    public void counterTest() {
        assertEquals(this.counter.getText(), "1");
    }

    /**
     * Test that only one Item image has been shown.
     *
     * @since 0.3.0
     */
    @Test
    public void imageViewerTest() {
        assertNotNull(this.imageViewer1.getImage());
        assertNull(this.imageViewer2.getImage());
        assertNull(this.imageViewer3.getImage());
        assertNull(this.imageViewer4.getImage());
    }
}
