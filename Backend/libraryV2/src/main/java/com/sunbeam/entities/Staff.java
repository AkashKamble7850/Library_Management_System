package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "staff")
public class Staff{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int staffId;
	
	@NotEmpty
	private String sFirstName;
	
	@NotEmpty 
	private String sLastName;
	
	@NotEmpty
	private String sRole;
	
	@NotEmpty
	private String sGender;
	
	@NotEmpty
	@Email
	@Column(unique = true)
	private String sEmail; 
	
	@NotEmpty
	@Size(min = 8)
	private String sPassword; 
	
	@NotEmpty
	@Pattern(regexp="^[0-9]{10}$")//allow to add only numbers in 10 spaces
	private String sMobile;
	
	@NotEmpty
	private String sAddress;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date sDateOfJoining;
	
	private boolean sSalaryStatus;
	
	@OneToMany(mappedBy = "staff",cascade = CascadeType.DETACH)
	private List<IssueBook> bookList;
	
	//parameterless Constructor
	public Staff() {
		bookList = new ArrayList<>();
		sSalaryStatus = false;
	}
	
	//Parameterized Constructor
	public Staff(int staffId, String sFirstName, String sLastName, String sRole, String sGender, String sEmail,
			String sPassword, String sMobile, String sAddress, Date sDateOfJoining, boolean sSalaryStatus) {
		super();
		this.staffId = staffId;
		this.sFirstName = sFirstName;
		this.sLastName = sLastName;
		this.sRole = sRole;
		this.sGender = sGender;
		this.sEmail = sEmail;
		this.sPassword = sPassword;
		this.sMobile = sMobile;
		this.sAddress = sAddress;
		this.sDateOfJoining = sDateOfJoining;
		this.sSalaryStatus = sSalaryStatus;
	}
	
	//Getter and Setter
	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getsFirstName() {
		return sFirstName;
	}

	public void setsFirstName(String sFirstName) {
		this.sFirstName = sFirstName;
	}

	public String getsLastName() {
		return sLastName;
	}

	public void setsLastName(String sLastName) {
		this.sLastName = sLastName;
	}

	public String getsRole() {
		return sRole;
	}

	public void setsRole(String sRole) {
		this.sRole = sRole;
	}

	public String getsGender() {
		return sGender;
	}

	public void setsGender(String sGender) {
		this.sGender = sGender;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	public String getsMobile() {
		return sMobile;
	}

	public void setsMobile(String sMobile) {
		this.sMobile = sMobile;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public Date getsDateOfJoining() {
		return sDateOfJoining;
	}

	public void setsDateOfJoining(Date sDateOfJoining) {
		this.sDateOfJoining = sDateOfJoining;
	}

	public boolean getsSalaryStatus() {
		return sSalaryStatus;
	}

	public void setsSalaryStatus(boolean sSalaryStatus) {
		this.sSalaryStatus = sSalaryStatus;
	}

	//toSrting
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", sFirstName=" + sFirstName + ", sLastName=" + sLastName + ", sRole="
				+ sRole + ", sGender=" + sGender + ", sEmail=" + sEmail + ", sPassword=" + sPassword + ", sMobile="
				+ sMobile + ", sAddress=" + sAddress + ", sDateOfJoining=" + sDateOfJoining + ", sSalaryStatus="
				+ sSalaryStatus + "]";
	}
	
	
}
