package com.meritamerica.MeritBankAppCapstone.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class IRAAccount extends BankAccount {

    private String type;

    @JsonIgnore
    @ManyToOne
    private AccountHolder accountHolder;

    public IRAAccount() {}

    public IRAAccount(double balance, String type) {
        super(balance);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }
}
