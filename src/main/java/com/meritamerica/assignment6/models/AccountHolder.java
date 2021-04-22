package com.meritamerica.assignment6.models;

import javax.persistence.*;

@Entity
@Table(name = "Account_Holder")
public class AccountHolder {
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(
			name = "id",
			updatable = false
			)
    long id;
	@Column(
			name = "first_name",
			nullable = false,
			columnDefinition = "TEXT"
			)
    private String firstName;
	@Column(
			name = "middle_name",
			columnDefinition = "TEXT"
			)
    private String middleName;
    @Column(
			name = "first_name",
			nullable = false,
			columnDefinition = "TEXT"
			)
    private String lastName;
    @Column(
			name = "ssn",
			nullable = false,
			unique = true,
			columnDefinition = "TEXT"
			)
    private String ssn;
    
    // TODO add table types here
    // add instance variables
    
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
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

}