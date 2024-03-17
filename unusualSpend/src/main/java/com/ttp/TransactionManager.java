//package com.ttp;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class TransactionManager
//{
//    TransactionHistory transactionHistory ;
//    UserHandler userHandler ;
//    EmailHandler emailHandler = new EmailHandler();
//
//    public TransactionManager(TransactionHistory transactionHistory, UserHandler userHandler)
//    {
//        this.transactionHistory = transactionHistory;
//        this.userHandler = userHandler;
//    }
//
//    public List<Transaction> getTransactions()
//    {
//        List<Transaction> transactions = transactionHistory.getTransactions();
//        return transactions;
//    }
//
//    public void addTransaction(Transaction transaction)
//    {
//        List<Transaction> transactions = transactionHistory.getTransactions();
//        transactions.add(transaction);
//    }
//
//    public List<Transaction> filterTransactionByCatgory(String catogory)
//    {
//        List<Transaction> transactions = transactionHistory.getTransactions();
//        return transactions.stream().filter((x) -> x.getCategory().equalsIgnoreCase(catogory)).collect(Collectors.toList());
////        List<Transaction> transactions1 = new ArrayList<>();
////        for(int i=0 ; i< transactions.size();i++)
////        {
////            if(transactions.get(i).getCategory()==catogory)
////                transactions.add(transactions.get(i));
////        }
////        return transactions;
//    }
//
//    public List<Transaction> filterTransactionByCurrentMonth()
//    {
//        List<Transaction> transactions = transactionHistory.getTransactions();
//        return transactions.stream().filter((x) -> x.getTransactionDate().getMonth() == LocalDate.now().getMonth()).collect(Collectors.toList());
//    }
//
//    public List<Transaction> filterTransactionByPreviousMonth()
//    {
//        List<Transaction> transactions = transactionHistory.getTransactions();
//        return transactions.stream().filter((x) -> x.getTransactionDate().getMonth() == LocalDate.now().minusMonths(1).getMonth()).collect(Collectors.toList());
//    }
//
//    public List<ExtraPayUsers> ComparePreviouMonthSpending()
//    {
//        List<Transaction> currentMonthTransactions = filterTransactionByCurrentMonth();
//        List<Transaction> lastMonthTransactions = filterTransactionByPreviousMonth();
//        List<ExtraPayUsers> extraPayUsers = new ArrayList<>();
//        for(Transaction transaction:currentMonthTransactions)
//        {
//            for(Transaction lmTransaction:lastMonthTransactions)
//            {
//                if(transaction.getUserId()==lmTransaction.getUserId() && transaction.getCategory() == lmTransaction.getCategory())
//                {
//                    if(transaction.getAmount()>lmTransaction.getAmount())
//                    {
//                        extraPayUsers.add(new ExtraPayUsers(transaction.getUserId(),transaction.getCategory(),transaction.getAmount()-lmTransaction.getAmount()));
//                    }
//                }
//            }
//        }
//        return extraPayUsers;
//    }
//
//    public boolean sendEmail(List<ExtraPayUsers> extraPayUsers)
//    {
//        for(ExtraPayUsers extraPayUser:extraPayUsers)
//        {
//            User existingUser = userHandler.getUserByUserId(extraPayUser.userId);
//
//            if(existingUser!=null)
//            {
//
//                String body = "Dear "+ existingUser.name + "," +
//                        "You have spent Rupees "+ extraPayUser.moreSpentAmount +" on "+ extraPayUser.category+"" +
//                        "" +
//                        "Thank you credit card company";
//
//                String response = emailHandler.sendEmail("Regarding extra spent", body, existingUser.email);
//                System.out.println(response);
//            }
//            else {
//                return false;
//            }
//        }
//        return true;
//    }
//}
