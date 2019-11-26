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
 * @since 0.1.2
 */
public class App extends Application {

    private final String  mainControllerViewerPath = "/fxml/MainViewer.fxml";
    private PropertiesSingleton properties = PropertiesSingleton.getInstance();

    /**
     *
     * @param args
     * @since 0.1.2
     */
    public static void main(String args[]) {
        launch(args);
    }

    /**
     *
     * @param stage
     * @since 0.1.2
     */
    public void start(Stage stage) {

        try {

            Player player = null;
            String propertyName = "app.service";
            IService service = null;
            ServicesFactory serviceFactory = null;

            serviceFactory = new ServicesFactory();
            service = serviceFactory.createServiceFromProperties(
                    this.properties,
                    propertyName
            );

            if (service != null) {
                try {
                    player = service.get(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource(this.mainControllerViewerPath));
            ScrollPane page = loader.load();

            Scene scene = new Scene(page);
            stage.setScene(scene);

            MainController mainController = loader.getController();
            mainController.setPlayer(player);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
