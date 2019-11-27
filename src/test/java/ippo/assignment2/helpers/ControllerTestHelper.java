package ippo.assignment2.helpers;

import ippo.assignment2.controllers.IController;
import ippo.assignment2.models.Player;
import ippo.assignment2.properties.PropertiesSingleton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import org.testfx.framework.junit5.ApplicationTest;

/**
 * @since 0.3.0
 */
public abstract class ControllerTestHelper extends ApplicationTest {
    protected IController controller;
    protected PropertiesSingleton properties;

    /**
     *
     * @param stage
     * @throws Exception
     * @since 0.3.0
     */
    @Override
    public void start(Stage stage) throws Exception {
        this.loadNode(stage);
        Player player = this.buildControllerTestData();
        this.setPlayer(player);
        this.properties = PropertiesSingleton.getInstance();
    }

    /**
     * @since 0.3.0
     */
    public abstract Player buildControllerTestData();


    /**
     *
     * @return
     * @since 0.3.0
     */
    public abstract String getViewerFxmlPath();

    /**
     *
     * @param query
     * @param <T>
     * @return
     * @since 0.3.0
     */
    public <T extends Node> Node findGuiElement(final String query) {
        return lookup(query).query();
    }

    /**
     *
     * @param stage
     * @throws IOException
     * @since 0.3.0
     */
    public void loadNode(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.getViewerFxmlPath()));
        Parent mainNode = loader.load();
        this.controller = loader.getController();
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    /**
     *
     * @param player
     * @since 0.3.0
     */
    public void setPlayer(Player player) {
        this.controller.setPlayer(player);
    }
}
