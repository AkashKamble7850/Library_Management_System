package com.sunbeam.daos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.MembershipPlan;

@Repository
public interface MembershipPlanDao extends JpaRepository<MembershipPlan, Integer>{

	List<MembershipPlan> findAll();
	
	MembershipPlan findByPlanName(String planName);
	
	MembershipPlan findByplanId(int planId);
	
}
