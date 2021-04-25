package com.meritamerica.assignment6.models;

import java.util.*;

import javax.persistence.*;

@Entity
public class CDAccount extends BankAccount {

    protected Date openDate;
    protected int term;
    
    public CDAccount() {
    	
    }

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public Date getAccountOpenedOn() {
		return openDate;
	}

/*	
 	public CDAccount(CDOffering offering, double balance) {
        super(balance, offering.getInterestRate());
        this.cdOffering = offering;
        this.accountOpenedOn = new Date();
    }

    public CDAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn, int term) {
        super(accountNumber, balance, interestRate, accountOpenedOn);
        this.term = term;
        this.accountOpenedOn = accountOpenedOn;
    }

   	public long getAccountNumber() {
        return super.accountNumber;
    }

    public double futureValue() {
        return MeritBank.recursiveFutureValue(super.getBalance(), cdOffering.getTerm(), cdOffering.getInterestRate());
    }

    public static CDAccount readFromString(String accountData) throws ParseException, NumberFormatException {
        String[] tempArr = accountData.split(",");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        long tempAcctNum = Long.parseLong(tempArr[0]);
        double tempBal = Double.parseDouble(tempArr[1]), tempIntRate = Double.parseDouble(tempArr[2]);
        Date tempOpenDate = dateFormat.parse(tempArr[3]);
        int tempTerm = Integer.parseInt(tempArr[4]);
        return new CDAccount(tempAcctNum, tempBal, tempIntRate, tempOpenDate, tempTerm);
    }

    String writeToString() {
        String[] newStr = new String[]{String.valueOf(this.getAccountNumber()), String.valueOf(this.balance), String.valueOf(this.getInterestRate()), String.valueOf(this.accountOpenedOn), String.valueOf(this.term)};
        return String.join(",", newStr);
    }

    @Override
    boolean withdraw(double amount) {
        Date date = new Date();
        int years = accountOpenedOn.getYear() - date.getYear();
        if (years > term) {
            if (amount <= balance && amount > 0) {
                balance -= amount;
                return true;
            }
        }
        return false;
    }

    @Override
    boolean deposit(double amount) {
        Date date = new Date();
        int years = accountOpenedOn.getYear() - date.getYear();
        if(years > term)
        {
            if(amount > 0)
            {
                balance += amount;
                return true;
            }
        }
        return false;
    }

*/
}