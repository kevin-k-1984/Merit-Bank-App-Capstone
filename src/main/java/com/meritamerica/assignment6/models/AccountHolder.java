package com.meritamerica.assignment6.models;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "account_holders")
public class AccountHolder {
	
	// ------ INSTANCE VARS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String firstName;
    
    private String middleName;
    
    private String lastName;
    
    @Size(min = 9, max = 11)
    private String ssn;
    
    @OneToMany(mappedBy = "accountHolder")
    private List<CheckingAccount> checkingAccounts;
    
    @OneToMany(mappedBy = "accountHolder")
    private List<SavingsAccount> savingsAccounts;
    
    @OneToMany(mappedBy = "accountHolder")
    private List<CDAccount> cdAccounts;
    
    AccountHolder() {	
		
    }

    AccountHolder(String firstName, String middleName, String lastName, String ssn) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.ssn = ssn; 
    }
    
    public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSSN() {
        return ssn;
    }

    public void setSSN(String ssn) {
        this.ssn = ssn;
    }

	public List<CheckingAccount> getCheckingAccounts() {
		return checkingAccounts;
	}

	public void setCheckingAccounts(List<CheckingAccount> checkingAccounts) {
		this.checkingAccounts = new ArrayList<CheckingAccount>(checkingAccounts);
	}

	public List<SavingsAccount> getSavingsAccounts() {
		return savingsAccounts;
	}

	public void setSavingsAccounts(List<SavingsAccount> savingsAccounts) {
		this.savingsAccounts = new ArrayList<SavingsAccount>(savingsAccounts);
	}
	
	public List<CDAccount> getCDAccounts() {
		return cdAccounts;
	}

	public void setCDAccounts(List<CDAccount> cdAccounts) {
		this.cdAccounts = new ArrayList<CDAccount>(cdAccounts);
	}

    public int getNumberOfCheckingAccounts() {
        if(checkingAccounts != null) {
            return checkingAccounts.size();
        }
        return 0;
    }

    public double getCheckingBalance() {
        double sum = 0;
        if(checkingAccounts != null) {
            for (CheckingAccount chkAcct : checkingAccounts) {
                sum = sum + chkAcct.getBalance();
            }
            return sum;
        }
            return 0;
    }

    public int getNumberOfSavingsAccounts() {
        if(savingsAccounts != null) {
            return savingsAccounts.size();
        }
        return 0;
    }

    public double getSavingsBalance() {
        double sum = 0;
        if(savingsAccounts != null) {
            for (SavingsAccount savAcct : savingsAccounts) {
                sum = sum + savAcct.getBalance();
            }
            return sum;
        }
        return 0;
    }

    public int getNumberOfCDAccounts() {
        if(cdAccounts != null) {
            return cdAccounts.size();
        }
        return 0;
    }

    public double getCDBalance() {
        double sum = 0;
        if(cdAccounts != null) {
            for (CDAccount cdAcct : cdAccounts) {
                sum = sum + cdAcct.getBalance();
            }
            return sum;
        }
        return 0;
    }

    public double getCombinedBalance() {
        return getCheckingBalance() + getSavingsBalance() + getCDBalance();
    }

 /*
    // TODO modify methods to send to a service for handling
    //---------- CHECKING ACCOUNT ----------//
    public CheckingAccount addCheckingAccount(double openingBalance) throws ExceedsCombinedBalanceLimitException, ExceedsFraudSuspicionLimitException {
        return this.addCheckingAccount(new CheckingAccount(openingBalance));
    }

    public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) throws ExceedsCombinedBalanceLimitException, ExceedsFraudSuspicionLimitException {
        if ((this.getCheckingBalance() + (this.getCombinedBalance() - this.getCDBalance()) >= BALANCE_LIMIT)) {
            throw new ExceedsCombinedBalanceLimitException("Balance exceeds limit. Unable to open new account at this time");
        } else if(checkingAccount.getBalance() > FRAUD_THRESHOLD) {
            throw new ExceedsFraudSuspicionLimitException("Possible fraud detected. Transaction is being sent to fraud detection services for review");
        }

        // checkingAccount.addTransaction(new DepositTransaction(checkingAccount, checkingAccount.getBalance()));

        CheckingAccount[] tempArr = new CheckingAccount[this.checkingAccountList.length + 1];
        System.arraycopy(this.checkingAccountList, 0, tempArr, 0, this.checkingAccountList.length);
        tempArr[tempArr.length - 1] = checkingAccount;
        this.checkingAccountList = tempArr;

        return checkingAccount;
    }

    public CheckingAccount[] getCheckingAccounts() {
        return checkingAccountList;
    }

    //-------- SAVINGS ACCOUNT ------//
    public SavingsAccount addSavingsAccount(double openingBalance) throws ExceedsCombinedBalanceLimitException, ExceedsFraudSuspicionLimitException {
        return this.addSavingsAccount(new SavingsAccount(openingBalance));
    }

    public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) throws ExceedsCombinedBalanceLimitException, ExceedsFraudSuspicionLimitException {
        if (this.getSavingsBalance() + (this.getCombinedBalance() - this.getCDBalance()) >= BALANCE_LIMIT) {
            throw new ExceedsCombinedBalanceLimitException("Balance exceeds limit. Unable to open new account at this time");
        } else if(savingsAccount.getBalance() > FRAUD_THRESHOLD){
            throw new ExceedsFraudSuspicionLimitException("Possible fraud detected. Transaction is being sent to fraud detection services for review");
        }

        // savingsAccount.addTransaction(new DepositTransaction(savingsAccount, savingsAccount.getBalance()));

        SavingsAccount[] tempArr = new SavingsAccount[this.savingsAccountList.length + 1];
        System.arraycopy(this.savingsAccountList, 0, tempArr, 0, this.savingsAccountList.length);
        tempArr[tempArr.length - 1] = savingsAccount;
        this.savingsAccountList = tempArr;
        return savingsAccount;

    }


    //------ CD ACCOUNT ---------//
    public CDAccount addCDAccount(CDOffering offering, double openingBalance) throws ExceedsFraudSuspicionLimitException, NegativeAmountException {
        if(offering == null) return null;

        CDAccount newCDAccount = new CDAccount(offering, openingBalance);
        DepositTransaction transaction = new DepositTransaction(newCDAccount, openingBalance);

        try {
            MeritBank.processTransaction(transaction);
        }
        catch (ExceedsFraudSuspicionLimitException e) {
            throw new ExceedsFraudSuspicionLimitException("Possible fraud detected. Transaction is being sent to fraud detection services for review");
        }
        catch (NegativeAmountException e) {
            throw new NegativeAmountException("Unable to process request. Transaction amount must be greater than $0");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        CDAccount[] tempArr = new CDAccount[this.cdAccountList.length + 1];
        System.arraycopy(this.cdAccountList, 0, tempArr, 0, this.cdAccountList.length + 1);
        tempArr[tempArr.length - 1] = newCDAccount;
        this.cdAccountList = tempArr;
        return newCDAccount;
    }

    public CDAccount addCDAccount(CDAccount cdAccount) throws ExceedsFraudSuspicionLimitException, NegativeAmountException {

        DepositTransaction transaction = new DepositTransaction(cdAccount, cdAccount.getBalance());

        try {
            MeritBank.processTransaction(transaction);
        }
        catch (ExceedsFraudSuspicionLimitException e) {
            throw new ExceedsFraudSuspicionLimitException("Possible fraud detected. Transaction is being sent to fraud detection services for review");
        }
        catch (NegativeAmountException e) {
            throw new NegativeAmountException("Unable to process request. Transaction amount must be greater than $0");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        CDAccount[] tempArr = new CDAccount[this.cdAccountList.length + 1];
        System.arraycopy(this.cdAccountList, 0, tempArr, 0, this.cdAccountList.length);
        tempArr[tempArr.length - 1] = cdAccount;
        this.cdAccountList = tempArr;
        return cdAccount;
    }

    public static AccountHolder readFromString(String accountHolderData) {
        String[] tempArr = accountHolderData.split(",");
        String tempFirstName = "", tempMidName = "", TempLastName = "", tempSSN = "";

        tempFirstName += tempArr[2];
        tempMidName += tempArr[1];
        TempLastName += tempArr[0];
        tempSSN += tempArr[3];

        return new AccountHolder(tempFirstName, tempMidName, TempLastName, tempSSN);
    }

    // TODO -- fix file writer (txn's)
    // may need to swap loops to for i loops
//    public String writeToString() {
//        StringBuilder sb = new StringBuilder(this.lastName).append(",").append(this.middleName).append(",").append(this.firstName).append(",").append(this.ssn).append(System.lineSeparator());
//        sb.append(this.getNumberOfCheckingAccounts()).append(System.lineSeparator());
//
//        for(CheckingAccount chk: this.checkingAccountList){
//            sb.append(chk.writeToString()).append(System.lineSeparator());
//            sb.append(chk.getTransactions().size()).append(System.lineSeparator());
//            for(Transaction txn: chk.getTransactions()) sb.append(txn.writeToString()).append(System.lineSeparator());
//        }
//
//        sb.append(this.getNumberOfSavingsAccounts()).append(System.lineSeparator());
//        for(SavingsAccount sav: this.savingsAccountList){
//            sb.append(sav.getTransactions()).append(System.lineSeparator());
//            sb.append(sav.writeToString()).append(System.lineSeparator());
//            for(Transaction txn: sav.getTransactions()) sb.append(txn.writeToString()).append(System.lineSeparator());
//        }
//
//        sb.append(this.getNumberOfCDAccounts()).append(System.lineSeparator());
//        for(CDAccount cd: this.cdAccountList){
//            sb.append(cd.getTransactions()).append(System.lineSeparator());
//            sb.append(cd.writeToString()).append(System.lineSeparator());
//            for(Transaction txn: cd.getTransactions()) sb.append(txn.writeToString()).append(System.lineSeparator());
//        }
//
//        return sb.toString();
//    }

    @Override
    public int compareTo(AccountHolder otherAccountHolder) {
        return Double.compare(this.getCombinedBalance(), otherAccountHolder.getCombinedBalance());
        /*
         if(this.getCombinedBalance() == otherAccountHolder.getCombinedBalance()) return 0;
        else if(this.getCombinedBalance() < otherAccountHolder.getCombinedBalance()) return -1;
        else return 1;
         */
}

