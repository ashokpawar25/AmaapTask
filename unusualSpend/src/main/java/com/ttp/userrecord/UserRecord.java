package com.ttp.userrecord;

import com.ttp.AmountAndCategory;

import java.util.List;

public class UserRecord
{
//    private int creditCardID;
    private List<AmountAndCategory> usualSpendList;
    private List<AmountAndCategory> unUsualSpendList;

    public UserRecord( List<AmountAndCategory> usualSpendList, List<AmountAndCategory> unUsualSpendList) {
//        this.creditCardID = creditCardID;
        this.usualSpendList = usualSpendList;
        this.unUsualSpendList = unUsualSpendList;
    }

//    public int getCreditCardID() {
//        return creditCardID;
//    }
//
//    public void setCreditCardID(int creditCardID) {
//        this.creditCardID = creditCardID;
//    }

    public List<AmountAndCategory> getUsualSpendList() {
        return usualSpendList;
    }

    public void setUsualSpendList(List<AmountAndCategory> usualSpendList) {
        this.usualSpendList = usualSpendList;
    }

    public List<AmountAndCategory> getUnUsualSpendList() {
        return unUsualSpendList;
    }

    public void setUnUsualSpendList(List<AmountAndCategory> unUsualSpendList) {
        this.unUsualSpendList = unUsualSpendList;
    }
}
