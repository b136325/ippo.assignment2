package ippo.assignment2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import ippo.assignment2.controllers.MainController;
import ippo.assignment2.utils.Properties;

/**
 * @since 0.1.2
 */
public class App extends javafx.application.Application {

    private final String  mainControllerViewerPath =  "/fxml/MainControllerViewer.fxml";
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

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(this.mainControllerViewerPath));
            AnchorPane page =  (AnchorPane) loader.load(getClass().getResource(mainControllerViewerPath));
            Scene scene = new Scene(page);
            stage.setScene(scene);
            MainController mainController = loader.getController();
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
