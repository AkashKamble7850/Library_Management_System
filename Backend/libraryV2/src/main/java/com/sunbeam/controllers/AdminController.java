package com.sunbeam.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.daos.UserDao;
import com.sunbeam.dtos.DTOEntityConverter;
import com.sunbeam.dtos.PlanDTO;
import com.sunbeam.dtos.Response;
import com.sunbeam.dtos.UserDTO;
import com.sunbeam.entities.Feedback;
import com.sunbeam.entities.MembershipPlan;
import com.sunbeam.entities.User;
import com.sunbeam.services.AdminServiceImpl;
import com.sunbeam.services.UserServiceImpl;
import com.sunbeam.util.DbInit;

@CrossOrigin
@RequestMapping("/admin")
@RestController
public class AdminController {

	@Autowired
	private DbInit dbInit;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private AdminServiceImpl adminService;

	@Autowired
	private DTOEntityConverter dtoEntityConverter;

	
	@GetMapping("/init/sampledb")
	public ResponseEntity<?>initSampleDb()
	{
		if(!userDao.findAll().isEmpty())
			throw new RuntimeException("Database already initialized.");
		
		dbInit.initDatabase();
		HashMap<String, Object> result = new HashMap<>();
		result.put("plans", dbInit.getPlanList().size());
		result.put("users", dbInit.getUserList().size());
		result.put("feedbacks", dbInit.getFeedbackList().size());
	
		return Response.success(result);
	}
	
	@ExceptionHandler
	public ResponseEntity<?> handleException(Exception ex) {
		return Response.error(ex);
	}
	
	@GetMapping("/getusers")
	public ResponseEntity<?> userList()
	{
		List<User> list = adminService.findAllUsers();
		Stream<UserDTO> result = list.stream().map(ar -> dtoEntityConverter.toUserDto(ar,true));
		
		return Response.success(result);
	}
	
	@GetMapping("/getusersbyid/{id}")
	public ResponseEntity<?> usersById(@PathVariable("id") int userId)
	{
		User user = adminService.findUserByUserId(userId);
		if(user != null)
			return Response.success(user);
		
		return Response.error(user);			
	}
	
	@GetMapping("/getusersbyemail/{uEmail}")
	public ResponseEntity<?> usersByEmail(@PathVariable("uEmail") String uEmail)
	{
		User user = adminService.findUserByUEmail(uEmail);
		if(user != null)
			return Response.success(user);
		
		return Response.error(user);			
	}

	@GetMapping("/getusersbyfirstname/{uFirstName}")
	public ResponseEntity<?> usersByFirstName(@PathVariable("uFirstName") String uFirstName)
	{
		List<User> users = adminService.findUsersByUFirstName(uFirstName);
		if(users != null)
			return Response.success(users);
		
		return Response.error(users);			
	}
	
	@GetMapping("/getusersbylastname/{uLastName}")
	public ResponseEntity<?> usersByLastName(@PathVariable("uLastName") String uLastName)
	{
		List<User> users = adminService.findUsersByULastName(uLastName);
		if(users != null)
			return Response.success(users);
		
		return Response.error(users);			
	}

	@GetMapping("/getusersbyfirstnameandlastname/{uFirstName}/{uLastName}")
	public ResponseEntity<?> usersByFirstNameAndLastName(@PathVariable("uLastName") String uFirstName, @PathVariable("uLastName") String uLastName)
	{
		HashSet<User> uSet = adminService.findUsersByUFirstNameAndULastName(uFirstName, uLastName);
		if(uSet != null)
			return Response.success(uSet);
		
		return Response.error(uSet);			
	}

	@PatchMapping("/updateuserstatus/{id}")
	public ResponseEntity<?> updateUserStatus(@PathVariable("id") int userId)
	{
		Map<Integer, Object> map = adminService.updateUserStatus(userId);
		if(map.containsValue(true))
			return Response.success(map);
		else
			return Response.error(map);
	}
	
	@GetMapping("/getplans")
	public ResponseEntity<?> planList()
	{
		List <MembershipPlan> list = userService.findAllPlans();
		
		Stream<PlanDTO> result = list.stream().map(ar -> dtoEntityConverter.toPlanDto(ar));
		
		return Response.success(result);
	}

	
	@PostMapping("/addplan")
	public ResponseEntity<?> addplan (@Valid @RequestBody PlanDTO pDto)
	{
		Map<String, Object> map = adminService.addplan(pDto);
		return Response.success(map);
	}
	
	@PatchMapping("/updateplan/{id}")
	public ResponseEntity<?> editPlan(@PathVariable("id") int planId, @Valid @RequestBody PlanDTO pDto)
	{
		Map<String, Object> map = adminService.updatePlan(planId, pDto);
		if(map.containsValue(1))
			return Response.success(map);
		else
			return Response.error(map);
	}
	
	@DeleteMapping("/deleteplan/{id}")
	public ResponseEntity<?> deletePlan(@PathVariable("id") int planId){
		
		Map<String, Object> map =adminService.deletePlan(planId);
		
		if(map.containsValue(1))
			return Response.success(map);
		else
			return Response.error(map);
	}
	
	@GetMapping("/getcount/{id}")
	public ResponseEntity<?> getCount(@PathVariable("id") int planId)
	{
		long count = adminService.countUsersUnderPlan(planId);
	
		return Response.success(count);
	}

	@GetMapping("/getfeed")
	public ResponseEntity<?> feedList()
	{
		List <Feedback> list = adminService.showAllFeed();
				
		return Response.success(list);
	}

	@GetMapping("getfeedbackbyuser/{id}")
	public ResponseEntity<?> getFeedbackByUserId(@PathVariable ("id") int userId)
	{
		List<String> list = adminService.findFeedbackByUserId(userId);
		
		return Response.success(list);
		
	}
}
