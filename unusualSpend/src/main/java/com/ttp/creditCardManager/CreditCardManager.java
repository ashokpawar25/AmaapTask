package com.ttp.creditCardManager;

import com.ttp.User;
import com.ttp.creditCard.CreditCard;

public class CreditCardManager {
    public boolean mapCardToUser(CreditCard creditCard, User user)
    {
        creditCard.setUser(user);
        return true;
    }
}
