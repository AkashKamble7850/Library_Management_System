package com.sunbeam.dtos;

import javax.validation.constraints.NotNull;

public class PlanDTO {

	private int planId;
	
	private String planName;
	
	private double planFee;

	public PlanDTO() {
	}


	public PlanDTO(int planId, String planName, double planFee) {
		this.planId = planId;
		this.planName = planName;
		this.planFee = planFee;
	}


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


	@Override
	public String toString() {
		return "PlanDTO [planId=" + planId + ", planName=" + planName + ", planFee=" + planFee + "]";
	}	

}
