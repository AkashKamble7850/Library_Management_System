package com.sunbeam.dtos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class StaffDTO {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int staffId;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty 
	private String lastName;
	
	@NotEmpty
	private String role;
	
	@NotEmpty
	private String gender;
	
	@NotEmpty
	@Email
	@Column(unique = true)
	private String email; 
	
	@NotEmpty
	@Size(min = 8)
	private String password; 
	
	@NotEmpty
	@Pattern(regexp="^[0-9]{10}$")//allow to add only numbers in 10 spaces
	private String mobile;
	
	@NotEmpty
	private String address;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;
	
	private String salaryStatus;
	
	//parameterless Constructor
	public StaffDTO() {
	}
	
	//Parameterized Constructor
	public StaffDTO(int staffId, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String role,
			@NotEmpty String gender, @NotEmpty @Email String email, @NotEmpty @Size(min = 8) String password,
			@NotEmpty @Pattern(regexp = "^[0-9]{10}$") String mobile, @NotEmpty String address,
			@NotNull Date dateOfJoining, String salaryStatus) {
		super();
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.dateOfJoining = dateOfJoining;
		this.salaryStatus = salaryStatus;
	}
	
	//Getter and Setters
	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getSalaryStatus() {
		return salaryStatus;
	}

	public void setSalaryStatus(String salaryStatus) {
		this.salaryStatus = salaryStatus;
	}

	//toString
	@Override
	public String toString() {
		return "StaffDTO [staffId=" + staffId + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", gender=" + gender + ", email=" + email + ", password=" + password + ", mobile=" + mobile
				+ ", address=" + address + ", dateOfJoining=" + dateOfJoining + ", salaryStatus=" + salaryStatus + "]";
	}
		
}

/*
{
"FirstName" : "Rohit",
"LastName":"Sharma",
"Role": "Librarian",
"Gender":"Male",
"Email":"rohit@gmail.com", 
"Password":"rohit",
"Mobile":"98765432",
"Address":"Nagpur",
"DateOfJoining":"2021-02-18"
}

{
    "firstName" : "Rashmi",
    "lastName": "Patil",
    "role" : "admin",
    "gender" : "Female",
    "email" : "rashmi@gamil.com",
    "password" : "rashmipatil",
    "mobile" : "1234567890",
    "address" : "Mumbai",
    "dateOfJoining" : "2021-02-18"
}
*/