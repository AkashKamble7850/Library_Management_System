package com.sunbeam.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dtos.DTOEntityConverter;
import com.sunbeam.dtos.PlanDTO;
import com.sunbeam.dtos.Response;
import com.sunbeam.dtos.UpdateUserDTO;
import com.sunbeam.dtos.UserDTO;
import com.sunbeam.entities.Feedback;
import com.sunbeam.entities.MembershipPlan;
import com.sunbeam.entities.User;
import com.sunbeam.services.UserServiceImpl;
import com.sunbeam.validations.UserExistsValidatorImpl;

@CrossOrigin("*")
@RequestMapping("/user")
@RestController
public class UserControllerImpl {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private DTOEntityConverter dtoEntityConverter;
	
	@Autowired
	private UserExistsValidatorImpl userValidator;
	

	
	@GetMapping("/getplans")
	public ResponseEntity<?> planList()
	{
		List <MembershipPlan> list = userService.findAllPlans();
		
		Stream<PlanDTO> result = list.stream().map(ar -> dtoEntityConverter.toPlanDto(ar));
		
		return Response.success(result);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> editUser(@PathVariable("id") int userId, @Valid @RequestBody UpdateUserDTO upDto)
	{
		Map<String, Object> map = userService.updateUser(userId, upDto);
		if(map.containsValue(1))
			return Response.success(map);
		else
			return Response.error(map);
	}

	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int userId){
		
		Map<String, Object> map =userService.deleteUser(userId);
		if(map.containsValue(1))
			return Response.success(map);
		else
			return Response.error(map);
	}

	@PostMapping("/addfeedback/{id}")
	public ResponseEntity<?> addFeedback(@PathVariable("id") int userId,@Valid @RequestBody Feedback feed)
	{
		Map<String, Object> result = userService.addFeedback(userId, feed);
		return Response.success(result);
	}
	
	@DeleteMapping("/deletefeedback/{id}")
	public ResponseEntity<?> deleteFeedback(@PathVariable("id") int feedId){
		
		Map<String, Object> map =userService.deleteFeedback(feedId);
		if(map.containsValue(1))
			return Response.success(map);
		else
			return Response.error(map);
	}

}
