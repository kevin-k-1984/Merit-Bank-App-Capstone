package com.meritamerica.assignment6.models;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

@MappedSuperclass
@Table(name = "bank_accounts")
public abstract class BankAccount {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer accountHolderId;

    protected Date openDate;

	protected double INTEREST_RATE;
    protected long accountNumber = 0;
    protected double balance = 0;

	public BankAccount() {

	}

    BankAccount(double balance) {
    	this.balance = balance;
    }

	BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.INTEREST_RATE = interestRate;
	}

	BankAccount(double balance, double interestRate, java.util.Date accountOpenedOn) {
		this.balance = balance;
		this.INTEREST_RATE = interestRate;
		this.openDate = accountOpenedOn;
	}

	BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.INTEREST_RATE = interestRate;
		this.openDate = accountOpenedOn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountHolderId() {
		return accountHolderId;
	}

	public void setAccountHolderId(Integer accountHolderId) {
		this.accountHolderId = accountHolderId;
	}

	public double getINTEREST_RATE() {
		return INTEREST_RATE;
	}

	public void setINTEREST_RATE(double INTEREST_RATE) {
		this.INTEREST_RATE = INTEREST_RATE;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

    public double futureValue(int years) {
        return this.balance * (Math.pow(1 + this.INTEREST_RATE, years));
    }

//    boolean withdraw(double amount) {
//        if ((amount > 0) && (amount <= this.balance)) {
//            this.balance -= amount;
//            return true;
//        }
//        return false;
//    }
//
//    boolean deposit(double amount){
//        if (amount > 0) {
//            this.balance += amount;
//            return true;
//        }
//        return false;
//    }

//    public void addTransaction(Transaction transaction) {
//        this.listOfTransactions.add(transaction);
//    }
//
//    public List<Transaction> getTransactions() {
//        return listOfTransactions;
//    }

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

//    String writeToString() {
//        String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(this.accountOpenedOn);
//        String[] newStr = {String.valueOf(this.accountNumber), String.valueOf(this.balance), String.format("%.4f", this.interestRate), formattedDate};
//        return String.join(",", newStr);
//    }

}
