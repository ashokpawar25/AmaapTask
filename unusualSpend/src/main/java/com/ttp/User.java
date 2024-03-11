package com.ttp;

public class User {
    int userId;
    String name;
    String email;
    public User(int userId, String name, String email)
    {
        this.userId=userId;
        this.email=email;
        this.name=name;
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
