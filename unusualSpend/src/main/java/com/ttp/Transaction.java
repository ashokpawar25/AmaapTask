package com.ttp;

import jdk.jfr.Category;

import java.time.LocalDate;

public class Transaction {

    int transactionID;
    Category category;
    int amount;
    LocalDate transactionDate;
    int creditCardId;

    public Transaction()
    {

    }

    public Transaction(int transactionID, Category category, int amount, LocalDate transactionDate, int creditCardId) {
        this.transactionID = transactionID;
        this.category = category;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.creditCardId = creditCardId;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
        return creditCardId;
    }

    public void setUserId(int userId) {
        this.creditCardId = userId;
    }
}
