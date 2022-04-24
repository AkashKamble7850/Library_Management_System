package com.sunbeam.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.MembershipPlanDao;
import com.sunbeam.daos.StaffDao;
import com.sunbeam.daos.UserDao;
import com.sunbeam.dtos.ApplicantDTO;
import com.sunbeam.dtos.Credential;
import com.sunbeam.dtos.DTOEntityConverter;
import com.sunbeam.dtos.StaffDTO;
import com.sunbeam.entities.Staff;
import com.sunbeam.entities.User;


@Transactional
@Service
public class LoginServiceImpl {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MembershipPlanDao planDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DTOEntityConverter converter;
	
	@Autowired
	private StaffDao staffDao;
	
	
	public ApplicantDTO findByEmail(String email) {
		User applicant = userDao.findByuEmail(email);
		return converter.toApplicantDto(applicant);
	}

	public ApplicantDTO findApplicantByEmailandPassword(Credential cred) {
		User dbapplicant = userDao.findByuEmail(cred.getEmail());
		String rawPassword = cred.getPassword();
		if(dbapplicant != null && passwordEncoder.matches(rawPassword, dbapplicant.getuPassword())){
			ApplicantDTO result = converter.toApplicantDto(dbapplicant);
			result.setPassword("*********");
			return result;
		}
		return null;	
	}

	//----------------------Staff signup -------------------------------//
	public StaffDTO findStaffByEmail(String email) {
		Staff staff = staffDao.findBysEmail(email);
		return converter.toStaffDto(staff);
	}
	
	public StaffDTO findStaffByEmailandPassword(Credential cred) {
		Staff dbstaff = staffDao.findBysEmail(cred.getEmail());
		String rawPassword = cred.getPassword();
		if(dbstaff != null && passwordEncoder.matches(rawPassword, dbstaff.getsPassword())){
			StaffDTO result = converter.toStaffDto(dbstaff);
			result.setPassword("*********");
			return result;
		}
		return null;	
		//Navigation of Staff as per Role will be done in Forntend
	}
	/*
	//----------------------signup by using Id-------------------------------//
	public ApplicantDTO findUserById(int id) {
		User applicant = loginDao.findByuserId(id);
		return converter.toApplicantDto(applicant);
	}
	
	public StaffDTO findStaffById(int staffId) {
		Staff staff = staffDao.findBystaffId(staffId);
		return converter.toStaffDto(staff);
	}
	
	
	public Credential findApplicantByIdandPassword(Credential cred) {
//		if(cred.getId() > 200 && cred.getId() <= 300) {//for signin done by staff
		if(staffDao.findBystaffId(cred.getId()) != null){
			Staff dbstaff = staffDao.findBystaffId(cred.getId());
			String rawPassword = cred.getPassword();
			if(dbstaff != null && passwordEncoder.matches(rawPassword, dbstaff.getPassword())){
				Credential result = converter.toCredentialDto(dbstaff);
				result.setPassword("*********");
				return result;
			}
			return null;	
			//Navigation of Staff as per Role will be done in Forntend
		}
		else {////for signin done by user
			User dbuser = loginDao.findByuserId(cred.getId());
			String rawPassword = cred.getPassword();
			if(dbuser != null && passwordEncoder.matches(rawPassword, dbuser.getuPassword())){
				Credential result = converter.toCredentialDto(dbuser);
				result.setPassword("*********");
				return result;
			}
			return null;
		}
	
	}
	*/
	//-------------------------------Sign up -----------------------------//
	//Add new User
	public ApplicantDTO saveApplicant( ApplicantDTO dto,int planId ) {
//		String rawPassword = dto.getPassword();
		//String encPassword = passwordEncoder.encode(rawPassword);
		dto.setPlan(planDao.findByplanId(planId));
		User user = converter.toApplicantEntity(dto);
		user = userDao.save(user);
		dto = converter.toApplicantDto(user);
//		dto.setRegisterDate();
		dto.setPassword("**********");
		return dto;
	}

}
