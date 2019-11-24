package ippo.assignment2.controllers;

import ippo.assignment2.models.Direction;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.util.Observable;
import java.util.Observer;

/**
 * @since 0.1.2
 */
public class ImageController implements Observer { {

    @FXML
    private ImageView imageViewer;

    @Override
    public void update(Observable o, Object arg) {

    }
}
