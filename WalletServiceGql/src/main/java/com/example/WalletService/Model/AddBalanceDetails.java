package com.example.WalletService.Model;

import lombok.Builder;

@Builder
public class AddBalanceDetails {
    private int uid;
    private int amount;

    public AddBalanceDetails(int uid, int amount) {
        this.uid = uid;
        this.amount = amount;
    }

    public AddBalanceDetails() {

    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String toString()
    {
        return  uid + "\n" + amount  ;
    }

}