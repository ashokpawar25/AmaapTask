package com.ttp;

import java.util.ArrayList;
import java.util.List;

public class UserHandler
{
    static List<User> users = new ArrayList<>();
    public void addUser(User user)
    {
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
