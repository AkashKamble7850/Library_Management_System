//package com.sunbeam.services;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.sunbeam.daos.StaffDao;
//import com.sunbeam.dtos.StaffDTO;
//
//@SpringBootTest
//public class StaffServiceImplTest {
//	@Autowired
//	private StaffDao staffDao;
//	
//	@Autowired
//	private StaffServiceImpl staffService;
//	
////	@Rollback(false)
////	@Transactional
////	@Test
////	void testSave() {
////		
////		try {
////			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////			Date date;
////			date = sdf.parse("2021-11-10");
////			Staff staff = new Staff(0, "rekha", "Raut", "admin", "female", "rekha@gmail.com", "rekharaut", "1234567890", "nagpur", date, "paid");
////			Staff savedStaff = staffDao.save(staff);
////			System.out.println(savedStaff);
////			assertNotEquals(0, savedStaff.getStaffId());
////		} catch (ParseException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////	}
//	
////	@Test
////	void testaddStaff(Staff staff) {
////		try {
////			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////			Date date;
////			date = sdf.parse("2021-11-10");
////			staff = new Staff(0, "rekha", "Raut", "admin", "female", "rekha@gmail.com", "rekharaut", "1234567890", "nagpur", date, "paid");
////			Staff savedStaff = staffDao.save(staff);
////			System.out.println(savedStaff);
////			assertNotEquals(0, savedStaff.getStaffId());
////			staff = staffService.addStaff(savedStaff);
////			System.out.println("Found: " + staff);
////			assertNotNull(staff);
////		} catch (ParseException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
////	}
//	@Test
//	void testgetAllStaff() {
//		List<StaffDTO> staff = staffService.getAllStaff();
//		assertNotNull(staff);
//	}
//}
