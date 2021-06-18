package com.meritamerica.MeritBankAppCapstone.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CDAccount extends BankAccount {
	
//	@JsonIgnore
    @ManyToOne
    private CDOffering cdOffering;
    
    @JsonIgnore
	@ManyToOne
    protected AccountHolder accountHolder;
    
    public CDAccount() {
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

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
}