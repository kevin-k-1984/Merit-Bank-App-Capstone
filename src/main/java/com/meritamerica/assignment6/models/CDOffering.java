package com.meritamerica.assignment6.models;

import javax.persistence.*;

@Entity
@Table(name = "cd_offerings")
public class CDOffering {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "term",
			nullable = false,
			columnDefinition = "INT"
			)
    protected int term;
	@Column(name = "interest_rate",
			nullable = false,
			columnDefinition = "DOUBLE"
			)
    protected double interestRate;
    
    public CDOffering(int term, double interestRate) {
    	// this.offerId = nextOfferId++;
        this.term = term;
        this.interestRate = interestRate;
    }

    public int getTerm() {
        return term;
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