package com.sunbeam.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.sunbeam.daos.FeedbackDao;
import com.sunbeam.daos.MembershipPlanDao;
import com.sunbeam.daos.UserDao;
import com.sunbeam.dtos.DTOEntityConverter;
import com.sunbeam.dtos.PlanDTO;
import com.sunbeam.dtos.StaffDTO;
import com.sunbeam.dtos.UserDTO;
import com.sunbeam.entities.Feedback;
import com.sunbeam.entities.MembershipPlan;
import com.sunbeam.entities.Staff;
import com.sunbeam.entities.User;

@Transactional
@Service
public class AdminServiceImpl {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MembershipPlanDao planDao;
	
	@Autowired
	private FeedbackDao fDao;

	@Autowired
	private DTOEntityConverter converter;

	public List<User> findAllUsers()
	{
		return userDao.findAll();
	}
	
	public User findUserByUserId(int userId)
	{
		return userDao.findByuserId(userId);
	}
	
	
	public User findUserByUEmail(String uEmail)
	{
		User user = userDao.findByuEmail(uEmail);
		return user;
	}

	public List<User> findUsersByUFirstName(String uFirstName)
	{
		return userDao.findByuFirstName(uFirstName);
	}
	
	public List<User> findUsersByULastName(String uLastName)
	{
		return userDao.findByuLastName(uLastName);
	}
	
	public HashSet<User> findUsersByUFirstNameAndULastName(String uFirstName,String uLastName)
	{
		List<User> users = new ArrayList<User>();
		users.addAll(findUsersByUFirstName(uFirstName));
		users.addAll(findUsersByULastName(uLastName));
		
		HashSet<User> hSet = new HashSet<User>(users);
		
		return hSet;
	}
	
	public List<User> findUserByUStatus(String uStatus)
	{
		return userDao.findByuStatus(uStatus);
	}

	public Map<Integer, Object> updateUserStatus(int userId)
	{
		User u = userDao.findByuserId(userId);
		if(!(u.isuStatus()))
			u.setuStatus(true);
		
		
		return Collections.singletonMap(u.getUserId(), u.isuStatus() );
	}
	
	
	public Map <String, Object> addplan (PlanDTO pDto)
	{
		MembershipPlan plan = converter.toPlanEntity(pDto);
		System.out.println(plan);
		
		MembershipPlan planSave = planDao.save(plan);
		
		return Collections.singletonMap("insertedPlanId", planSave.getPlanId());	
		
	}

	public Map<String, Object> updatePlan(int planId, PlanDTO pDto) {
		
		if(planDao.existsById(planId)) 
		{
			pDto.setPlanId(planId);
			
			MembershipPlan plan = converter.toPlanEntity(pDto);

			MembershipPlan planSave = planDao.save(plan);

			System.out.println(planSave);
			
			return Collections.singletonMap("Plan Updated", 1);
		}

		return Collections.singletonMap("Plan does not exist", 0);
	}
	
	public Map<String, Object> deletePlan(int planId){

		if(planDao.existsById(planId)) {
			planDao.deleteById(planId);
		
		return Collections.singletonMap("Plan Deleted", 1);
		}

		return Collections.singletonMap("Plan does not exist", 0);
	}


	public long countUsersUnderPlan (int planId)
	{
		if(planDao.existsById(planId))
		{
			MembershipPlan uPlan = planDao.findByplanId(planId);
			return userDao.countUser(uPlan);				
		}
		
		return 0;
	}
	
	public List<Feedback> showAllFeed()
	{
		return fDao.findAll();
	}
	
	public List<String> findFeedbackByUserId(int userId)
	{
	
		List<String> list = new ArrayList<String>();
		
		if(userDao.existsById(userId))
		{
			User u = userDao.findByuserId(userId);
			list.addAll(fDao.findFeedByUserId(u));
		}
		
		return list;
	}
	
	
}
