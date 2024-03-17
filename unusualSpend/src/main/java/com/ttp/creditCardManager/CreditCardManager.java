package com.ttp.creditCardManager;

import com.ttp.Transaction;
import com.ttp.User;
import com.ttp.creditCard.CreditCard;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Transaction> filterTransactionsByMonth(Month month)
    {
        return transactions.stream().filter(x-> x.getTransactionDate().getMonth().equals(month)).collect(Collectors.toList());
    }
}
