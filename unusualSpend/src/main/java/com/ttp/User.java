package com.ttp;

import com.ttp.emailValidator.EmailValidator;
import com.ttp.invalidEmailException.InvalideEmailException;
import com.ttp.invalideCustomerException.InvalideUserException;

import java.util.regex.Pattern;

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

    public static User create(int userId, String name, String email) throws InvalideUserException, InvalideEmailException {
        if (userId < 0 || userId == 0) throw new InvalideUserException("User Id sholud be positve");
        if(!EmailValidator.validateEmail(email)) throw new InvalideEmailException(email);
        return new User(userId, name, email);
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
