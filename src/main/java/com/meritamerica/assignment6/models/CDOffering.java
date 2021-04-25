package com.meritamerica.assignment6.models;

import javax.persistence.*;

@Entity
@Table(name = "CDOfferings")
public class CDOffering {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne(mappedBy = "cdOffering")
	private CDAccount cdAccount;
	
    protected int term;
    protected double interestRate;
    
    public CDOffering() {}
    
    public CDOffering(int term, double interestRate) {
        this.term = term;
        this.interestRate = interestRate;
    }
    
    public long getId() {
    	return this.id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }
    
    public CDAccount getCdAccount() {
    	return this.cdAccount;
    }
    
    public void setCdAccount(CDAccount cdAccount) {
    	this.cdAccount = cdAccount;
    }

    public int getTerm() {
        return this.term;
    }
    
    public void setTerm(int term) {
    	this.term = term;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
    	this.interestRate = interestRate;
    }
    
//  public void setOfferId(int offerId) {
//    this.offerId = offerId;
//  }
    
//  public int getOfferId() {
//	return offerId;
//	}

/*
    public static CDOffering readFromString(String cdOfferingDataString) {

        int tempTerm;
        double tempIntRate;
        int comma = cdOfferingDataString.indexOf(",");
        if(comma >= 0) {
            tempTerm = Integer.parseInt(cdOfferingDataString.substring(0, comma));
            tempIntRate = Double.parseDouble(cdOfferingDataString.substring(comma + 1));
        } else {
            System.out.println("CD Offering data format incorrect");
            throw new NumberFormatException();
        }
        return new CDOffering(tempTerm, tempIntRate);
    }

    public String writeToString() {
        return this.term + "," + this.interestRate + "\n";
    }
*/
}