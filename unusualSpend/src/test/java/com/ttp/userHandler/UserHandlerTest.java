package com.ttp.userHandler;

import com.ttp.User;
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
        UserHandler userHandler = new UserHandler();
        User user = User.create(1, "Sample User", "sampleemail@gmail.com");
        userHandler.addUser(user);
        Assertions.assertEquals(1,userHandler.users.size());
    }
}
