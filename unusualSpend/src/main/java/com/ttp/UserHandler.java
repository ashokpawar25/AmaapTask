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


}
