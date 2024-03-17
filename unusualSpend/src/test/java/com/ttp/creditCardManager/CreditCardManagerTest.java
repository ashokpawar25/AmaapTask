package com.ttp.creditCardManager;

import com.ttp.Category.Category;
import com.ttp.InvalidCardIdException.InvalidCardIdException;
import com.ttp.Transaction;
import com.ttp.User;
import com.ttp.creditCard.CreditCard;
import com.ttp.invalidAmountException.InvalidAmountException;
import com.ttp.invalidEmailException.InvalideEmailException;
import com.ttp.invalidUserNameException.InvalideUserNameException;
import com.ttp.invalideCategoryException.InvalideCategoryException;
import com.ttp.invalideTransactionIdException.InvalideTransactionIdException;
import com.ttp.invalideUserException.InvalideUserIdException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreditCardManagerTest {
    @Test
    void shouldAbleToMapUserToCreditCard() throws InvalidCardIdException, InvalideEmailException, InvalideUserNameException, InvalideUserIdException {
        //Arrange
        CreditCard creditCard = CreditCard.create(1);

        int userID = 1;
        String userName = "Ashok Pawar";
        String userEmail = "ashokpawar25052001@gmail.com";
        User user = User.create(userID, userName, userEmail);

        //Act
        CreditCardManager creditCardManager = new CreditCardManager();
        boolean isMapped = creditCardManager.mapCardToUser(creditCard, user);

        //Assert
        Assertions.assertTrue(isMapped);
    }

    @Test
    void shouldAbleToAddTransactionForCreditCard() throws InvalidCardIdException, InvalideEmailException, InvalideUserNameException, InvalideUserIdException, InvalideTransactionIdException, InvalideCategoryException, InvalidAmountException {
        //Arrange
        CreditCard creditCard = CreditCard.create(1);

        int userID = 1;
        String userName = "Ashok Pawar";
        String userEmail = "ashokpawar25052001@gmail.com";
        User user = User.create(userID, userName, userEmail);

        //Act
        CreditCardManager creditCardManager = new CreditCardManager();
        creditCardManager.mapCardToUser(creditCard, user);

        Transaction transaction = Transaction.create(101, Category.travel, 100, LocalDate.of(2024, 03, 17), 1);
        List<Transaction> expectedTransactionList = List.of(transaction);
        creditCardManager.addTransaction(expectedTransactionList);

        List<Transaction> transactions = creditCardManager.getTransactions();

        //Assert
        Assertions.assertEquals(transaction, transactions.get(0));
    }

    @Test
    void shouldAbleToAddMultipleTransactionsForCreditCard() throws InvalideTransactionIdException, InvalideCategoryException, InvalidAmountException, InvalideEmailException, InvalideUserNameException, InvalideUserIdException, InvalidCardIdException {
        //Arrange
        CreditCard creditCard = CreditCard.create(1);

        int userID = 1;
        String userName = "Ashok Pawar";
        String userEmail = "ashokpawar25052001@gmail.com";
        User user = User.create(userID, userName, userEmail);

        //Act
        CreditCardManager creditCardManager = new CreditCardManager();
        creditCardManager.mapCardToUser(creditCard, user);

        Transaction transaction1 = Transaction.create(101, Category.travel, 100, LocalDate.of(2024, 03, 17), 1);
        Transaction transaction2 = Transaction.create(102, Category.travel, 100, LocalDate.of(2024, 03, 17), 1);
        List<Transaction> expectedTransactionList = List.of(transaction1, transaction2);

        creditCardManager.addTransaction(expectedTransactionList);

        List<Transaction> transactions = creditCardManager.getTransactions();

        //Assert
        Assertions.assertEquals(2, transactions.size());
    }

    @Test
    void shouldAbleToFilterTransactionsByMonth() throws InvalidCardIdException, InvalideEmailException, InvalideUserNameException, InvalideUserIdException, InvalideTransactionIdException, InvalideCategoryException, InvalidAmountException {
        //Arrange
        CreditCard creditCard = CreditCard.create(1);

        int userID = 1;
        String userName = "Ashok Pawar";
        String userEmail = "ashokpawar25052001@gmail.com";
        User user = User.create(userID, userName, userEmail);

        //Act
        CreditCardManager creditCardManager = new CreditCardManager();
        creditCardManager.mapCardToUser(creditCard, user);

        Transaction transaction1 = Transaction.create(101, Category.travel, 100, LocalDate.of(2024, 02, 17), 1);
        Transaction transaction2 = Transaction.create(102, Category.travel, 100, LocalDate.of(2024, 03, 17), 1);
        List<Transaction> expectedTransactionList = List.of(transaction1, transaction2);

        creditCardManager.addTransaction(expectedTransactionList);

        List<Transaction> currentMonthTransactions = creditCardManager.filterTransactionsByMonth(LocalDate.now().getMonth());

        //Assert
        Assertions.assertEquals(transaction2, currentMonthTransactions.get(0));
    }

    @Test
    void shouldAbleFindTheUnusualSpendForCustomers() throws InvalidCardIdException, InvalideEmailException, InvalideUserNameException, InvalideUserIdException, InvalideTransactionIdException, InvalideCategoryException, InvalidAmountException {
        //Arrange
        CreditCard creditCard = CreditCard.create(1);

        int userID = 1;
        String userName = "Ashok Pawar";
        String userEmail = "ashokpawar25052001@gmail.com";
        User user = User.create(userID, userName, userEmail);

        //Act
        CreditCardManager creditCardManager = new CreditCardManager();
        creditCardManager.mapCardToUser(creditCard, user);

        Transaction transaction1 = Transaction.create(101, Category.travel, 100, LocalDate.of(2024, 02, 17), 1);
        Transaction transaction2 = Transaction.create(102, Category.travel, 100, LocalDate.of(2024, 03, 17), 1);
        List<Transaction> transactions = List.of(transaction1, transaction2);

        creditCardManager.addTransaction(transactions);
        
    }
}
