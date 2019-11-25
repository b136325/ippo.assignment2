package ippo.assignment2.controllers;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PlayerItemsControllerTest extends BaseControllerTest {

    private TextField counter;
    private ImageView imageViewer1;
    private ImageView imageViewer2;
    private ImageView imageViewer3;
    private ImageView imageViewer4;
    private Button putDownButton1;
    private Button putDownButton2;
    private Button putDownButton3;
    private Button putDownButton4;

    @Override
    public String getViewerPath() {
        return "/fxml/PlayerItemsViewer.fxml";
    }

    @BeforeEach
    public void setUp() {
        this.counter = (TextField) this.findGuiElement("#counter");
        this.imageViewer1 = (ImageView) this.findGuiElement("#imageViewer1");
        this.imageViewer2 = (ImageView) this.findGuiElement("#imageViewer2");
        this.imageViewer3 = (ImageView) this.findGuiElement("#imageViewer3");
        this.imageViewer4 = (ImageView) this.findGuiElement("#imageViewer4");
        this.putDownButton1 = (Button) this.findGuiElement("#putDownButton1");
        this.putDownButton2 = (Button) this.findGuiElement("#putDownButton2");
        this.putDownButton3 = (Button) this.findGuiElement("#putDownButton3");
        this.putDownButton4 = (Button) this.findGuiElement("#putDownButton4");
    }

    @Test
    public void counterTest() {
        assertEquals(this.counter.getText(), "");
    }

    @Test
    public void imageViewerTest() {
        assertNull(this.imageViewer1.getImage());
        assertNull(this.imageViewer2.getImage());
        assertNull(this.imageViewer3.getImage());
        assertNull(this.imageViewer4.getImage());
    }

    @Test
    public void putDownButtonTest() {
        assertEquals(this.putDownButton1.getText(), "Put Down");
        assertEquals(this.putDownButton2.getText(), "Put Down");
        assertEquals(this.putDownButton3.getText(), "Put Down");
        assertEquals(this.putDownButton4.getText(), "Put Down");
    }
}
