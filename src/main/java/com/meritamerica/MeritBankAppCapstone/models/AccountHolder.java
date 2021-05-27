package com.meritamerica.MeritBankAppCapstone.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity(name = "AccountHolders")
@Table(name = "accountHolders")
public class AccountHolder implements Comparable<AccountHolder> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_holders_id")
    private long id;

    @NotEmpty(message = "Please Enter First Name")
    private String firstName;
    
    private String middleName;
    
    @NotEmpty(message = "Please Enter Last Name")
    private String lastName;
    
    @NotEmpty(message = "Please Enter SSN")
    @Size(min = 9, max = 11)
    private String ssn;

//    @JsonIgnore
    @OneToOne(mappedBy = "accountHolder")
    private ContactDetails contact;

//    @JsonIgnore
    @OneToOne(mappedBy = "accountHolder")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountHolder", orphanRemoval = true)
    private List<CheckingAccount> checkingAccounts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountHolder", orphanRemoval = true)
    private List<SavingsAccount> savingsAccounts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountHolder", orphanRemoval = true)
    private List<CDAccount> cdAccounts = new ArrayList<>();
    
    public AccountHolder() {}

    public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.ssn = ssn; 
    }
    
    public long getId() {
    	return id;
    }
    
    public void setId(int id) {
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
		this.checkingAccounts = checkingAccounts;
	}

	public List<SavingsAccount> getSavingsAccounts() {
		return savingsAccounts;
	}

	public void setSavingsAccounts(List<SavingsAccount> savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}
	
	public List<CDAccount> getCdAccounts() {
		return cdAccounts;
	}

	public void setCdAccounts(List<CDAccount> cdAccounts) {
		this.cdAccounts = cdAccounts;
	}

    public ContactDetails getContact() {
        return contact;
    }

    public void setContact(ContactDetails contact) {
        this.contact = contact;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
	public int compareTo(AccountHolder o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

