package ippo.assignment2.controllers;

import ippo.assignment2.collections.Items;
import ippo.assignment2.helpers.ControllerTestHelper;
import ippo.assignment2.models.Direction;
import ippo.assignment2.models.Item;
import ippo.assignment2.models.Player;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @since 0.3.0
 */
public class PlayerItemsControllerTest extends ControllerTestHelper {

    private TextField counter;
    private ImageView imageViewer1;
    private ImageView imageViewer2;
    private ImageView imageViewer3;
    private ImageView imageViewer4;
    private Button putDownButton1;
    private Button putDownButton2;
    private Button putDownButton3;
    private Button putDownButton4;

    /**
     *
     * @return
     * @since 0.3.0
     */
    @Override
    public Player buildControllerTestData() {
        Image imageOne = new Image("/images/edinburgh.jpg");
        Item itemOne = new Item(imageOne, "Edinburgh");
        Items items = new Items();
        items.add(itemOne);
        Player player = new Player(Direction.BACK, items, null, "Username1");

        return player;
    }

    /**
     *
     * @return
     * @since 0.3.0
     */
    @Override
    public String getViewerFxmlPath() {
        return "/fxml/PlayerItemsViewer.fxml";
    }

    /**
     *
     * @throws IOException
     * @since 0.3.0
     */
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

    /**
     * @since 0.3.0
     */
    @Test
    public void counterTest() {
        assertEquals(this.counter.getText(), "1");
    }

    /**
     * @since 0.3.0
     */
    @Test
    public void imageViewerTest() {
        assertNotNull(this.imageViewer1.getImage());
        assertNull(this.imageViewer2.getImage());
        assertNull(this.imageViewer3.getImage());
        assertNull(this.imageViewer4.getImage());
    }

    /**
     * @since 0.3.0
     */
    @Test
    public void putDownButtonTest() {
        assertEquals(this.putDownButton1.getText(), "Put Down");
        assertEquals(this.putDownButton2.getText(), "Put Down");
        assertEquals(this.putDownButton3.getText(), "Put Down");
        assertEquals(this.putDownButton4.getText(), "Put Down");
    }
}
