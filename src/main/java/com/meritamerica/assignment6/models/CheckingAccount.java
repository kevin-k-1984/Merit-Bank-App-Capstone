package com.meritamerica.assignment6.models;

import javax.persistence.*;

@Entity
public class CheckingAccount extends BankAccount {

    static final double INTEREST_RATE = 0.0001;	
    
	public CheckingAccount() {
		super();
		super.setInterestRate(INTEREST_RATE);
	}
	
/*
    CheckingAccount() {
    	super(0, interestRate);
    }
   
    CheckingAccount(double balance) {
        super(MeritBank.getNextAccountNumber(), balance, interestRate, new Date());
    }
    
    CheckingAccount(double balance, double interestRate) {
    	super(balance, interestRate);
    }
    
    CheckingAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
        super(accountNumber, balance, interestRate, accountOpenedOn);
    }
    
    public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

    public static CheckingAccount readFromString(String accountData) throws ParseException, NumberFormatException {
        String[] tempArr = accountData.split(",");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        long tempAcctNum = Long.parseLong(tempArr[0]);
        double tempBal = Double.parseDouble(tempArr[1]), tempIntRate = Double.parseDouble(tempArr[2]);
        Date tempOpenDate = dateFormat.parse((tempArr[3]));

        return new CheckingAccount(tempAcctNum, tempBal, tempIntRate, tempOpenDate);
    }
*/
}