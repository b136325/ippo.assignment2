package ippo.assignment2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ippo.assignment2.controllers.MainController;

public class App extends javafx.application.Application {

    public static void main(String args[]) {
        launch(args);
    }

    public void start(Stage stage) {

        try {

            String viewerFxml = "MainControllerViewer.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource(viewerFxml));
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
