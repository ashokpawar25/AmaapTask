package com.ttp;

import com.ttp.invalidEmailException.InvalideEmailException;
import com.ttp.invalidUserNameException.InvalideUserNameException;
import com.ttp.invalideUserException.InvalideUserIdException;

import java.util.ArrayList;
import java.util.List;

public class UserHandler
{
    User user = new User();
    public List<User> users = new ArrayList<>();

    public void addUser(User user)
    {
        this.users.add(user);
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
