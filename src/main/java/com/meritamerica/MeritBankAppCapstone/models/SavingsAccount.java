package com.meritamerica.MeritBankAppCapstone.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SavingsAccount extends BankAccount {
    
	@JsonIgnore
	@ManyToOne
    private AccountHolder accountHolder;
	
    public SavingsAccount() {}

	public SavingsAccount(double balance) {
		super(balance);
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
}