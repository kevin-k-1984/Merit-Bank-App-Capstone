package com.meritamerica.assignment6.models;

import javax.persistence.*;

@Entity(name = "CheckingAccounts")
@Table(name = "checkingAccounts")
public class CheckingAccount extends BankAccount {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountHolders_id")
    private AccountHolder accountHolder;
    
	public CheckingAccount() {}

	CheckingAccount(double balance) {
		super(balance);
	}

	CheckingAccount(double balance, double interestRate) {
		super(balance, interestRate);
	}

	CheckingAccount(double balance, double interestRate, java.util.Date openedDate) {
		super(balance, interestRate, openedDate);
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckingAccount )) return false;
        return (Long)id != null && (Long)id == ((CheckingAccount)o).getId();
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}