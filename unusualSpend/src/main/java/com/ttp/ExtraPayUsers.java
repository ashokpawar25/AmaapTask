package com.ttp;

public class ExtraPayUsers
{
    int userId;
    String category;
    int moreSpentAmount;

    public ExtraPayUsers(int userId, String category, int moreSpentAmount)
    {
        this.userId = userId;
        this.category = category;
        this.moreSpentAmount = moreSpentAmount;
    }

    public int getUserId() {
        return userId;
    }

    public String getCategory() {
        return category;
    }

    public int getMoreSpentAmount() {
        return moreSpentAmount;
    }
}
