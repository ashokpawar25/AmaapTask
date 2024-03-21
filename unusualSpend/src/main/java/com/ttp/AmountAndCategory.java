package com.ttp;

import com.ttp.Category.Category;

public class AmountAndCategory
{
    private Category category;
    private int amount;

    public AmountAndCategory(Category category, int amount) {
        this.category = category;
        this.amount = amount;
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
}
