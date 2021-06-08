package com.meritamerica.MeritBankAppCapstone.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CheckingAccount extends BankAccount {


//	@JoinColumn
	@JsonIgnore
	@ManyToOne
    private AccountHolder accountHolder;
	
	public CheckingAccount() {}

	public CheckingAccount(double balance) {
		super(balance);
	}

	public CheckingAccount(double balance, double interestRate) {
		super(balance, interestRate);
	}

	public CheckingAccount(double balance, double interestRate, java.util.Date openedDate) {
		super(balance, interestRate, openedDate);
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
}