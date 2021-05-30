package com.meritamerica.MeritBankAppCapstone.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class IRAAccount extends BankAccount {

    private String type;

    @ManyToOne
    private AccountHolder accountHolder;
}
