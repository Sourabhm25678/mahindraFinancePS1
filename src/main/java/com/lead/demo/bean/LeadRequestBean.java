package com.lead.demo.bean;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class LeadRequestBean implements Serializable {

	private static final long serialVersionUID = -6187934639181301990L;
	
	@NotNull(message = "leadId is mandatory")
	private String leadId;

	@NotBlank(message = "firstName is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "firstName should contain only alphabets and spaces are not allowed.")
	private String firstName;

	@Pattern(regexp = "^[a-zA-Z]+$", message = "Middle name should contain only alphabets with no spaces.")
	private String middleName;

	@NotBlank(message = "lastName is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "lastName should contain only alphabets and spaces are not allowed.")
	private String lastName;

	@NotBlank(message = "mobileNumber is mandatory")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Please enter valid mobileNumber.")
	private String mobileNumber;

	@NotBlank(message = "gender is mandatory")
    @Pattern(regexp = "^(Male|Female|Others)$", message = "Please enter valid gender - Male, Female or Others.")
	private String gender;

	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "DOB is mandatory and should in format - dd/MM/yyyy")
	private String DOB;

	@NotBlank(message = "Email is mandatory")
	@Email(regexp = ".+@.+", message = "Invalid email format")
	private String email;

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

}
