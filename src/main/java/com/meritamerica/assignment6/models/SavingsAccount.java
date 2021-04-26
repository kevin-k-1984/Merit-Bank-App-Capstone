package com.meritamerica.assignment6.models;

import javax.persistence.*;

@Entity(name = "SavingsAccounts")
@Table(name = "savingsAccounts")
public class SavingsAccount extends BankAccount {
    
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
}