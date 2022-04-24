package com.sunbeam.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sunbeam.daos.FeedbackDao;
import com.sunbeam.daos.MembershipPlanDao;
import com.sunbeam.daos.UserDao;
import com.sunbeam.entities.Feedback;
import com.sunbeam.entities.MembershipPlan;
import com.sunbeam.entities.User;

@Component
public class DbInit {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MembershipPlanDao planDao;
	
	@Autowired
	private FeedbackDao fDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private List<User> userList;
	
	private List<MembershipPlan> planList;
	
	private List<Feedback> feedbackList;
	
	private String encrypt(String password) {
		return passwordEncoder.encode(password);
	}
	
	@SuppressWarnings("deprecation")
	public static Date date(int year, int month, int day) {
		return new Date(year-1900, month-1, day);
	}

	private List<MembershipPlan> planList()
	{
		List<MembershipPlan> planList = new ArrayList<MembershipPlan>();
		planList.add(new MembershipPlan(1,"One Month",500));
		planList.add(new MembershipPlan(2,"Three Months",1400));
		planList.add(new MembershipPlan(3,"Six Months",2600));
		planList.add(new MembershipPlan(4,"One Year",5000));
		
		return planList;
	}
	
	private List<User> userList() {
		User u;
		List<User> users = new ArrayList<>();
		
		u = new User(101, "Akash", "Kamble", "abc@test.com", "9876543210", encrypt("9876543210"), 
					"Solapur","BE", "Biography");
		u.setuPlan(planDao.findByPlanName("One Month"));		
		users.add(u);

		u = new User(102, "Abhishek", "Deshmukh", "pqr@test.com", "0123456789", encrypt("0123456789"), 
				"Pune","ME", "Anime");
		u.setuPlan(planDao.findByPlanName("Three Months"));		
		users.add(u);

		u = new User(103, "Neha", "Jumde", "xyz@test.com", "7894561230", encrypt("7894561230"), 
			"Dhule", "BE", "Language");
		u.setuPlan(planDao.findByPlanName("Six Months"));		
		users.add(u);

		u = new User(104, "Vivek", "Ikhar", "lmn@test.com", "4567891230", encrypt("4567891230"), 
				"Nagpur", "ME", "Novel");
		u.setuPlan(planDao.findByPlanName("One Year"));		
		users.add(u);
	
		return users;
	}

	private List<Feedback> feedbackList(){
		Feedback f;
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		
		f = new Feedback(11,"Online issue book system is awesome");
		f.setUser(userDao.findByuEmail("abc@test.com"));
		feedbacks.add(f);

		f = new Feedback(12,"Great experience");
		f.setUser(userDao.findByuEmail("pqr@test.com"));
		feedbacks.add(f);

		f = new Feedback(13,"Faced issues while returning book");
		f.setUser(userDao.findByuEmail("xyz@test.com"));
		feedbacks.add(f);

		f = new Feedback(14,"Very simple to access library functions");
		f.setUser(userDao.findByuEmail("lmn@test.com"));
		feedbacks.add(f);
		
		return feedbacks;
	}
	
	@PostConstruct
	public void init() {
	}
	
	public void initDatabase() {

		this.planList = planList();
		planList.forEach(m -> planDao.save(m));
		
		this.userList = userList();
		userList.forEach(u -> userDao.save(u));
		
		
		this.feedbackList = feedbackList();
		feedbackList.forEach(f -> fDao.save(f));
	}

	public List<User> getUserList() {
		return userList;
	}

	public List<MembershipPlan> getPlanList() {
		return planList;
	}

	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}

	
}
