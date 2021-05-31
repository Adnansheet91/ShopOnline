package Module;

import java.sql.*;

public class DataBase {


    private static DataBase databaseHandler = null;
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static Connection connection = null;
    public static Statement statement = null;
    String passwordFromDatabase = "";
    final String secretKey = "ssshhhhhhhhhhh!!!!";
    PreparedStatement preparedStatement;

    public static DataBase getInstance() {
        if (databaseHandler == null) {
            try {
                databaseHandler = new DataBase ();
            } catch (SQLException throwables) {
                throwables.printStackTrace ();
            }
        }
        return databaseHandler;
    }


    public DataBase() throws SQLException {
        createConnection ();
    }


    void createConnection() {
        try {

            Class.forName (DRIVER).newInstance ();
            connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "root");
            System.out.println ("Connection success");
        } catch (Exception e) {

            e.printStackTrace ();
        }
    }


    public ResultSet execQuery(String query) {
        ResultSet result;
        try {
            statement = connection.createStatement ();
            result = statement.executeQuery (query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return null;
        } finally {
        }
        return result;
    }

    public boolean buyProduct(Products products) {
        try {


            String deleteStat = "DELETE FROM products WHERE product_Name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement (deleteStat);
            preparedStatement.setString (1, products.name);
            preparedStatement.executeUpdate ();
            return true;
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return false;
    }

}
