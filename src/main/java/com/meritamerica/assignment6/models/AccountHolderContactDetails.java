package com.meritamerica.assignment6.models;

import javax.persistence.*;

@Entity
@Table(name = "contact_info")
public class AccountHolderContactDetails {
	
	@Id
	@GeneratedValue
	@Column(name = "contact_id")
	private Long contactId;
	
	@Column(name = "contact_email",
			unique = true,
			nullable = false,
			columnDefinition = "TEXT"
			)
	private String email;
	
	@Column(name = "contact_phone_num",
			unique = true,
			nullable = false,
			columnDefinition = "TEXT"
			)
	private String phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id", referencedColumnName = "account_holder_id")
	private AccountHolder accountHolder;
	
	public AccountHolderContactDetails() {
		
	}

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
	
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	
}
