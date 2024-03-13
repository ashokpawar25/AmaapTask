package com.ttp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.UserDataHandler;

import java.time.LocalDate;
import java.util.List;

public class TransactionManagerTest {

    TransactionHistory transactionHistory = new TransactionHistory();
    UserHandler userHandler = new UserHandler();
    TransactionManager transactionManager = new TransactionManager(transactionHistory,userHandler);



    @Test
    void shouldBeAbleToGetAllTransaction() {
        List<Transaction> transactions = transactionManager.getTransactions();
        Assertions.assertEquals(0, transactions.size());
    }

    @Test
    void shouldAbleToAddTransaction() {
        transactionManager.addTransaction(new Transaction(1, "Grocery", 100, LocalDate.of(2024, 03, 11), 1));
        List<Transaction> transactions = transactionManager.getTransactions();
        Assertions.assertEquals(1, transactions.size());
    }

    @Test
    void shouldAbleToFilterTransactionByCategory() {
        transactionManager.addTransaction(new Transaction(1, "Grocery", 100, LocalDate.of(2024, 03, 11), 1));
        transactionManager.addTransaction(new Transaction(2, "Travel", 200, LocalDate.of(2024, 03, 11), 2));
        List<Transaction> transactions = transactionManager.filterTransactionByCatgory("Grocery");
        Assertions.assertEquals(1, transactions.size());
    }

    @Test
    void shouldAbleToFilterTransactionsByCurrentMonth() {
        transactionManager.addTransaction(new Transaction(1, "Grocery", 100, LocalDate.of(2024, 02, 11), 1));
        transactionManager.addTransaction(new Transaction(2, "Travel", 200, LocalDate.of(2024, 03, 11), 2));
        List<Transaction> transactions = transactionManager.filterTransactionByCurrentMonth();
        Assertions.assertEquals(1, transactions.size());
    }

    @Test
    void shouldAbleToFilterTransactionByPreviosMonth() {
        transactionManager.addTransaction(new Transaction(1, "Grocery", 100, LocalDate.of(2024, 02, 11), 1));
        transactionManager.addTransaction(new Transaction(2, "Travel", 200, LocalDate.of(2024, 03, 11), 2));
        List<Transaction> transactions = transactionManager.filterTransactionByPreviousMonth();
        Assertions.assertEquals(1, transactions.size());
    }

    @Test
    void shouldAbleToComapareTransactionOfUser()
    {
        transactionManager.addTransaction(new Transaction(1, "Travel", 100, LocalDate.of(2024, 02, 11), 1));
        transactionManager.addTransaction(new Transaction(2, "Travel", 200, LocalDate.of(2024, 03, 11), 1));
        transactionManager.addTransaction(new Transaction(3, "Grocery", 150, LocalDate.of(2024, 02, 11), 1));
        transactionManager.addTransaction(new Transaction(4, "Grocery", 200, LocalDate.of(2024, 03, 11), 1));
        userHandler.addUser(new User(1,"Sameer","ashokpawar25052001@gmail.com"));
        userHandler.addUser(new User(2,"Raju","ashokpawar25052001@gmail.com"));


        List<ExtraPayUsers> extraPayUsers = transactionManager.ComparePreviouMonthSpending();
        Assertions.assertEquals(2,extraPayUsers.size());
    }

    @Test
    void sholudAbleToSendMailToUsers()
    {
        transactionManager.addTransaction(new Transaction(1, "Travel", 100, LocalDate.of(2024, 02, 11), 1));
        transactionManager.addTransaction(new Transaction(2, "Travel", 200, LocalDate.of(2024, 03, 11), 1));
        transactionManager.addTransaction(new Transaction(3, "Grocery", 150, LocalDate.of(2024, 02, 11), 1));
        transactionManager.addTransaction(new Transaction(4, "Grocery", 200, LocalDate.of(2024, 03, 11), 1));
        userHandler.addUser(new User(1,"Sameer","ashokpawar25052001@gmail.com"));
        userHandler.addUser(new User(2,"Raju","ashokpawar.sknscoe.comp@gmail.com"));


        List<ExtraPayUsers> extraPayUsers = transactionManager.ComparePreviouMonthSpending();
        boolean reponse = transactionManager.sendEmail(extraPayUsers);
        Assertions.assertTrue(reponse);
    }

}