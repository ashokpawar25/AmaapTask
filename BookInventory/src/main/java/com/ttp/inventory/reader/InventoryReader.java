package com.ttp.inventory.reader;

import com.ttp.inventory.database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryReader {
    Database database;
    public InventoryReader(Database database)
    {
        this.database = database;
    }

    public ResultSet getAllBooks() throws SQLException, ClassNotFoundException {
        ResultSet resultSet=database.readInventory();
        return resultSet;
    }
}
