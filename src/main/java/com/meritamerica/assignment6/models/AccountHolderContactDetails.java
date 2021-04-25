package com.meritamerica.assignment6.models;

import javax.persistence.*;

@Entity
@Table(name = "account_holder_contact_details")
public class AccountHolderContactDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long contactId;
	
	private String email;
	
	private String phoneNumber;
	
//	private AccountHolder accountHolder;
	
	public AccountHolderContactDetails() {}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
//	public AccountHolder getAccountHolder() {
//		return accountHolder;
//	}
//
//	public void setAccountHolder(AccountHolder accountHolder) {
//		this.accountHolder = accountHolder;
//	}
	
}
