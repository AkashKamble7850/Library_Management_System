package com.sunbeam.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dtos.Response;
import com.sunbeam.dtos.StaffDTO;
import com.sunbeam.services.StaffServiceImpl;

@CrossOrigin("*")
@RestController
public class StaffControllerImpl {
	@Autowired 
	private StaffServiceImpl staffService;
	
//	AddStaff
	@PostMapping("/staff/add")
	public ResponseEntity<?> addStaff(@Valid @RequestBody StaffDTO staffDto){
		Map<String, Object> map = staffService.addStaff(staffDto);
		return Response.success(map) ;
	}
	
//	Get All Staff
	@GetMapping("/staff")
	public ResponseEntity<?> getAllStaff(){
		List<StaffDTO> result = staffService.getAllStaff();
		return Response.success(result);
	}
	
	///DisplayStaffProfile
	@GetMapping("/staff/{id}")
	public ResponseEntity<?> displayProfile(@PathVariable("id") int staffId){
		StaffDTO result = staffService.displayProfile(staffId);
		return Response.success(result);
	}
	
// Edit Staff
	@PutMapping("/staff/{id}")
	public ResponseEntity<?> editStaff(@PathVariable("id") int staffId, @Valid @RequestBody StaffDTO dto){
		Map<String, Object> result =staffService.editstaff(staffId, dto);
		return Response.success(result);
	}
	
//	DeleteStaff
	@DeleteMapping("/staff/{id}")
	public ResponseEntity<?> deleteStaff(@PathVariable("id") int staffId){
		Map<String, Object> result =staffService.deleteStaff(staffId);
		return Response.success(result);
	}

//	UpdateStaffSalary
	@PutMapping("/staff/salary/{id}")
	public ResponseEntity<?> updateSalaryStatus(@PathVariable("id") int staffId,@RequestParam(required = false) boolean status){
		int result =staffService.updateSalaryStatus(staffId,status);
		return Response.success(result);
	}
	
//	Admin_IM_Communication	
}
