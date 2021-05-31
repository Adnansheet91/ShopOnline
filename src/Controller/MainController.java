package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button logInButton;

    @FXML
    void ifClick(ActionEvent event) {

        switchBetweenScenes (event, "/View/MainForUser.fxml");


    }


    void switchBetweenScenes(ActionEvent actionEvent, String location) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load (getClass ().getResource (location));
            Scene scene = new Scene (parent);
            // scene.getStylesheets().add(getClass().getResource("/Resources/Table.Css").toExternalForm());
            Stage stage = (Stage) ((Node) actionEvent.getSource ()).getScene ().getWindow ();
            stage.setScene (scene);
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }



}
