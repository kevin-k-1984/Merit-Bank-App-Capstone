package com.meritamerica.MeritBankAppCapstone.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CheckingAccount extends BankAccount {

	@JsonIgnore
	@ManyToOne
    private AccountHolder accountHolder;
	
	public CheckingAccount() {}

	public CheckingAccount(double balance) {
		super(balance);
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
}