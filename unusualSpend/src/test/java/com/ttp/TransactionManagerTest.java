package com.ttp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.UserDataHandler;

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
    void shouldAbleToFilterTransactionsByCurrentMonth() {
        transactionHistory.addTransaction(new Transaction(1, "Grocery", 100, LocalDate.of(2024, 02, 11), 1));
        transactionHistory.addTransaction(new Transaction(2, "Travel", 200, LocalDate.of(2024, 03, 11), 2));
        List<Transaction> transactions = transactionHistory.filterTransactionByCurrentMonth();
        Assertions.assertEquals(1, transactions.size());
    }

    @Test
    void shouldAbleToFilterTransactionByPreviosMonth() {
        transactionHistory.addTransaction(new Transaction(1, "Grocery", 100, LocalDate.of(2024, 02, 11), 1));
        transactionHistory.addTransaction(new Transaction(2, "Travel", 200, LocalDate.of(2024, 03, 11), 2));
        List<Transaction> transactions = transactionHistory.filterTransactionByPreviousMonth();
        Assertions.assertEquals(1, transactions.size());
    }

    @Test
    void shouldAbleToComapareTransactionOfUser()
    {
        transactionHistory.addTransaction(new Transaction(1, "Travel", 100, LocalDate.of(2024, 02, 11), 1));
        transactionHistory.addTransaction(new Transaction(2, "Travel", 200, LocalDate.of(2024, 03, 11), 1));
        transactionHistory.addTransaction(new Transaction(3, "Grocery", 150, LocalDate.of(2024, 02, 11), 1));
        transactionHistory.addTransaction(new Transaction(4, "Grocery", 200, LocalDate.of(2024, 03, 11), 1));
        UserHandler userHandler = new UserHandler();
        userHandler.addUser(new User(1,"Sameer","ashokpawar25052001@gmail.com"));
        userHandler.addUser(new User(2,"Raju","ashokpawar25052001@gmail.com"));


        List<ExtraPayUsers> extraPayUsers = transactionHistory.ComparePreviouMonthSpending();
        Assertions.assertEquals(2,extraPayUsers.size());
    }
}