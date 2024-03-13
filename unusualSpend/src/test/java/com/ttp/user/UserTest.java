package com.ttp.user;

import com.ttp.emailValidator.EmailValidator;
import com.ttp.invalidEmailException.InvalideEmailException;
import com.ttp.User;
import com.ttp.invalideCustomerException.InvalideUserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    User user = new User();

    @Test
    void shouldThrowExceptionWhenUserIdIsInvalid() throws InvalideUserException {
        Assertions.assertThrows(Exception.class, () -> User.create(-1, "Ashok", "ashokpawar8020@gmail.com"));
        Assertions.assertThrows(Exception.class, () -> User.create(0, "Ashok", "ashokpawar8020@gmail.com"));
    }

    @Test
    void shouldthrowExeceptionWhenUserEmailIsInvalid() throws InvalideUserException {
        Assertions.assertThrows(InvalideEmailException.class, () -> User.create(3, "Ashok Pawar", null));
        Assertions.assertThrows(InvalideEmailException.class, () -> User.create(4, "Ashok Pawar", ""));
        Assertions.assertDoesNotThrow(()-> User.create(2,"Ashok Pawar","ashokpawar8020@gmail.com"));

//        Assertions.assertDoesNotThrow();
    }
}
