package com.ttp;

import com.ttp.emailValidator.EmailValidator;
import com.ttp.invalidEmailException.InvalideEmailException;
import com.ttp.invalidUserNameException.InvalideUserNameException;
import com.ttp.invalideUserException.InvalideUserIdException;
import com.ttp.userNameValidator.UserNameValidator;

public class User {
    int userId;
    String name;
    String email;

    public User() {

    }

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.email = email;
        this.name = name;
    }

    public static User create(int userId, String name, String email) throws InvalideUserIdException, InvalideEmailException, InvalideUserNameException {
        if (!isValidUserId(userId)) throw new InvalideUserIdException("User Id sholud be positve");
        if(!EmailValidator.validateEmail(email)) throw new InvalideEmailException(email);
        if(!UserNameValidator.validateUserName(name)) throw new InvalideUserNameException(name);
        return new User(userId, name, email);
    }

    private static boolean isValidUserId(int userId)
    {
        return userId>0;
    }



    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
