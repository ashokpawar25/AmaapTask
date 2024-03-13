package com.ttp;

import com.ttp.invalidEmailException.InvalideEmailException;
import com.ttp.invalideCustomerException.InvalideUserException;

import java.util.ArrayList;
import java.util.List;

public class UserHandler
{
    User user = new User();
    static List<User> users = new ArrayList<>();
    public void addUser(int userId, String name, String email) throws InvalideUserException, InvalideEmailException {
        User user = User.create(2, "Raju", "ashokpawar25052001@gmail.com");
//        users.add(User user);
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
