package com.ttp.creditCardManager;

import com.ttp.Transaction;
import com.ttp.User;
import com.ttp.creditCard.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class CreditCardManager {

    List<Transaction> transactions = new ArrayList<>();
    public boolean mapCardToUser(CreditCard creditCard, User user)
    {
        creditCard.setUser(user);
        return true;
    }

    public void addTransaction(List<Transaction> transactions)
    {
        for(Transaction transaction:transactions)
        {
            this.transactions.add(transaction);
        }

    }

    public List<Transaction> getTransactions()
    {
        return this.transactions;
    }
}
