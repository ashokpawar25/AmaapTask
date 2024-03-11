package com.ttp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionHistory {
    List<Transaction> transactions = new ArrayList<>();

    UserHandler userHandler = new UserHandler();
    EmailHandler emailHandler = new EmailHandler();

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

    public List<Transaction> filterTransactionByPreviousMonth()
    {
        return transactions.stream().filter((x) -> x.getTransactionDate().getMonth() == LocalDate.now().minusMonths(1).getMonth()).collect(Collectors.toList());

    }

    public List<ExtraPayUsers> ComparePreviouMonthSpending()
    {
        List<Transaction> currentMonthTransactions = filterTransactionByCurrentMonth();
        List<Transaction> lastMonthTransactions = filterTransactionByPreviousMonth();
        List<ExtraPayUsers> extraPayUsers = new ArrayList<>();
        for(Transaction transaction:currentMonthTransactions)
        {
            for(Transaction lmTransaction:lastMonthTransactions)
            {
                if(transaction.getUserId()==lmTransaction.getUserId() && transaction.getCategory() == lmTransaction.getCategory())
                {
                    if(transaction.getAmount()>lmTransaction.getAmount())
                    {
                        extraPayUsers.add(new ExtraPayUsers(transaction.getUserId(),transaction.getCategory(),transaction.getAmount()-lmTransaction.getAmount()));
                    }
                }
            }
        }

        for(ExtraPayUsers extraPayUsers1:extraPayUsers)
        {
            User existingUser = userHandler.getUserByUserId(extraPayUsers1.userId);


            if(existingUser!=null)
            {

                String body = "Dear "+ existingUser.name + "," +
                        "You have spent Rupees "+ extraPayUsers1.moreSpentAmount +" on "+ extraPayUsers1.category+"" +
                        "Thank you credit card company";

                String response = emailHandler.sendEmail("Regarding extra spent", body, existingUser.email);
                System.out.println(response);
            }
        }
        return extraPayUsers;
    }
}
