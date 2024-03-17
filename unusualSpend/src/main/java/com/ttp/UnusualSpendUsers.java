package com.ttp;

import com.ttp.Category.Category;

public class UnusualSpendUsers
{
    int creditCardId;
    Category category;
    int amountOfUnusaulSpend;

    public UnusualSpendUsers(int creditCardId, Category category, int amountOfUnusaulSpend)
    {
        this.creditCardId = creditCardId;
        this.category = category;
        this.amountOfUnusaulSpend = amountOfUnusaulSpend;
    }

    public int getCreditCardId() {
        return creditCardId;
    }

    public Category getCategory() {
        return category;
    }

    public int getAmountOfUnusaulSpend() {
        return amountOfUnusaulSpend;
    }
}
