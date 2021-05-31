package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import Module.DataBase;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddProductsController implements Initializable {


    @FXML
    private TextField productName;

    @FXML
    private TextField productPrice;

    @FXML
    private TextField productQuality;
    DataBase dataBase;

    @FXML
    void addProducts(ActionEvent event) throws SQLException {
        DataBase dataBase = new DataBase ();

        String qu = "INSERT INTO products (product_Name,price,quality)" +
                "VALUES(?,?,?)";

        PreparedStatement pst;
        pst = dataBase.connection.prepareStatement (qu);
        pst.setString (1, productName.getText ());
        pst.setString (2, productPrice.getText ());
        pst.setString (3, productQuality.getText ());

        pst.execute ();
        pst.close ();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataBase = DataBase.getInstance ();
    }
}
