package com.ttp;

import java.time.LocalDate;

public class Transaction {

    int transactionID;
    String category;
    int amount;
    LocalDate transactionDate;
    int userId;

    public Transaction()
    {

    }

    public Transaction(int transactionID, String category, int amount, LocalDate transactionDate, int userId) {
        this.transactionID = transactionID;
        this.category = category;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.userId = userId;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
