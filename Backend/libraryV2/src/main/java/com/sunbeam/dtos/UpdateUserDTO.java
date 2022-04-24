package com.sunbeam.dtos;

import java.util.Date;

import com.sunbeam.entities.MembershipPlan;

public class UpdateUserDTO {

	private int userId;

	private String uFirstName;
	
	private String 	uLastName;
	
	private String 	uEmail;
	
	private String uMobile;

	private String uPassword;
	
	private String uAddress;
	
	private Date uRegisterDate;

	private String uEducation;
	
	private String uIntrest;
	
	private int uPlanId;
	
	public UpdateUserDTO() {
		
	}


	public UpdateUserDTO(int userId, String uFirstName, String uLastName, String uEmail, String uMobile,
			String uPassword, String uAddress, Date uRegisterDate, String uEducation, String uIntrest) {
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
	}


	public UpdateUserDTO(int userId, String uFirstName, String uLastName, String uEmail, String uMobile,
			String uPassword, String uAddress, Date uRegisterDate, String uEducation, String uIntrest, int uPlanId) {
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
		this.uPlanId = uPlanId;
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

	public String getuMobile() {
		return uMobile;
	}

	public void setuMobile(String uMobile) {
		this.uMobile = uMobile;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
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


	public String getuEmail() {
		return uEmail;
	}


	public Date getuRegisterDate() {
		return uRegisterDate;
	}


	
	public int getuPlanId() {
		return uPlanId;
	}


	public void setuPlanId(int uPlanId) {
		this.uPlanId = uPlanId;
	}


	
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}


	@Override
	public String toString() {
		return "UpdateUserDTO [userId=" + userId + ", uFirstName=" + uFirstName + ", uLastName=" + uLastName
				+ ", uEmail=" + uEmail + ", uMobile=" + uMobile + ", uPassword=" + uPassword + ", uAddress=" + uAddress
				+ ", uRegisterDate=" + uRegisterDate + ", uEducation=" + uEducation + ", uIntrest=" + uIntrest
				+ ", uPlanId=" + uPlanId + "]";
	}



}
