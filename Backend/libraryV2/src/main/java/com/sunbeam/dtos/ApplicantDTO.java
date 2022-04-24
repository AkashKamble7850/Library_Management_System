package com.sunbeam.dtos;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.sunbeam.entities.MembershipPlan;

public class ApplicantDTO {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int Id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@Email(message = "Email is already used")
	@NotNull
	private String 	email;
	
	@Pattern(regexp="^[0-9]{10}$")
	private String mobile;
	
	@NotNull
	@Size(min = 8)
	private String password;
	
	@NotNull
	private String address;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date registerDate;
	
	private String education;
	
	private String intrest;
	
	@ManyToOne
	@JoinColumn(name = "uPlanId")
	private MembershipPlan plan;
	
	public ApplicantDTO() {
	}

	public ApplicantDTO(int id, @NotNull String firstName, @NotNull String lastName,
			@Email(message = "Email is already used") @NotNull String email,
			@Pattern(regexp = "^[0-9]{10}$") String mobile, @NotNull @Size(min = 8) String password,
			@NotNull String address, Date registerDate, String education, String intrest, String role,
			MembershipPlan plan) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.address = address;
		this.registerDate = registerDate;
		this.education = education;
		this.intrest = intrest;
		this.plan = plan;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getIntrest() {
		return intrest;
	}

	public void setIntrest(String intrest) {
		this.intrest = intrest;
	}

	public MembershipPlan getPlan() {
		return plan;
	}

	public void setPlan(MembershipPlan plan) {
		this.plan = plan;
	}
	

	@Override
	public String toString() {
		return "ApplicantDTO [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + ", password=" + password + ", address=" + address + ", registerDate="
				+ registerDate + ", education=" + education + ", intrest=" + intrest + ", plan=" + plan + "]";
	}
	
	
	
}


