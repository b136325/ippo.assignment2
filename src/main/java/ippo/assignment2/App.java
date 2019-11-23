package ippo.assignment2;

import com.sun.prism.ResourceFactoryListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import ippo.assignment2.controllers.MainController;

/**
 * @since 0.1.2
 */
public class App extends javafx.application.Application {

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

            String viewerFxml = "/fxml/MainControllerViewer.fxml";


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(viewerFxml));
            AnchorPane page = (AnchorPane) fxmlLoader.load();

            Scene scene = new Scene(page);
            stage.setScene(scene);
            MainController mainController = fxmlLoader.getController();

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
