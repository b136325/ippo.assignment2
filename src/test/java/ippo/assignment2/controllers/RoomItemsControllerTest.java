package ippo.assignment2.controllers;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RoomItemsControllerTest extends BaseControllerTest {

    private ImageView imageViewer;
    private Button pickUpButton;

    @Override
    public String getViewerPath() {
        return "/fxml/RoomItemsViewer.fxml";
    }

    @BeforeEach
    public void setUp() {
        this.pickUpButton= (Button) this.findGuiElement("#pickUpButton");
        this.imageViewer = (ImageView) this.findGuiElement("#imageViewer");
    }

    @Test
    public void imageViewerTest() {
        assertNull(this.imageViewer.getImage());
    }

    @Test
    public void pickUpButtonTest() {
        assertEquals(this.pickUpButton.getText(), "Pick up");
    }
}
