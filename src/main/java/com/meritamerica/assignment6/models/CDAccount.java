package com.meritamerica.assignment6.models;

import javax.persistence.*;

@Entity
public class CDAccount extends BankAccount {

    @ManyToOne
    @JoinColumn(name = "cdOffering_id", nullable = false)
    private CDOffering cdOffering;
    
    @ManyToOne
    @JoinColumn(name = "accountHolder_id", nullable = false)
    private AccountHolder accountHolder;
    
    public CDAccount() {
    }
    
    public CDOffering getCdOffering() {
		return cdOffering;
	}

	public void setCdOffering(CDOffering cdOffering) {
		this.cdOffering = cdOffering;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	public int getTerm() {
		return this.cdOffering.getTerm();
	}

	public void setTerm(int term) {
		this.cdOffering.setTerm(term);
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