package com.meritamerica.assignment7.models;

import javax.persistence.*;

@Entity
public class AccountHolderContactDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String email;
	
	private String phoneNumber;
	
	public AccountHolderContactDetails() {}

	public long getContactId() {
		return id;
	}

	public void setContactId(long id) {
		this.id = id;
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
	
}
