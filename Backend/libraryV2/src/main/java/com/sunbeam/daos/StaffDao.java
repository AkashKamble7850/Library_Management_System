package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.dtos.StaffDTO;
import com.sunbeam.entities.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer> {
	
	Staff findBysEmail(String email);
	//@Modifying
	//@Query("select s.sEmail from Staff s where s.staffId = ?1")
	Staff findByStaffId(int staffId);
	@Modifying
	@Query(" Update Staff s set s.sSalaryStatus = ?1 where DAYOFMONTH(current_date()) = 28 or DAYOFMONTH(current_date()) > 28")
	int monthlyUpdate(boolean sSalaryStatus);
	@Modifying
	@Query("UPDATE Staff u SET u.sSalaryStatus = ?2 WHERE u.id = ?1")
	int updateSalary(int id, boolean sSalaryStatus);
	

}