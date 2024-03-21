package com.ttp.inventory.manager;

import com.mysql.cj.x.protobuf.MysqlxExpect;
import com.ttp.inventory.database.Database;
import com.ttp.inventory.model.Book;
import com.ttp.inventory.model.exception.QuantityOverflowException;
import com.ttp.inventory.mysqldatabase.MySqlDatabase;
import com.ttp.inventory.reader.InventoryReader;
import com.ttp.inventory.writer.InventoryWriter;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InventoryManagerTest {


    Database database = new MySqlDatabase("jdbc:mysql://localhost:3306/inventory", "root", "root123");


    @Mock
    InventoryReader inventoryReader;
    InventoryWriter inventoryWriter = new InventoryWriter(database);
    @InjectMocks
    private InventoryManager inventoryManager;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void shouldAbleToReadDataFromReader() throws SQLException, ClassNotFoundException {
//        List<Book> bookList = List.of(new Book(1,"java","Jems Ghosling","Anand Publication",20 ,300,"programming"));
        ResultSet resultSet = mock(ResultSet.class);
        when(inventoryReader.getAllBooks()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("bookId")).thenReturn(1);
        when(resultSet.getString("bookName")).thenReturn("java");
        when(resultSet.getString("author")).thenReturn("java");
        when(resultSet.getString("publication" )).thenReturn("java");
        when(resultSet.getInt("quantity")).thenReturn(12);
        when(resultSet.getDouble("price")).thenReturn(353);
        when(resultSet.getString("category")).thenReturn("234");

//        resultSet.getInt("bookId"),
//                resultSet.getString("bookName"),
//                resultSet.getString("author"),
//                resultSet.getString("publication" ),
//                resultSet.getInt("quantity"),
//                resultSet.getDouble("price"),
//                resultSet.getString("category")));
        List<Book> books = inventoryManager.readInventory();
        Assertions.assertNotEquals(0, books.size());
    }

    @Test
    void shouldAbleToAddBookIntoInventory() throws SQLException, ClassNotFoundException {
        int rowsAffected = inventoryManager.addBook();
        Assertions.assertEquals(1, rowsAffected);
    }

    @Test
    void shouldAbleToUpdateInventory() throws SQLException, ClassNotFoundException, QuantityOverflowException {
        int bookId = 1;
        int quantityToUpdate = 0;
        int rowsAffected = inventoryManager.updateInventory(bookId, quantityToUpdate);
        Assertions.assertEquals(1, rowsAffected);
    }

    @Test
    void shouldAbleToThrowExceptionWhenNewQuantityGreaterThan100() throws SQLException, QuantityOverflowException, ClassNotFoundException {
        int bookId = 1;
        int quantityToUpdate = 20;
        Assertions.assertThrows(QuantityOverflowException.class, () -> inventoryManager.updateInventory(bookId, quantityToUpdate));
    }
}
