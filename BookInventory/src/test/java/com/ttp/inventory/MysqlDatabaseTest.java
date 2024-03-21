package com.ttp.inventory;

import com.ttp.inventory.mysqldatabase.MySqlDatabase;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlDatabaseTest {

    MySqlDatabase database = new MySqlDatabase("jdbc:mysql://localhost:3306/inventory", "root", "root123");

    @Test
    void readData() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = database.readInventory();
        resultSet.next();
        System.out.println(resultSet.getString(2));
    }
}
