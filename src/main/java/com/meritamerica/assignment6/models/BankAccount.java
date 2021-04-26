package com.meritamerica.assignment6.models;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

@MappedSuperclass
public abstract class BankAccount {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;

    protected Date openedDate;
	protected double interestRate;
	
	@Min(value = 0)
    protected double balance;

	public BankAccount() {
		this(0);
	}

    BankAccount(double balance) {
    	this(balance, 0.01, new Date());
    }

	BankAccount(double balance, double interestRate) {
		this(balance, interestRate, new Date());
	}

	BankAccount(double balance, double interestRate, Date accountOpenedOn) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.openedDate = accountOpenedOn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Date getOpenedDate() {
		return this.openedDate;
	}

	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
