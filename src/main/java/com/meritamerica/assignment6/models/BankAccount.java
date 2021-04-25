package com.meritamerica.assignment6.models;

import java.util.*;

import javax.persistence.*;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;

@MappedSuperclass
public abstract class BankAccount {

	@Id
	@GeneratedValue
	private Long accountNumber;
	
    private Date openDate;
	
	@Min(0)
	private double interestRate;
	
	@Min(0)
    private double balance;
	
	//private Long accountHolder;
    // Date accountOpenedOn;
    // protected long accountNumber;
    // protected double interestRate;
    // private List<Transaction> listOfTransactions = new ArrayList<Transaction>();	
    
    BankAccount() {
    	this.openDate = new Date();
    }

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

//	public Long getAccountHolder() {
//		return accountHolder;
//	}
//
//	public void setAccountHolder(Long accountHolder) {
//		this.accountHolder = accountHolder;
//	}
    
    
    
/*
    BankAccount(double balance, double interestRate) {
        this(MeritBank.getNextAccountNumber(), balance, interestRate, new Date());
    }

    BankAccount(double balance, double interestRate, Date accountOpenedOn) {
        this(MeritBank.getNextAccountNumber(), balance, interestRate, accountOpenedOn);
    }

    BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;
        this.accountOpenedOn = accountOpenedOn;
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }
    
    public double getInterestRate() {
        return interestRate;
    }

    public double futureValue(int years) {
        return this.balance * (Math.pow(1 + this.interestRate, years));
    }

    boolean withdraw(double amount) {
        if ((amount > 0) && (amount <= this.balance)) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    boolean deposit(double amount){
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    public void addTransaction(Transaction transaction) {
        this.listOfTransactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return listOfTransactions;
    }
    
    
//    public static BankAccount readFromString(String accountData) throws ParseException {
//        String[] data = accountData.split(",");
//
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        int tempAcctNum = Integer.parseInt(data[0]);
//        double tampBal = Double.parseDouble(data[1]);
//        double tempIntRate = Double.parseDouble(data[2]);
//        Date tempOpenDate = formatter.parse(data[3]);
//
//        return new BankAccount(tempAcctNum, tampBal, tempIntRate, tempOpenDate);
//    }
    

    String writeToString() {
        String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(this.accountOpenedOn);
        String[] newStr = {String.valueOf(this.accountNumber), String.valueOf(this.balance), String.format("%.4f", this.interestRate), formattedDate};
        return String.join(",", newStr);
    }
*/
}
