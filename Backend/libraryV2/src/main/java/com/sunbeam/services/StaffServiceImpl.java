package com.sunbeam.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sunbeam.daos.StaffDao;
import com.sunbeam.dtos.DTOEntityConverter;
import com.sunbeam.dtos.StaffDTO;
import com.sunbeam.entities.Staff;

@Transactional
@Service
public class StaffServiceImpl {
	@Autowired
	private StaffDao staffDao;
	
	@Autowired
	private DTOEntityConverter converter;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//Add Staff
	public Map<String, Object> addStaff(StaffDTO staffdto) {
		//Converter StaffDto(Frontend object) into Staff(Database)
		Staff staff = converter.toStaffEntity(staffdto);
		System.out.println(staff);
		//set salary status = null, bcoz this will be updated by admin only
		Staff staffSave = staffDao.save(staff);
		return Collections.singletonMap("insertedId", staffSave.getStaffId());	
	}
	
//	Get	All Staff
	public List<StaffDTO> getAllStaff(){
		List<Staff> stafflist = staffDao.findAll();
		return stafflist.stream() //Collection od object
				.map(staff -> converter.toStaffDto(staff)) //map = result of given function
				.collect(Collectors.toList()); //return the result
	}
	
	//DisplayStaffProfile
	public StaffDTO displayProfile(int staffId){
		Staff staff = staffDao.findByStaffId(staffId);
		return converter.toStaffDto(staff);
	}
	
//	EditStaff
	public Map<String, Object> editstaff(int staffId, StaffDTO staffDto){
		//Staff exist, then update it
		if(staffDao.existsById(staffId)) {
			//set the Staffdto with id 
			staffDto.setStaffId(staffId);
			//Convert DTO into Staff Entity
			Staff staff = converter.toStaffEntity(staffDto);
			Staff staffSave = staffDao.save(staff);
			System.out.println(staffSave);
			return Collections.singletonMap("Staff updated", 1);
		}
		//if not exist, return zero updated rows
		return Collections.singletonMap("Staff does not exist", 0);
	}
	
//  Delete staff
	public Map<String, Object> deleteStaff(int staffId){

		//if Staff Member exists
		if(staffDao.existsById(staffId)) {
			staffDao.deleteById(staffId);
		return Collections.singletonMap("Staff Deleted", 1);
		}
		////if Staff Member does not exists
		return Collections.singletonMap("Staff does not exist", 0);
	}

//	toggleStaffSalary
	public int updateSalaryStatus(int staffId, boolean status){		
		//update Salary on 28 of every month to unpaid
		staffDao.monthlyUpdate(status);
		//recived request update salary to paid for id
		int result = staffDao.updateSalary(staffId, true);
		//send 
		return result;
	}

}
