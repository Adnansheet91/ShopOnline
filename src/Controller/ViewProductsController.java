package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import Module.DataBase;
import Module.Products;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class ViewProductsController implements Initializable {
    DataBase dataBase;
    @FXML
    private Pane mainPane;

    @FXML
    private Pane downPane;

    @FXML
    private TableView<Products> productsTable;

    @FXML
    private TableColumn<Products, String> productNameCol;

    @FXML
    private TableColumn<Products, String> productPriceCol;

    @FXML
    private TableColumn<Products, String> qualityCol;

    ObservableList<Products> listOfProducts = FXCollections.observableArrayList ();

    @FXML
    void addToCart(ActionEvent event) {
        Products productsToEdit = productsTable.getSelectionModel ().getSelectedItem ();
        if (productsToEdit == null) {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setHeaderText (null);
            alert.setContentText ("Please choose an item first!");
            return;
        }
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setContentText ("Are you sure you want to buy this product: " + productsToEdit.name + " ?");

        Optional<ButtonType> answerOfUser = alert.showAndWait ();
        if (answerOfUser.get () == ButtonType.OK) {
            boolean result = dataBase.getInstance ().buyProduct (productsToEdit);
            if (result) {
                alert.setContentText ("Purchase was successful!");
                listOfProducts.remove (productsToEdit);
            } else {
                alert.setContentText ("Purchase was canceled");
            }
        }
    }


    private void editCol() {
        productNameCol.setCellValueFactory (new PropertyValueFactory<> ("name"));
        productPriceCol.setCellValueFactory (new PropertyValueFactory<> ("price"));
        qualityCol.setCellValueFactory (new PropertyValueFactory<> ("quality"));


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        editCol ();
        DataBase dataBase = DataBase.getInstance ();
        String qu = "SELECT product_Name,price,quality " +
                "From products";
        ResultSet resultSet = dataBase.execQuery (qu);
        try {
            while (resultSet.next ()) {
                String product_name = resultSet.getString ("product_Name");
                String price = resultSet.getString ("price");
                String quantity = resultSet.getString ("quality");


                listOfProducts.add (new Products (product_name, price, quantity));
            }

        } catch (SQLException e) {
            e.printStackTrace ();
        }
        productsTable.setItems (listOfProducts);
    }


}

