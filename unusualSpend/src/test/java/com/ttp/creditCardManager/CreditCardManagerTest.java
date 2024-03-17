package com.ttp.creditCardManager;

import com.ttp.InvalidCardIdException.InvalidCardIdException;
import com.ttp.User;
import com.ttp.creditCard.CreditCard;
import com.ttp.invalidEmailException.InvalideEmailException;
import com.ttp.invalidUserNameException.InvalideUserNameException;
import com.ttp.invalideUserException.InvalideUserIdException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void shouldAbleToDoTransactionForCreditCard() throws InvalidCardIdException, InvalideEmailException, InvalideUserNameException, InvalideUserIdException {
        //Arrange
        CreditCard creditCard = CreditCard.create(1);

        int userID = 1;
        String userName = "Ashok Pawar";
        String userEmail = "ashokpawar25052001@gmail.com";
        User user = User.create(userID, userName, userEmail);

        //Act
        CreditCardManager creditCardManager = new CreditCardManager();
        creditCardManager.mapCardToUser(creditCard, user);

//        creditCardManager.
    }
}
