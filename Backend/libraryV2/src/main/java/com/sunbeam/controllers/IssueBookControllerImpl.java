package com.sunbeam.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.daos.AuthorDao;
import com.sunbeam.daos.BookDao;
import com.sunbeam.daos.CategoryDao;
import com.sunbeam.dtos.BookDTO;
import com.sunbeam.dtos.DTOEntityConverter;
import com.sunbeam.dtos.IssueBookDTO;
import com.sunbeam.dtos.Response;
import com.sunbeam.services.IssueBookServiceImpl;

@RequestMapping("/issueBooks")
@CrossOrigin("*")
@RestController
public class IssueBookControllerImpl {
	
	@Autowired
	IssueBookServiceImpl issueBookService;
	
	@GetMapping("")
	public ResponseEntity<?> getIssueBooksCount(){
		int result = issueBookService.getIssueBooksCount();
		return Response.success(result);
	}
	
	@GetMapping("/defaulterBook")
	public ResponseEntity<?> getDefaulterBooksCount(){
		int result = issueBookService.getDefaulterBooksCount();
		return Response.success(result);
	}
	
	
	@GetMapping("/checkFineByUserId/{userId}")
	public ResponseEntity<?> getFineOnUser(@PathVariable("userId") int userId){
		List<Map<String, Object>> result = issueBookService.getFineOnUser(userId);
		return Response.success(result);
	}
	
	@GetMapping("/checkFine")
	public ResponseEntity<?> getFineOnAllBooks(){
		List<Map<String, Object>> result = issueBookService.getFineOnAllBooks();
		return Response.success(result);
	}
	
	@GetMapping("/checkFineByBookId/{bookId}")
	public ResponseEntity<?> getFineOnBookByBookId(@PathVariable("bookId") int bookId){
		List<Map<String, Object>> result = issueBookService.getFineOnBook(bookId);
		return Response.success(result);
	}
	
	
	@GetMapping("/payFine/{issueBookId}")
	public ResponseEntity<?> payFineByIssueBookId(@PathVariable("issueBookId") int issueBookId){
		Map<String, Object> result = issueBookService.payFineByIssueBookId(issueBookId);
		return Response.success(result);
	}
	
	@GetMapping("/viewRecordByBookId/{bookId}")
	public ResponseEntity<?> viewRecordByBookId(@PathVariable("bookId") int bookId){
		List<Map<String, Object>> result = issueBookService.viewRecordByBookId(bookId);
		return Response.success(result);
	}
	
	
	@GetMapping("/viewRecordByUserId/{userId}")
	public ResponseEntity<?> viewRecordByUserId(@PathVariable("userId") int userId){
		List<Map<String, Object>> result = issueBookService.viewRecordByUserId(userId);
		return Response.success(result);
	}
	
	
	@GetMapping("/viewRecordByBookName/{bookName}")
	public ResponseEntity<?> viewRecordByBookName(@PathVariable("bookName") String bookName){
		List<Map<String, Object>> result = issueBookService.viewRecordByBookName(bookName);
		return Response.success(result);
	}
	
	
	@GetMapping("/viewRecordByUserName/{userName}")
	public ResponseEntity<?> viewRecordByUserName(@PathVariable("userName") String userName){
		List<Map<String, Object>> result = issueBookService.viewRecordByUserName(userName, userName, userName, userName);
		return Response.success(result);
	}
	
	@PostMapping("/issueRequestFromUser")
	public ResponseEntity<?> issueRequestFromUser(@RequestBody IssueBookDTO issueBookDto){
		Map<String, Object> result = issueBookService.issueRequestFromUser(issueBookDto);
		if(result.containsValue(0)) {
			return Response.error(result);
		}
		return Response.success(result);
	}
	
	@PutMapping("/approveRequestByStaff")
	public ResponseEntity<?> approveRequestByStaff(@RequestBody IssueBookDTO issueBookDto){
		Map<String, Object> result = issueBookService.approveRequestByStaff(issueBookDto);
		if(result.containsValue(0)) {
			return Response.error(result);
		}
		return Response.success(result);
	}
	
	@DeleteMapping("/deleteRequestByStaff/{issueBookId}")
	public ResponseEntity<?> deleteRequestByStaff(@PathVariable("issueBookId") int issueBookId){
		Map<String, Object> result = issueBookService.deleteRequestByStaff(issueBookId);
		if(result.containsValue(0)) {
			return Response.error(result);
		}
		return Response.success(result);
	}
	
	@PutMapping("/getReturnRequest/{issueBookId}")
	public ResponseEntity<?> getReturnRequest(@PathVariable("issueBookId") int issueBookId){
		Map<String, Object> result = issueBookService.getReturnRequest(issueBookId);
		if(result.containsValue(0)) {
			return Response.error(result);
		}
		return Response.success(result);
	}
	
	
	@PutMapping("/approveReturnRequestByStaff/{issueBookId}/{staffId}")
	public ResponseEntity<?> approveReturnRequestByStaff(@PathVariable("issueBookId") int issueBookId, @PathVariable("staffId") int staffId){
		Map<String, Object> result = issueBookService.approveReturnRequestByStaff(issueBookId, staffId);
		if(result.containsValue(0)) {
			return Response.error(result);
		}
		return Response.success(result);
	}
	
	
	@PutMapping("/rejectReturnRequestByStaff/{issueBookId}/{staffId}")
	public ResponseEntity<?> rejectReturnRequestByStaff(@PathVariable("issueBookId") int issueBookId, @PathVariable("staffId") int staffId){
		Map<String, Object> result = issueBookService.rejectReturnRequestByStaff(issueBookId, staffId);
		if(result.containsValue(0)) {
			return Response.error(result);
		}
		return Response.success(result);
	}
	
	@PostMapping("/addFineTableRows/{issueBookId}")
	public ResponseEntity<?> addFineTableRows(@PathVariable("issueBookId") int issueBookId){
		Map<String, Object> result = issueBookService.addFineTableRows(issueBookId);
		return Response.success(result);
	}
	
	@GetMapping("/viewIssueBookRequest")
	public ResponseEntity<?> viewIssueBookRequest(){
		List<Map<String, Object>> result = issueBookService.viewIssueBookRequest();
		return Response.success(result);
	}
	
	
	@GetMapping("/viewReturnBookRequest")
	public ResponseEntity<?> viewReturnBookRequest(){
		List<Map<String, Object>> result = issueBookService.viewReturnBookRequest();
		return Response.success(result);
	}
	
	@GetMapping("/viewAllIssuedBooksRecord")
	public ResponseEntity<?> viewAllIssuedBooksRecord(){
		List<Map<String, Object>> result = issueBookService.viewAllIssuedBooksRecord();
		return Response.success(result);
	}
	
	
	@GetMapping("/checkFineStatusByIssueBookId/{issueBookId}")
	public ResponseEntity<?> checkFineStatusByIssueBookId(@PathVariable("issueBookId") int issueBookId){
		int result = issueBookService.checkFineStatusByIssueBookId(issueBookId);
		if(result ==  1) {
			return Response.success(result);
		}else {
			return Response.error(result);
		}
		
	}
	
	@GetMapping("/checkFineByIssueBookId/{IssueBookId}")
	public ResponseEntity<?> checkFineByIssueBookId(@PathVariable("IssueBookId") int IssueBookId){
		List<Map<String, Object>> result = issueBookService.checkFineByIssueBookId(IssueBookId);
		return Response.success(result);
	}
	
	
	
	
	
}
