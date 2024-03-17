package com.ttp.creditCardManager;

import com.ttp.*;
import com.ttp.Category.Category;
import com.ttp.creditCard.CreditCard;

import javax.security.auth.login.CredentialException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Map<Integer, List<UnusualAmountAndCategory>> mapUnusualSpendForUser(List<UnusualSpendUsers> unusualSpendUsers)
    {
        Map<Integer ,List<UnusualAmountAndCategory>> mappingUnusualSpend = new HashMap<>();

        for(UnusualSpendUsers unusualSpendUser:unusualSpendUsers)
        {
            int creditCardId = unusualSpendUser.getCreditCardId();
            Category category = unusualSpendUser.getCategory();
            int amount = unusualSpendUser.getAmountOfUnusaulSpend();

            if(mappingUnusualSpend.containsKey(creditCardId))
            {
                List<UnusualAmountAndCategory> unusualAmountAndCategoriesList = mappingUnusualSpend.get(creditCardId);
                unusualAmountAndCategoriesList.add(new UnusualAmountAndCategory(amount,category));
                mappingUnusualSpend.put(creditCardId,unusualAmountAndCategoriesList);
            }
            else
            {
                List<UnusualAmountAndCategory> unusualAmountAndCategoriesList = new ArrayList<>();
                unusualAmountAndCategoriesList.add(new UnusualAmountAndCategory(amount,category));
                mappingUnusualSpend.put(creditCardId,unusualAmountAndCategoriesList);
            }
        }
        return mappingUnusualSpend;
    }

    public boolean sendEmail(Map<Integer, List<UnusualAmountAndCategory>> aggragatedUnusualSpend)
    {
        EmailHandler emailHandler = new EmailHandler();
        for(Map.Entry<Integer, List<UnusualAmountAndCategory>> entry : aggragatedUnusualSpend.entrySet())
        {
            CreditCard creditCard = null;
            int creditCardId = entry.getKey();
            for(CreditCard creditCard1:creditCards)
            {
                if(creditCard1.getCardId() == creditCardId)
                {
                    creditCard = creditCard1;
                }
            }
            String email = creditCard.getUser().getEmail();
            String name = creditCard.getUser().getName();
            int totalSpent = 0;
            List<UnusualAmountAndCategory> list = entry.getValue();
            String subject = "Regarding unusual spend for current month";
            StringBuilder body = new StringBuilder(" \n hello "+ name +"!\n We have detected unusually high spending on your card in these categories:\n ");
            for(UnusualAmountAndCategory amountAndCategory:entry.getValue())
            {
                body.append(" * You spent ₹"+ amountAndCategory.getAmount() +" on "+ amountAndCategory.getCategory()+"\n");
                totalSpent += amountAndCategory.getAmount();
            }
            body.append("Thanks,\n" +
                    "\n" +
                    "The Credit Card Company\n");
            body.insert(0,"Unusual spending of "+ totalSpent +"detected!");
            emailHandler.sendEmail(subject,body.toString(),email);
        }
        return true;
    }
}
