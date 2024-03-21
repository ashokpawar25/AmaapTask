package com.ttp.inventory.writer;

import com.ttp.inventory.database.Database;
import com.ttp.inventory.model.exception.QuantityOverflowException;
import com.ttp.inventory.mysqldatabase.MySqlDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class InventoryWriterTest {
    Database database = new MySqlDatabase("jdbc:mysql://localhost:3306/inventory", "root", "root123");
    InventoryWriter inventoryWriter = new InventoryWriter(database);

    @Test
    void shouldAbleToAddBookToInventory() throws SQLException, ClassNotFoundException {
        int rowsAffected = inventoryWriter.addBook();
        Assertions.assertEquals(1, rowsAffected);
    }

    @Test
    void shouldAbleToUpdateInventory() throws SQLException, ClassNotFoundException, QuantityOverflowException {
        int bookId = 1;
        int quantityToUpdate = 20;
        int rowsAffected = inventoryWriter.updateQuantity(bookId, quantityToUpdate);
        Assertions.assertEquals(1, rowsAffected);
    }
}
