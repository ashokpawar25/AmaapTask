package com.ttp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TransactionManagerTest {

    TransactionManager transactionManager = new TransactionManager();
    TransactionHistory transactionHistory = new TransactionHistory();


    @Test
    void shouldBeAbleToGetAllTransaction() {
        List<Transaction> transactions = transactionHistory.getAllTransactions();
        Assertions.assertEquals(0, transactions.size());
    }

    @Test
    void shouldAbleToAddTransaction() {
        transactionHistory.addTransaction(new Transaction(1, "Grocery", 100, LocalDate.of(2024, 03, 11), 1));
        List<Transaction> transactions = transactionHistory.getAllTransactions();
        Assertions.assertEquals(1, transactions.size());
    }

    @Test
    void shouldAbleToFilterTransactionByCategory() {
        transactionHistory.addTransaction(new Transaction(1, "Grocery", 100, LocalDate.of(2024, 03, 11), 1));
        transactionHistory.addTransaction(new Transaction(2, "Travel", 200, LocalDate.of(2024, 03, 11), 2));
        List<Transaction> transactions = transactionHistory.filterTransactionByCatgory("Grocery");
        Assertions.assertEquals(1, transactions.size());
    }

    @Test
    void shouldAbleTofilterTransactionsByCurrentMonth() {
        transactionHistory.addTransaction(new Transaction(1, "Grocery", 100, LocalDate.of(2024, 02, 11), 1));
        transactionHistory.addTransaction(new Transaction(2, "Travel", 200, LocalDate.of(2024, 03, 11), 2));
        List<Transaction> transactions = transactionHistory.filterTransactionByCurrentMonth();
        Assertions.assertEquals(1, transactions.size());
    }
}