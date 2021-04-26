package com.meritamerica.assignment6.models;

import javax.persistence.*;

@Entity(name = "CheckingAccounts")
@Table(name = "checkingAccounts")
public class CheckingAccount extends BankAccount {

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