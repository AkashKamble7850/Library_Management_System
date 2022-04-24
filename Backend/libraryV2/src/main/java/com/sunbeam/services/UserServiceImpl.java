package com.sunbeam.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.FeedbackDao;
import com.sunbeam.daos.MembershipPlanDao;
import com.sunbeam.daos.UserDao;
import com.sunbeam.dtos.DTOEntityConverter;
import com.sunbeam.dtos.PlanDTO;
import com.sunbeam.dtos.StaffDTO;
import com.sunbeam.dtos.UpdateUserDTO;
import com.sunbeam.dtos.UserDTO;
import com.sunbeam.entities.Feedback;
import com.sunbeam.entities.MembershipPlan;
import com.sunbeam.entities.Staff;
import com.sunbeam.entities.User;

@Transactional
@Service
public class UserServiceImpl {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MembershipPlanDao planDao;
	
	@Autowired
	private FeedbackDao fDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DTOEntityConverter converter;

	
	
	public List<MembershipPlan> findAllPlans()
	{
		return planDao.findAll();
	}
	
	public Map<String, Object> updateUser(int userId, UpdateUserDTO upDto)
	{
		User u = userDao.findByuserId(userId);
		if(userDao.existsById(userId))
		{
			upDto.setUserId(userId);
			upDto.setuEmail(u.getuEmail());
			User user = converter.toUserEntity(upDto);
			user.setuPlan(planDao.findByplanId(upDto.getuPlanId()));
			User userSave = userDao.save(user);
			
			System.out.println(userSave);
			
			return Collections.singletonMap("User Updated", 1);
		}
		
		return Collections.singletonMap("User does not exist", 0);

	}
	
	public Map<String, Object> deleteUser(int userId){

		if(userDao.existsById(userId)) {
			userDao.deleteById(userId);
		
		return Collections.singletonMap("User Deleted", 1);
		}

		return Collections.singletonMap("User does not exist", 0);
	}
	
	public Map<String, Object> addFeedback(int userId,Feedback feed)
	{
		feed.setUser(findUserByUserId(userId));
		
		Feedback feedSave =fDao.save(feed);
		
		return Collections.singletonMap("insertedId", feedSave.getFeedbackId());
	}

	public Map<String, Object> deleteFeedback(int feedId){

		if(fDao.existsById(feedId)) {
			fDao.deleteById(feedId);
		
		return Collections.singletonMap("Feedback Deleted", 1);
		}

		return Collections.singletonMap("Feedback does not exist", 0);
	}
	

	
	public User findUserByUserId(int userId)
	{
		User user = userDao.findByuserId(userId);
		return user;
	}
	
	public MembershipPlan findplanByPlanName(String planName)
	{
		return planDao.findByPlanName(planName);
	}



}
