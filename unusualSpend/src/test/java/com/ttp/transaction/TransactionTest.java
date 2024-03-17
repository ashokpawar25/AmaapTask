package com.ttp.transaction;

import com.ttp.Category.Category;
import com.ttp.Transaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TransactionTest
{
    @Test
    void shouldAbleToCreateTransaction()
    {
        //Arrange
        int transactionID=1;
        Category.groceries;
        int amount = 100;
        LocalDate transactionDate = LocalDate.of(2024,03,17);
        int creditCardId = 1;
        Transaction transaction = Transaction.create();
    }
}
