package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.MembershipPlan;
import com.sunbeam.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	List<User> findAll();
	
	User findByuserId(int userId);
	
	User findByuEmail (String uEmail);
	
	List<User> findByuStatus(String uStatus);	
	
	List<User> findByuFirstName(String uFirstName);
	
	List<User> findByuLastName(String uLastName);
		
	@Query("SELECT COUNT(u) FROM User u WHERE u.uPlan=?1")
	long countUser(MembershipPlan uPlan);
	

}
