package com.meritamerica.assignment7.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "CDAccounts")
@Table(name = "CDAccounts")
public class CDAccount extends BankAccount {
	
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cdOffering_id")
    private CDOffering cdOffering;
    
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "account_holders_id")
    protected AccountHolder accountHolder;
    
    public CDAccount() {
    	super();
    	this.cdOffering = new CDOffering(1, 0.025); 
    }
    
    public CDAccount(double balance, CDOffering cdOffering) {
    	super(balance, cdOffering.interestRate);
    	this.cdOffering = cdOffering;
    }
    
    public CDOffering getCdOffering() {
		return cdOffering;
	}

	public void setCdOffering(CDOffering cdOffering) {
		this.cdOffering = cdOffering;
	}
	
	public int getTerm() {
		return this.cdOffering.getTerm();
	}

	public void setTerm(int term) {
		this.cdOffering.setTerm(term);
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
}