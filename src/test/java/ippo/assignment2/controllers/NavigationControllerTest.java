package ippo.assignment2.controllers;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class NavigationControllerTest extends BaseControllerTest {
    public Button backButton;
    public Button forwardButton;
    public Button leftButton;
    public Button rightButton;
    public TextField logger;

    @Override
    public String getViewerPath() {
        return "/fxml/NavigationViewer.fxml";
    }

    @BeforeEach
    public void setUp() {
        this.backButton = (Button) this.findGuiElement("#backButton");
        this.forwardButton = (Button) this.findGuiElement("#forwardButton");
        this.leftButton = (Button) this.findGuiElement("#leftButton");
        this.rightButton = (Button) this.findGuiElement("#rightButton");
        this.logger = (TextField) this.findGuiElement("#logger");
    }

    @Test
    public void buttonTitleTest() {
        assertEquals(this.backButton.getText(), "Back");
        assertEquals(this.forwardButton.getText(), "Forward");
        assertEquals(this.leftButton.getText(), "Left");
        assertEquals(this.rightButton.getText(),"Right");
    }

    @Test
    public void buttonDisabilityTest() {
        assertFalse(this.backButton.isDisabled());
        assertFalse(this.forwardButton.isDisabled());
        assertFalse(this.leftButton.isDisabled());
        assertFalse(this.rightButton.isDisabled());
    }
}
