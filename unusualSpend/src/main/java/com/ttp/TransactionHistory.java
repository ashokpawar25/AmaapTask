package com.ttp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionHistory {
    List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction)
    {
        transactions.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    public List<Transaction> filterTransactionByCatgory(String catogory)
    {
        return transactions.stream().filter((x) -> x.getCategory().equalsIgnoreCase(catogory)).collect(Collectors.toList());
//        List<Transaction> transactions1 = new ArrayList<>();
//        for(int i=0 ; i< transactions.size();i++)
//        {
//            if(transactions.get(i).getCategory()==catogory)
//                transactions.add(transactions.get(i));
//        }
//        return transactions1;
    }

    public List<Transaction> filterTransactionByCurrentMonth()
    {
        return transactions.stream().filter((x) -> x.getTransactionDate().getMonth() == LocalDate.now().getMonth()).collect(Collectors.toList());
    }
}
