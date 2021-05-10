package com.meritamerica.assignment7.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class CDOffering {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cdOffering", orphanRemoval = true)
	private List<CDAccount> cdAccounts = new ArrayList<>();
	
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
    
    public List<CDAccount> getCDAccounts() {
    	return this.cdAccounts;
    }
    
    public void setCDAccount(List<CDAccount> cdAccounts) {
    	this.cdAccounts = cdAccounts;
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
}