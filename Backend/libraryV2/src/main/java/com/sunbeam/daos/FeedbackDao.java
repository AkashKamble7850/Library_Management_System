package com.sunbeam.daos;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Feedback;
import com.sunbeam.entities.User;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

	List<Feedback> findAll();
	
	@Query("SELECT f.feedback FROM Feedback f WHERE f.user=?1")
	List<String> findFeedByUserId(User user);
}
