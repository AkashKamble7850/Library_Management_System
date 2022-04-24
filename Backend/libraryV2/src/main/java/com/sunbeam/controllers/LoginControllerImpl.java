package com.sunbeam.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dtos.ApplicantDTO;
import com.sunbeam.dtos.Credential;
import com.sunbeam.dtos.Response;
import com.sunbeam.dtos.StaffDTO;
import com.sunbeam.dtos.UserDTO;
import com.sunbeam.entities.User;
import com.sunbeam.services.LoginServiceImpl;

@CrossOrigin("*")
@RestController
public class LoginControllerImpl {

	@Autowired
	public LoginServiceImpl loginService;

	//signin - for Existing user
	
//	@PostMapping("/signin/user") 
//	 public ResponseEntity<?> signIn(@Valid @RequestBody Credential cred){ 
//		 ApplicantDTO dto =loginService.findApplicantByEmailandPassword(cred); 
//		 if( dto == null ) {
//			 return Response.error("user not found"); 
//	 } 
//	return Response.success(dto); 
//	}
//	 
//	 //signin - for Existing Staff
//	 @PostMapping("/signin/staff") 
//	 public ResponseEntity<?> signin(@Valid @RequestBody Credential cred){ 
//		 StaffDTO dto = loginService.findStaffByEmailandPassword(cred); 
//		 if( dto == null ) { 
//			 return Response.error("Staff not found"); 
//			 } 
//	return Response.success(dto); }
	  
//	 @PostMapping("/signin/user") 
//	 public ResponseEntity<?> signIn(@Valid @RequestBody Credential cred){ 
//		 ApplicantDTO dto =loginService.findApplicantByEmailandPassword(cred); 
//		 if( dto == null ) {
//			 return Response.error("user not found"); 
//	 } 
//	return Response.success(dto); 
//	}
	 
	 //signin - for Existing Staff
	 @PostMapping("/signin") 
	 public ResponseEntity<?> signin(@Valid @RequestBody Credential cred){ 
		 StaffDTO staffDto = loginService.findStaffByEmailandPassword(cred); 
		 if( staffDto == null ) { 
			 ApplicantDTO dto =loginService.findApplicantByEmailandPassword(cred);
			 if( dto != null ) {
				 return Response.success(dto);
			 } 
		 }
		 else{
				 return Response.success(staffDto);
			 }
		return Response.error("user not found");
	 }
	 
	 
	// Signup - for adding new user only
	@PostMapping("/signup/{id}")
	public ResponseEntity<?> signUp(@Valid @RequestBody ApplicantDTO dto, @PathVariable("id") int planId) {
		ApplicantDTO result = loginService.saveApplicant(dto, planId);
		return Response.success(result);
	}

	/*
	// signin - for Existing Staff
	@PostMapping("/signin/staff")
	public ResponseEntity<?> signin(@Valid @RequestBody Credential cred) {
		//StaffDTO dto = loginService.findStaffByEmailandPassword(cred);
		Credential dto = loginService.findApplicantByIdandPassword(cred);
		if (dto == null) {
			return Response.error("Appliacnt not found");
		}
		return Response.success(dto);
	}
	*/

}
