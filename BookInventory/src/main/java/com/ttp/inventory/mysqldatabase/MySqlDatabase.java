package com.ttp.inventory.mysqldatabase;

import com.ttp.inventory.database.Database;
import com.ttp.inventory.model.exception.QuantityOverflowException;

import java.sql.*;

public class MySqlDatabase implements Database {

    String url;
    String username;
    String password;
    Connection connection;
    public MySqlDatabase(String url, String username, String password)
    {
        this.url = url;
        this.username = username;
        this.password = password;

    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url,username,password);
        return connection;
    }

    @Override
    public ResultSet readInventory() throws SQLException, ClassNotFoundException {
        connection = this.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from bookInventory");
        return resultSet;
    }

    @Override
    public int writeInventory() throws SQLException, ClassNotFoundException {
        connection = this.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Insert into bookInventory values (?,?,?,?,?,?,?)");
        preparedStatement.setInt(1,2);
        preparedStatement.setString(2,"java programming");
        preparedStatement.setString(3,"James ghosling");
        preparedStatement.setString(4,"Anand publication");
        preparedStatement.setInt(5,100);
        preparedStatement.setDouble(6,150);
        preparedStatement.setString(7,"Programming");
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected;
    }

    @Override
    public int updateBookQuantity(int bookId, int quantityToUpdate) throws SQLException, ClassNotFoundException, QuantityOverflowException {
        connection = this.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select quantity from bookInventory where bookId =" + bookId);
        resultSet.next();
        int availableQuantity = resultSet.getInt("quantity");
        availableQuantity += quantityToUpdate;
        System.out.println(availableQuantity);
        if(availableQuantity > 100)
        {
            throw new QuantityOverflowException("You can't add books more than 100");
        }
        PreparedStatement preparedStatement = connection.prepareStatement("Update BookInventory set quantity = "+availableQuantity+ " where bookId = "+bookId);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected;
    }
}
