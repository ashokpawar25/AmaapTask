package com.ttp.inventory.reader;

import com.ttp.inventory.database.Database;
import com.ttp.inventory.mysqldatabase.MySqlDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryReaderTest {

    Database database = new MySqlDatabase("jdbc:mysql://localhost:3306/inventory", "root", "root123");
    InventoryReader inventoryReader = new InventoryReader(database);

    @Test
    void shouldAbleToReadBooksFromInventory() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = inventoryReader.getAllBooks();
        Assertions.assertNotNull(resultSet);
    }
}
