package com.meritamerica.assignment6.models;

import javax.persistence.*;

@Entity
@Table(name = "checking_accounts")
public class CheckingAccount extends BankAccount {

    @ManyToOne
    private AccountHolder accountHolder;
    
	public CheckingAccount() {

	}

	CheckingAccount(double balance) {
		super();
		this.balance = balance;
	}

	CheckingAccount(double balance, double interestRate) {
		super(balance);
		this.balance = balance;
		this.INTEREST_RATE = interestRate;
	}

	CheckingAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
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

//    public static CheckingAccount readFromString(String accountData) throws ParseException, NumberFormatException {
//        String[] tempArr = accountData.split(",");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//        long tempAcctNum = Long.parseLong(tempArr[0]);
//        double tempBal = Double.parseDouble(tempArr[1]), tempIntRate = Double.parseDouble(tempArr[2]);
//        Date tempOpenDate = dateFormat.parse((tempArr[3]));
//
//        return new CheckingAccount(tempAcctNum, tempBal, tempIntRate, tempOpenDate);
//    }

}