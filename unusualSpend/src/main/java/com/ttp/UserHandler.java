package com.ttp;

import com.ttp.invalidEmailException.InvalideEmailException;
import com.ttp.invalidUserNameException.InvalideUserNameException;
import com.ttp.invalideUserException.InvalideUserIdException;

import java.util.ArrayList;
import java.util.List;

public class UserHandler
{
    User user = new User();
    public static List<User> users = new ArrayList<>();
    public static void addUser(int userId, String name, String email) throws InvalideUserIdException, InvalideEmailException, InvalideUserNameException {
        User user = User.create(userId, name, email);
        users.add(user);
    }

    public User getUserByUserId(int userId1)
    {
//        User user = new User(1,"sameer","ashokpawar25052001@gmail.com");
//        return user;
        for(User user1:users)
        {
            if (user1.userId==userId1)
            {
                return user1;
            }
        }
        return null;
    }
}
