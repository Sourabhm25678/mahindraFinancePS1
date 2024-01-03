package com.lead.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lead", schema = "dmlead")
public class Lead {
	
	@Id
	@Column(name = "leadkey")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leadKey;
	
	@Column(name = "leadid")
	private String leadId;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "middlename")
	private String middleName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "mobilenumber")
	private String mobileNumber;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "dob")
	private String DOB;
	
	@Column(name = "email")
	private String email;

	public Long getLeadKey() {
		return leadKey;
	}

	public void setLeadKey(Long leadKey) {
		this.leadKey = leadKey;
	}

	public String getLeadId() {
		return leadId;
	}

	public void setLeadId(String leadId) {
		this.leadId = leadId;
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
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Lead [leadKey=" + leadKey + ", leadId=" + leadId + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", gender=" + gender
				+ ", DOB=" + DOB + ", email=" + email + "]";
	}

}
