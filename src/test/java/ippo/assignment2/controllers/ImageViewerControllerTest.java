package ippo.assignment2.controllers;

import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ImageViewerControllerTest extends BaseControllerTest {
    public ImageView imageViewer;

    @Override
    public String getViewerPath() {
        return "/fxml/ImageViewer.fxml";
    }

    @BeforeEach
    public void setUp() {
        this.imageViewer = (ImageView) this.findGuiElement("#imageViewer");
    }

    @Test
    public void buttonTitleTest() {
        assertNull(this.imageViewer.getImage());
    }
}
