package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class UserController {


    @FXML
    private Button addProducts;

    @FXML
    private Button buyProducts;

    @FXML
    void addProducts(ActionEvent event) {
        createNewStage ("/View/AddProducts.fxml", "Add products");

    }

    @FXML
    void buyProducts(ActionEvent event) {
        createNewStage ("/View/ViewProducts.fxml", "Add products");
    }


    void createNewStage(String location, String name) {
        try {
            Parent parent = FXMLLoader.load (getClass ().getResource (location));
            Stage stage = new Stage (StageStyle.DECORATED);
            stage.setTitle (name);
            Scene scene = new Scene (parent);
            //  scene.getStylesheets().add(getClass().getResource("/Resources/Table.Css").toExternalForm());
            stage.setScene (scene);
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }


    }
}




