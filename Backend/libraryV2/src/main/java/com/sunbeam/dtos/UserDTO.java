package com.sunbeam.dtos;

import javax.validation.constraints.NotNull;

import com.sunbeam.entities.MembershipPlan;

public class UserDTO {

	private int userId;
	
	private String uFirstName;
	
	private String 	uLastName;

	private String uEmail;
	
	private String uMobile;

	private String uPassword;
	
	private String uAddress;

	private PlanDTO uPlan;
	
	private boolean uStatus;

	public UserDTO() {
		
	}



	
	public UserDTO(int userId, String uFirstName, String uLastName, String uEmail, String uMobile, String uPassword,
			String uAddress, PlanDTO uPlan) {
		super();
		this.userId = userId;
		this.uFirstName = uFirstName;
		this.uLastName = uLastName;
		this.uEmail = uEmail;
		this.uMobile = uMobile;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
		this.uPlan = uPlan;
	}




	public UserDTO(String uFirstName, String uLastName, String uEmail, String uMobile, String uPassword,
			String uAddress, PlanDTO uPlan) {
		this.uFirstName = uFirstName;
		this.uLastName = uLastName;
		this.uEmail = uEmail;
		this.uMobile = uMobile;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
		this.uPlan = uPlan;
	}


	public UserDTO(int userId, String uFirstName, String uLastName, String uEmail, String uMobile, String uPassword,
			String uAddress, PlanDTO uPlan, boolean uStatus) {
		super();
		this.userId = userId;
		this.uFirstName = uFirstName;
		this.uLastName = uLastName;
		this.uEmail = uEmail;
		this.uMobile = uMobile;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
		this.uPlan = uPlan;
		this.uStatus = uStatus;
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

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public PlanDTO getuPlan() {
		return uPlan;
	}

	public void setuPlan(PlanDTO planDTO) {
		this.uPlan = planDTO;
	}

	
	public String getuPassword() {
		return uPassword;
	}


	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}


	public boolean isuStatus() {
		return uStatus;
	}




	public void setuStatus(boolean uStatus) {
		this.uStatus = uStatus;
	}




	@Override
	public String toString() {
		return "UserDTO [uFirstName=" + uFirstName + ", uLastName=" + uLastName + ", uEmail=" + uEmail + ", uMobile="
				+ uMobile + ", uPassword=" + uPassword + ", uAddress=" + uAddress + ", uPlan=" + uPlan + "]";
	}



	
}
