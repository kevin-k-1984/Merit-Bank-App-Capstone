package com.meritamerica.MeritBankAppCapstone.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CheckingAccount extends BankAccount {

	@JsonIgnore
	@ManyToOne
    private AccountHolder accountHolder;

	private boolean isDBA;
	
	public CheckingAccount() {}

	public CheckingAccount(double balance) {
		super(balance);
	}

	public CheckingAccount(double balance, boolean isDBA) {
		super(balance);
		this.isDBA = isDBA;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

	public boolean isDBA() {
		return isDBA;
	}

	public void setDBA(boolean DBA) {
		isDBA = DBA;
	}
}