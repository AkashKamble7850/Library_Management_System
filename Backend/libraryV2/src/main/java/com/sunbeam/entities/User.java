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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
(
	name = "user",
	uniqueConstraints=	//Specifies that a unique constraint is to be included in the generated DDL for a table
	{
       @UniqueConstraint(columnNames = "uEmail"),
       @UniqueConstraint(columnNames = "uMobile")
    }
)
public class User {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int userId;
	
	@NotNull
	private String uFirstName;
	
	@NotNull
	private String 	uLastName;
	
	@Email //The string has to be a well-formed email address
	@NotNull
	private String 	uEmail;
	
	@Pattern(regexp="^[0-9]{10}$") //The annotated CharSequence must match the specified regular expression
	private String uMobile;
	
	@NotNull
	@Size(min = 8)	//The annotated element size must be between the specified boundaries (included). 
	private String uPassword;
	
	private String uAddress;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date uRegisterDate;
	
	private String uEducation;
	
	private String uIntrest;
	
	@JsonProperty("uPlan")
	@ManyToOne
	@JoinColumn(name = "uPlanId")
	private MembershipPlan uPlan;
	
	@Column(columnDefinition = "boolean default false")
	private boolean uStatus;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Feedback> feedbackList;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<IssueBook> issueBookList;

	//Parameterless Constructor
	public User() {
		this.feedbackList = new ArrayList<Feedback>();
		this.issueBookList = new ArrayList<IssueBook>();
	}

	
	
	public User(int userId) {
		this.userId = userId;
	}


	public User(int userId, @NotNull String uFirstName, @NotNull String uLastName, @Email @NotNull String uEmail,
			@Pattern(regexp = "^[0-9]{10}$") String uMobile, @NotNull @Size(min = 8) String uPassword, String uAddress,
			Date uRegisterDate, String uEducation, String uIntrest, boolean uStatus) {
		this.userId = userId;
		this.uFirstName = uFirstName;
		this.uLastName = uLastName;
		this.uEmail = uEmail;
		this.uMobile = uMobile;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
		this.uRegisterDate = uRegisterDate;
		this.uEducation = uEducation;
		this.uIntrest = uIntrest;
		this.uStatus = uStatus;
	}
	

	public User(int userId, @NotNull String uFirstName, @NotNull String uLastName, @Email @NotNull String uEmail,
			@Pattern(regexp = "^[0-9]{10}$") String uMobile, @NotNull @Size(min = 8) String uPassword, String uAddress,
			String uEducation, String uIntrest) {
		this.userId = userId;
		this.uFirstName = uFirstName;
		this.uLastName = uLastName;
		this.uEmail = uEmail;
		this.uMobile = uMobile;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
		this.uEducation = uEducation;
		this.uIntrest = uIntrest;
	}

	
	public User(@NotNull String uFirstName, @NotNull String uLastName, @Email @NotNull String uEmail,
			@Pattern(regexp = "^[0-9]{10}$") String uMobile, @NotNull @Size(min = 8) String uPassword) {
		this.uFirstName = uFirstName;
		this.uLastName = uLastName;
		this.uEmail = uEmail;
		this.uMobile = uMobile;
		this.uPassword = uPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getuFirstName() {
		return uFirstName;
	}

	public void setuFirstName(String uFirstName) {
		this.uFirstName = uFirstName;
	}

	public String getuLastName() {
		return uLastName;
	}

	public void setuLastName(String uLastName) {
		this.uLastName = uLastName;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuMobile() {
		return uMobile;
	}

	public void setuMobile(String uMobile) {
		this.uMobile = uMobile;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public Date getuRegisterDate() {
		return uRegisterDate;
	}

	public void setuRegisterDate(Date uRegisterDate) {
		this.uRegisterDate = uRegisterDate;
	}

	public String getuEducation() {
		return uEducation;
	}

	public void setuEducation(String uEducation) {
		this.uEducation = uEducation;
	}

	public String getuIntrest() {
		return uIntrest;
	}

	public void setuIntrest(String uIntrest) {
		this.uIntrest = uIntrest;
	}

	public MembershipPlan getuPlan() {
		return uPlan;
	}

	public void setuPlan(MembershipPlan uPlan) {
		this.uPlan = uPlan;
	}

	public boolean isuStatus() {
		return uStatus;
	}

	public void setuStatus(boolean uStatus) {
		this.uStatus = uStatus;
	}

	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}

	public List<IssueBook> getIssueBookList() {
		return issueBookList;
	}

	public void setIssueBookList(List<IssueBook> issueBookList) {
		this.issueBookList = issueBookList;
	}

	public void addFeedback(Feedback feed)
	{
		this.feedbackList.add(feed);
		feed.setUser(this);
	}

	public void addIssuedBook(IssueBook b)
	{
		this.issueBookList.add(b);
		b.setUser(this);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", uFirstName=" + uFirstName + ", uLastName=" + uLastName + ", uEmail="
				+ uEmail + ", uMobile=" + uMobile + ", uPassword=" + uPassword + ", uAddress=" + uAddress
				+ ", uRegisterDate=" + uRegisterDate + ", uEducation=" + uEducation + ", uIntrest=" + uIntrest
				+ ", uPlan=" + uPlan + ", uStatus=" + uStatus + "]";
	}

}
