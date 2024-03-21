package com.ttp.inventory.database;

import com.ttp.inventory.model.exception.QuantityOverflowException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Database
{
    Connection getConnection() throws ClassNotFoundException, SQLException;

    ResultSet readInventory() throws SQLException, ClassNotFoundException;

    int writeInventory() throws SQLException, ClassNotFoundException;

    int updateBookQuantity(int bookId, int quantityToUpdate) throws SQLException, ClassNotFoundException, QuantityOverflowException;
}
