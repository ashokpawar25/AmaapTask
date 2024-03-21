package com.ttp.inventory.writer;

import com.ttp.inventory.database.Database;
import com.ttp.inventory.model.exception.QuantityOverflowException;

import java.sql.SQLException;

public class InventoryWriter {
    Database database ;
    public InventoryWriter(Database database) {
        this.database = database;
    }



    public int addBook() throws SQLException, ClassNotFoundException {
        int rowsAffected = database.writeInventory();
        return rowsAffected;
    }

    public int updateQuantity(int bookId, int quantityToUpdate) throws SQLException, ClassNotFoundException, QuantityOverflowException {
        int rowsAffected = database.updateBookQuantity(bookId,quantityToUpdate);
        return rowsAffected;
    }
}
