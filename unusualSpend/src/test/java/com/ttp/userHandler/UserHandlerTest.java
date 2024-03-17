package com.ttp.userHandler;

import com.ttp.UserHandler;
import com.ttp.invalidEmailException.InvalideEmailException;
import com.ttp.invalidUserNameException.InvalideUserNameException;
import com.ttp.invalideUserException.InvalideUserIdException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserHandlerTest
{
    @Test
    void shouldAbleToAddNewUser() throws InvalideEmailException, InvalideUserNameException, InvalideUserIdException {
        UserHandler.addUser(1,"Sample User","sampleemail@gmail.com");
        Assertions.assertEquals(1,UserHandler.users.size());
    }
}
