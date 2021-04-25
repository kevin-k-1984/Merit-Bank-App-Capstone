package com.meritamerica.assignment6.models;

import javax.persistence.*;

@Entity
@Table(name = "savings_accounts")
public class SavingsAccount extends BankAccount {
    
    @ManyToOne
    @JoinColumn(name="account_holders_id", nullable=false)
    private AccountHolder accountHolder;
    
    public SavingsAccount() {

    }

	SavingsAccount(double balance) {
		super();
		this.balance = balance;
	}

	SavingsAccount(double balance, double interestRate) {
		super(balance);
		this.balance = balance;
		this.INTEREST_RATE = interestRate;
	}

	SavingsAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
		super(balance);
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.INTEREST_RATE = interestRate;
		this.setOpenDate(accountOpenedOn);
	}
	
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	
/*	
    SavingsAccount() {
        super(0, INTEREST_RATE);
    }
    
    SavingsAccount(double balance) {
        super(MeritBank.getNextAccountNumber(), balance, INTEREST_RATE, new Date());
    }

    SavingsAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
        super(accountNumber, balance, interestRate, accountOpenedOn);
    }

    public static SavingsAccount readFromString(String accountData) throws ParseException, NumberFormatException {
        String[] tempArr = accountData.split(",");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        long tempAcctNum = Long.parseLong(tempArr[0]);
        double tempBal = Double.parseDouble(tempArr[1]), tempIntRate = Double.parseDouble(tempArr[2]);
        Date tempOpenDate = dateFormat.parse((tempArr[3]));

        return new SavingsAccount(tempAcctNum, tempBal, tempIntRate, tempOpenDate);
    }
*/
}