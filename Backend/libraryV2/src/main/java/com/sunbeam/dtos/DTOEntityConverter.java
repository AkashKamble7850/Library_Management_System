package com.sunbeam.dtos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sunbeam.daos.MembershipPlanDao;
import com.sunbeam.entities.Feedback;
import com.sunbeam.entities.MembershipPlan;
import com.sunbeam.entities.Staff;
import com.sunbeam.entities.User;

@Component
public class DTOEntityConverter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MembershipPlanDao planDao;
	
	private String encrypt(String password) {
		return passwordEncoder.encode(password);
	}
	
	public Staff toStaffEntity(StaffDTO dto) {
		Staff entity = new Staff();
		entity.setStaffId(dto.getStaffId());
		entity.setsFirstName(dto.getFirstName());
		entity.setsLastName(dto.getLastName());
		entity.setsRole(dto.getRole());
		entity.setsGender(dto.getGender());
		entity.setsEmail(dto.getEmail());
		entity.setsPassword(passwordEncoder.encode(dto.getPassword()));
		entity.setsMobile(dto.getMobile());
		entity.setsAddress(dto.getAddress());
		entity.setsDateOfJoining(dto.getDateOfJoining());
		return entity;
	}

	public StaffDTO toStaffDto(Staff entity) {
		StaffDTO dto = new StaffDTO();
		dto.setStaffId(entity.getStaffId());
		dto.setFirstName(entity.getsFirstName());
		dto.setLastName(entity.getsLastName());
		dto.setRole(entity.getsRole());
		dto.setGender(entity.getsGender());
		dto.setEmail(entity.getsEmail());
		dto.setPassword(entity.getsPassword());
		dto.setMobile(entity.getsMobile());
		dto.setAddress(entity.getsAddress());
		dto.setDateOfJoining(entity.getsDateOfJoining());
		return dto;
	}
	
	public ApplicantDTO toApplicantDto(User entity) {
		ApplicantDTO dto = new ApplicantDTO();
		dto.setId(entity.getUserId());
		dto.setFirstName(entity.getuFirstName());
		dto.setLastName(entity.getuLastName());
		dto.setEmail(entity.getuEmail());
		dto.setPassword(entity.getuPassword());
		dto.setMobile(entity.getuMobile());
		dto.setAddress(entity.getuAddress());
		dto.setRegisterDate(entity.getuRegisterDate());
		dto.setEducation(entity.getuEducation());
		dto.setIntrest(entity.getuIntrest());
		dto.setPlan(entity.getuPlan());
		return dto;
		
	}
	
	public User toApplicantEntity(ApplicantDTO dto) {
		User entity = new User();
		entity.setUserId(dto.getId());
		entity.setuFirstName(dto.getFirstName());
		entity.setuLastName(dto.getLastName());
		entity.setuEmail(dto.getEmail());
		entity.setuPassword(passwordEncoder.encode(dto.getPassword()));
		entity.setuMobile(dto.getMobile());
		entity.setuAddress(dto.getAddress());
		entity.setuRegisterDate(dto.getRegisterDate());
		entity.setuEducation(dto.getEducation());
		entity.setuIntrest(dto.getIntrest());
		entity.setuPlan(dto.getPlan());
		return entity;
	}
	
	public PlanDTO toPlanDto(MembershipPlan plan)
	{
		if(plan == null)
			return null;
		
		PlanDTO pDto = new PlanDTO();
		
		BeanUtils.copyProperties(plan, pDto);
		
		return pDto;
	}
	
	public MembershipPlan toPlanEntity(PlanDTO pDto)
	{
		MembershipPlan plan = new MembershipPlan();
		
		BeanUtils.copyProperties(pDto, plan);
		
		return plan;
	}
	
	public User toUserEntity(UserDTO uDto)
	{
		User user = new User();
		BeanUtils.copyProperties(uDto, user);
		
		if(uDto.getuPlan() != null)
			user.setuPlan(toPlanEntity(uDto.getuPlan()));
		
		user.setuPassword(encrypt(uDto.getuPassword()));
		return user;
	}

	public UserDTO toUserDto(User user, boolean deepCopy)
	{
		if(user == null)
			return null;
		
		UserDTO uDto = new UserDTO();

		BeanUtils.copyProperties(user, uDto);
		if(deepCopy)
			uDto.setuPlan(toPlanDto(user.getuPlan()));
		
		uDto.setuPassword(encrypt(user.getuPassword()));
		return uDto;

	}
	
	public User toUserEntity(UpdateUserDTO upDto)
	{
		User user = new User();
		BeanUtils.copyProperties(upDto, user);
		
		user.setuPassword(encrypt(upDto.getuPassword()));
		user.setuPlan(planDao.findByplanId(upDto.getuPlanId()));
		return user;
	}
	
	public UpdateUserDTO toUpdatedUserDto(User user)
	{
		UpdateUserDTO upDto = new UpdateUserDTO();
		BeanUtils.copyProperties(user, upDto);
		
		return upDto;
	}
	
}
