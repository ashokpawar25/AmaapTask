package com.ttp.inventory.manager;

import com.ttp.inventory.model.Book;
import com.ttp.inventory.model.exception.QuantityOverflowException;
import com.ttp.inventory.reader.InventoryReader;
import com.ttp.inventory.writer.InventoryWriter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    InventoryReader inventoryReader;
    InventoryWriter inventoryWriter;
    public InventoryManager(InventoryReader inventoryReader, InventoryWriter inventoryWriter) {
        this.inventoryReader = inventoryReader;
        this.inventoryWriter = inventoryWriter;
    }

    public List<Book> readInventory() throws SQLException, ClassNotFoundException {
        List<Book> books = new ArrayList<>();
        ResultSet resultSet = inventoryReader.getAllBooks();

        while (resultSet.next())
        {
            books.add(new Book(resultSet.getInt("bookId"),
                    resultSet.getString("bookName"),
                    resultSet.getString("author"),
                    resultSet.getString("publication" ),
                    resultSet.getInt("quantity"),
                    resultSet.getDouble("price"),
                    resultSet.getString("category")));
        }
        System.out.println(books.size());
        return books;
    }

    public int addBook() throws SQLException, ClassNotFoundException {
        int rowsAffected = inventoryWriter.addBook();
        return rowsAffected;
    }

    public int updateInventory(int bookId, int quantityToUpdate) throws SQLException, ClassNotFoundException, QuantityOverflowException {
        int rowsAffected = inventoryWriter.updateQuantity(bookId,quantityToUpdate);
        return rowsAffected;
    }
}
