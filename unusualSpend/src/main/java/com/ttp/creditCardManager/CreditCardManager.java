package com.ttp.creditCardManager;

import com.ttp.Transaction;
import com.ttp.UnusualSpendUsers;
import com.ttp.User;
import com.ttp.creditCard.CreditCard;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreditCardManager {

    List<CreditCard> creditCards = new ArrayList<>();
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

    public List<UnusualSpendUsers> getUnusualSpend()
    {   List<UnusualSpendUsers> unusualSpendUsers = new ArrayList<>();
        List<Transaction> currentMonthTransactions = this.filterTransactionsByMonth(LocalDate.now().getMonth());
        List<Transaction> previousMonthTransactions = this.filterTransactionsByMonth(LocalDate.now().minusMonths(1).getMonth());
        for(Transaction currentTransaction:currentMonthTransactions)
        {
            for(Transaction previousTransaction:previousMonthTransactions)
            {
                if(currentTransaction.getCategory().equals(previousTransaction.getCategory()) && currentTransaction.getCreditCardId() == previousTransaction.getCreditCardId())
                {
                    if (currentTransaction.getAmount() >= (previousTransaction.getAmount()*1.5))
                    {
                        unusualSpendUsers.add(new UnusualSpendUsers(currentTransaction.getCreditCardId(),currentTransaction.getCategory(),currentTransaction.getAmount()-previousTransaction.getAmount()));
                    }
                }
            }
        }

        return  unusualSpendUsers;
    }
}
