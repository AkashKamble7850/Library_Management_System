package com.sunbeam.dtos;

import javax.validation.constraints.NotNull;

public class Credential {
	@NotNull
	private String email;
	@NotNull
	private String password;
	
	public Credential() {
	}
	
	//Constructor
	public Credential(@NotNull String email, @NotNull String password) {
		super();
		this.email = email;
		this.password = password;
	}

	//Getter and Setter
	public String getEmail() {
		return email;
	}

	public void setId(int id) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	//toString
	@Override
	public String toString() {
		return "Credential [email=" + email + ", password=" + password + "]";
	}
	
	
	

}
