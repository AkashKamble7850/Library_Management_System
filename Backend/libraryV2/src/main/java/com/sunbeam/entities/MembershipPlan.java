package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity	//Specifies that the class is an entity
@Table(name = "membershipplan")	//Specifies the primary table for the annotated entity
public class MembershipPlan 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment
	@Id	//Primary Key
	private int planId;
	
	@NotNull	//The annotated element must not be null
	private String planName;
	
	@NotNull
	private double planFee;
	
	@JsonIgnore
	@OneToMany (mappedBy = "uPlan",cascade = CascadeType.ALL)
	private List<User> userList;
	
	//parameterless Constructor
	public MembershipPlan() {	
		this.userList = new ArrayList<User>();
	}
	

	//Overloaded Constructor
	public MembershipPlan(int planId) {
		this.planId = planId;
	}



	//Parameterized Constructor
	public MembershipPlan(int planId, String planName, double planFee) {
		this.planId = planId;
		this.planName = planName;
		this.planFee = planFee;
	}

	
	//Getters and Setters
	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public double getPlanFee() {
		return planFee;
	}

	public void setPlanFee(double planFee) {
		this.planFee = planFee;
	}
	

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public void addUser(User u)
	{
		this.userList.add(u);
		u.setuPlan(this);
	}

	//toString
	@Override
	public String toString() {
		return "MembershipPlan [planId=" + planId + ", planName=" + planName + ", planFee=" + planFee + "]";
	}
	
}	
