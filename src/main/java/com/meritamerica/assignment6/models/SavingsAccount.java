package com.meritamerica.assignment6.models;

import javax.persistence.*;

@Entity
public class SavingsAccount extends BankAccount {
    
    @ManyToOne
    @JoinColumn(name = "accountHolder_id", nullable = false)
    private AccountHolder accountHolder;
    
    public SavingsAccount() {}

	SavingsAccount(double balance) {
		super(balance);
	}

	SavingsAccount(double balance, double interestRate) {
		super(balance, interestRate);
	}

	SavingsAccount(double balance, double interestRate, java.util.Date openedDate) {
		super(balance, interestRate, openedDate);
	}
	
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
}