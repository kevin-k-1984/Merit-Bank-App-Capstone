package com.meritamerica.MeritBankAppCapstone.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ContactDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String email;
	private String phone;

	@JsonIgnore
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
	AccountHolder accountHolder;
	
	public ContactDetails() {}

	public ContactDetails(String email, String phone) {
		this.email = email;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
}
