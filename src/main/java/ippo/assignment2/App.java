package ippo.assignment2;

import ippo.assignment2.controllers.MainController;
import ippo.assignment2.factories.ServicesFactory;
import ippo.assignment2.models.Player;
import ippo.assignment2.services.IService;
import ippo.assignment2.utils.PropertiesSingleton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The core Application class for ippo.assignment2.
 *
 * @since 0.1.2
 */
public class App extends Application {

    /**
     * @since 0.1.2
     */
    private final String appServicePropertyName = "app.service";

    /**
     * @since 0.3.6
     */
    private final String mainControllerViewerPath = "/fxml/MainViewer.fxml";

    /**
     * @since 0.3.6
     */
    private MainController mainController;

    /**
     * A static 'main' method that will trigger the 'start' method below.
     *
     * @param args String arguments received from Main.
     * @since 0.1.2
     */
    public static void main(String args[]) {
        launch(args);
    }

    /**
     * The application's start method, which constructs a FXML loader,
     * uses the loader to find the appropriate view and controller,
     * populates the controller with data, and, finally, displays the
     * view within the received stage.
     *
     * @param stage The GUI 'stage' within which the view will be displayed.
     *
     * @since 0.1.2
     */
    public void start(Stage stage) {

        try {

            // Construct the FXML loader for the .fxml view whose
            // path is represented by 'mainControllerViewerPath'.
            FXMLLoader loader = this.constructLoader(this.mainControllerViewerPath);

            // Retrieve the page from the loader, create a
            // scene containing the retrieved page, and add
            // the constructed scene to the received stage.
            this.setScene(loader, stage);

            // Using the value of 'appServicePropertyName' retrieve the
            // property value representing the name of the service from
            // which player data will be found, and then return the service.
            IService service = this.retrieveService(this.appServicePropertyName);

            // Find the default player from the service.
            Player defaultPlayer = service.get(true);

            // Find the main controller from the loader
            // and pass to it the default player.
            this.mainController = this.retrieveMainController(loader, defaultPlayer);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    /**
     * Construct the FXML loader for the .fxml view defined by the received 'viewPath'.
     *
     * @param viewPath The path to the .fxml view.
     * @return A concrete instance of FXMLLoader.
     *
     * @since 0.3.6
     */
    private FXMLLoader constructLoader(String viewPath) {
        return new FXMLLoader(getClass().getResource(viewPath));
    }

    /**
     * Using the received 'appServicePropertyName' this method retrieves the
     * associated property value that represents the name of the service from
     * which player data will be found. The method then returns the service.
     *
     * @param appServicePropertyName The property name of the service (app.service)
     *                               within the app.properties config file.
     *
     * @return A concrete instance of a service.
     *
     * @since 0.3.6
     */
    private IService retrieveService(String appServicePropertyName) {
        PropertiesSingleton properties = PropertiesSingleton.getInstance();

        return ServicesFactory.createServiceFromProperties(
                properties,
                appServicePropertyName
        );
    }

    /**
     * This method finds the main controller using the received FXML loader.
     * It also passes the received default player into the controller, and,
     * finally, it returns the controller.
     *
     * @param loader The FXML loader which will be used to find the controller.
     * @param defaultPlayer The player that will be passed to the controller.
     * @return The found and populated controller.
     *
     * @since 0.3.6
     */
    private MainController retrieveMainController(FXMLLoader loader, Player defaultPlayer) {
        MainController mainController = loader.getController();
        mainController.setPlayer(defaultPlayer);

        return mainController;
    }

    /**
     * This method retrieves the view from the received loader,
     * constructs a create with which to contain the retrieved view,
     * and, finally, it passes the constructed scene to the received stage.
     *
     * @param loader The FXML loader which will be used to find the view.
     * @param stage The stage to which the scene will be added.
     * @throws IOException
     *
     * @since 0.3.6
     */
    private void setScene(FXMLLoader loader, Stage stage) throws IOException {
        ScrollPane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
    }
}
