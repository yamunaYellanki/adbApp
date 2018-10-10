package com.verizon.adb.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="contacts")
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long contactId;
	
	@NotEmpty(message="firstName can not be empty")
	@Size(min=5,max=15,message="First name must be b/w 5 to 15 characters")
	private String firstName;
	
	
	@NotEmpty(message="LastName can not be empty")
	@Size(min=5,max=15,message="Last name must be b/w 5 to 15 characters")
	private String lastName;
	
	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message="DOB can't be left blank")
	@Column(name="dob")
	private LocalDate dateOfBirth;
	
	@NotEmpty(message="email can not be empty")
	@Email
	private String emailId;
	
	@NotEmpty(message="mobile no can not be empty")
	@Pattern(regexp="\\d{10}",message="mobile no is only of 10 digits")
	@Column(name="Phn")
	private String mobileNumber;
	
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
	
	
}
