package com.meritamerica.assignment7.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "SavingsAccounts")
@Table(name = "savingsAccounts")
public class SavingsAccount extends BankAccount {
    
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "account_holders_id")
    protected AccountHolder accountHolder;
	
    public SavingsAccount() {}

	public SavingsAccount(double balance) {
		super(balance);
	}

	public SavingsAccount(double balance, double interestRate) {
		super(balance, interestRate);
	}

	public SavingsAccount(double balance, double interestRate, java.util.Date openedDate) {
		super(balance, interestRate, openedDate);
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
}