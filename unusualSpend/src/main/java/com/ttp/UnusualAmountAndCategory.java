package com.ttp;

import com.ttp.Category.Category;

public class UnusualAmountAndCategory
{
    int amount;
    Category category;

    public UnusualAmountAndCategory(int amount, Category category)
    {
        this.amount=amount;
        this.category=category;
    }

    public int getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }
}
