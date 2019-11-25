package ippo.assignment2.controllers;

import ippo.assignment2.utils.Properties;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeaderControllerTest extends BaseControllerTest {
    public Properties properties;
    public TextField title;

    @Override
    public String getViewerPath() {
        return "/fxml/HeaderViewer.fxml";
    }

    @BeforeEach
    public void setUp() throws IOException {
        this.properties = new Properties();
        this.title = (TextField) this.findGuiElement("#title");
    }

    @Test
    public void titleTest() {
        String expectedTitleText = this.properties.getValue("header.title");
        String foundTitleText = this.title.getText();

        assertEquals(foundTitleText, expectedTitleText);
    }
}
