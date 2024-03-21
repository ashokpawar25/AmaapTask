package com.ttp.inventory.database;

import com.ttp.inventory.mysqldatabase.MySqlDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseTest {
    Database database = new MySqlDatabase("jdbc:mysql://localhost:3306/inventory", "root", "root123");
    Connection connection;

    @Test
    void shouldAbleTOConnectDatabase() throws SQLException, ClassNotFoundException {
        connection = database.getConnection();
        Assertions.assertNotNull(connection);
    }

}
