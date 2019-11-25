package ippo.assignment2.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.testfx.framework.junit5.ApplicationTest;
import java.io.IOException;

public abstract class BaseControllerTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        this.loadNode(stage);
    }

    abstract String getViewerPath();

    public <T extends Node> Node findGuiElement(final String query) {
        return lookup(query).query();
    }

    public void loadNode(Stage stage) throws IOException {
        Parent mainNode = FXMLLoader.load(getClass().getResource(this.getViewerPath()));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }
}
