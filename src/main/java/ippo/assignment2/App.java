package ippo.assignment2;

import ippo.assignment2.factories.Services;
import ippo.assignment2.models.Player;
import ippo.assignment2.services.IService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ippo.assignment2.controllers.MainController;
import ippo.assignment2.utils.Properties;

/**
 * @since 0.1.2
 */
public class App extends Application {

    private final String  mainControllerViewerPath = "/fxml/MainViewer.fxml";
    private Properties properties = new Properties();

    public App() throws IOException {
    }

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

        Injector injector = Guice.createInjector(new GuiceModule());
        FXMLLoader fxmlLoader = new FXMLLoader();

        try {

            Player player = null;
            Properties properties = null;
            String propertyName = "app.service";
            IService service = null;
            Services serviceFactory = null;

            try {
                properties = new Properties();
            } catch (IOException e) {
                e.printStackTrace();
            }

            serviceFactory = new Services();
            service = serviceFactory.generateFromProperties(
                    properties,
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
            AnchorPane page =  (AnchorPane) loader.load(getClass().getResource(this.mainControllerViewerPath));
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
