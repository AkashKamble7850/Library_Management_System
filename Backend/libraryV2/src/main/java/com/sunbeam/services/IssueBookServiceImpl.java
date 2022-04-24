package com.sunbeam.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.AuthorDao;
import com.sunbeam.daos.BookDao;
import com.sunbeam.daos.CategoryDao;
import com.sunbeam.daos.FineDao;
import com.sunbeam.daos.IssueBookDao;
import com.sunbeam.daos.UserDao;
import com.sunbeam.dtos.DTOEntityConverter;
import com.sunbeam.dtos.IssueBookDTO;
import com.sunbeam.entities.Book;
import com.sunbeam.entities.Fine;
import com.sunbeam.entities.IssueBook;
import com.sunbeam.entities.User;

@Transactional
@Service
public class IssueBookServiceImpl {
	
	@Autowired
	private IssueBookDao issueBookDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private FineDao fineDao;
	
	@Autowired
	private BookDao bookDao;
	
	
	public int getIssueBooksCount() {
		int result = issueBookDao.getIssueBookCount();
		return result;
		//return Collections.singletonMap("No. of Issue books: ", result);
	}

	public int getDefaulterBooksCount() {
		int result = issueBookDao.getDefaulterBooksCount();
		return result;
		//return Collections.singletonMap("No. of defaulter books: ", result);
	}

	public List<Map<String, Object>> getFineOnUser(int userId) {
//		Optional<User> user = userDao.findById(userId);
//		if(user.isPresent()) {
			List<Map<String, Object>> result = issueBookDao.getFineOnUser(userId);
//			if(result.isEmpty()) {
				//return Collections.singletonMap("User didn't issue any book: ", userId);
//				return null;
//			}
			//return Collections.singletonMap("Fine on books of given user id: ", result);
			return result;
//		}//else {
			//return Collections.singletonMap("user doesn't exist of given Id: ", userId);
//		return null;
			
		//}
		
	}
	
	public List<Map<String, Object>> getFineOnBook(int bookId) {
		Optional<Book> book = bookDao.findById(bookId);
		if(book.isPresent()) {
			List<Map<String, Object>> result = issueBookDao.getFineOnBook(bookId);
			if(result.isEmpty()) {
				//return Collections.singletonMap("User didn't issue any book: ", userId);
				return null;
			}
			//return Collections.singletonMap("Fine on books of given user id: ", result);
			return result;
		}//else {
			//return Collections.singletonMap("book doesn't exist of given Id: ", bookId);
		return null;
			
		//}
		
	}
	
	
	public List<Map<String, Object>> getFineOnAllBooks() {
		
			List<Map<String, Object>> result = issueBookDao.getFineOnAllBooks();
			if(result.isEmpty()) {
				//return Collections.singletonMap("User didn't issue any book: ", userId);
				return null;
			}
			//return Collections.singletonMap("Fine on books of given user id: ", result);
			return result;		
	}

	public Map<String, Object> payFineByIssueBookId(int issueBookId) {
		Optional<IssueBook> issueBook = issueBookDao.findById(issueBookId);
		if(issueBook.isPresent()) {
			int result = issueBookDao.payFineByIssueBookId(issueBookId);
			return Collections.singletonMap("Fine paid on books of given book id: ", result);
		}
		else {
			return Collections.singletonMap("Row doesn't exist in IssueBook of Id: ", issueBookId);
		}
		
	}

	public List<Map<String, Object>> viewRecordByBookId(int bookId) {
		List<Map<String, Object>> result = issueBookDao.viewRecordByBookId(bookId);
		return result;
//		if(result.isEmpty())
//			return Collections.singletonMap("Records of books doesn't exist of given book id: ", bookId);
//		return Collections.singletonMap("Records of books of given book id: ", result);
	}

	public List<Map<String, Object>> viewRecordByUserId(int userId) {
		List<Map<String, Object>> result = issueBookDao.viewRecordByUserId(userId);
//		if(result.isEmpty())
//			return Collections.singletonMap("Records of books doesn't exist of given user id: ", userId);
//		return Collections.singletonMap("Records of books of given user id: ", result);
		return result;
	}

	public List<Map<String, Object>> viewRecordByBookName(String bookName) {
		List<Map<String, Object>> result = issueBookDao.viewRecordByBookName(bookName);
//		if(result.isEmpty())
//			return Collections.singletonMap("Records of books doesn't exist of given user name: ", bookName);
//		return Collections.singletonMap("Records of books of given book name: ", result);
		return result;
	}

	public List<Map<String, Object>> viewRecordByUserName(String userName, String userName2, String userName3, String userName4) {
		List<Map<String, Object>> result = issueBookDao.viewRecordByUserName(userName, userName2, userName3, userName4);
//		if(result.isEmpty())
//			return Collections.singletonMap("Records of books doesn't exist of given user name: ", userName);
//		return Collections.singletonMap("Records of books of given user name: ", result);
		return result;
	}

	

	public Map<String, Object> issueRequestFromUser(IssueBookDTO issueBookDto) {
		
		Optional<User> user = userDao.findById(issueBookDto.getUserId());
		Optional<Book> book = bookDao.findById(issueBookDto.getBookId());
		
		if(book.isPresent()) {
			if(user.isPresent()) {
				//Condition 1: Check for user membership status
				if(user.get().isuStatus()) {
					
					int quant = issueBookDao.getAvailableQuantityOfBookByBookId(issueBookDto.getBookId());
					//Condition 2: Check for quantity of available books
					if(quant == 0) {
						return Collections.singletonMap("Book is not available", 0);
					}
					
					//to check currently issue book by given id
					int currentlyIssueBookByGivenBookId = issueBookDao.currentlyIssueBookByGivenBookId(issueBookDto.getUserId(), issueBookDto.getBookId());
					//Condition 3: It should not give the book which is currently issued by given id
					if(currentlyIssueBookByGivenBookId > 0) {
						return Collections.singletonMap("You have currently issued same book", 0);
					}
					
					int issueBookRequestByUser = issueBookDao.issueBookRequestByUser(issueBookDto.getBookId(), issueBookDto.getUserId());
					return Collections.singletonMap("Request Send", issueBookRequestByUser);
					
				}
				else {
					return Collections.singletonMap("You Dont have active membership plan", 0);
				}
			}
			return Collections.singletonMap("Invalid User Id!!", 0);
		}
		else {
			return Collections.singletonMap("Invalid Book Id!!", 0);
		}
		
		
	}

	
	public Map<String, Object> approveRequestByStaff(IssueBookDTO issueBookDto) {
		Optional<User> user = userDao.findById(issueBookDto.getUserId());
		Optional<Book> book = bookDao.findById(issueBookDto.getBookId());
		
		if(book.isPresent()) {
			if(user.isPresent()) {
				//Condition 1: Check for user membership status
				if(user.get().isuStatus()) {
					
					int quant = issueBookDao.getAvailableQuantityOfBookByBookId(issueBookDto.getBookId());
					//Condition 2: Check for quantity of available books
					if(quant == 0) {
						return Collections.singletonMap("Book is not available", 0);
					}
					
					//to check currently issue book by given id
					int currentlyIssueBookByGivenBookId = issueBookDao.currentlyIssueBookByGivenBookId(issueBookDto.getUserId(), issueBookDto.getBookId());
					//Condition 3: It should not give the book which is currently issued by given id
					if(currentlyIssueBookByGivenBookId > 0) {
						return Collections.singletonMap("You have currently issued same book", 0);
					}
					
					int result = issueBookDao.approveRequestByStaff(issueBookDto.getIssueBookId(), issueBookDto.getStaffId());
					if(result==1)
						return Collections.singletonMap("Request Approved", 1);
					return Collections.singletonMap("Request is not approved", 0);
					
				}
				else {
					return Collections.singletonMap("You Dont have active membership plan", 0);
				}
			}
			return Collections.singletonMap("Invalid User Id!!", 0);
		}
		else {
			return Collections.singletonMap("Invalid Book Id!!", 0);
		}
		/*int result = issueBookDao.approveRequestByStaff(issueBookId, staffId);
		if(result==1)
			return Collections.singletonMap("Request Approved", 1);
		return Collections.singletonMap("Request is not approved", 0);*/
	}

	public Map<String, Object> deleteRequestByStaff(int issueBookId) {
		int result = issueBookDao.deleteRequestByStaff(issueBookId);
		if(result==1)
			return Collections.singletonMap("Request Rejected!!!", 1);
		return Collections.singletonMap("Request is not approved", 0);
	}

	public Map<String, Object> getReturnRequest(int issueBookId) {
		
		IssueBook issueBook = issueBookDao.getById(issueBookId);
		Fine fine = fineDao.findByBook(issueBook);
		
		if(fine != null) {
			if(fine.getFineStatus().equals("Paid") || fine.getFineStatus().equals("NA")) {
				int result = issueBookDao.getReturnRequest(issueBookId);
				if(result==1)
					return Collections.singletonMap("Requested for return", 1);
				return Collections.singletonMap("Request not yet updated", 0);
			}
			else {
				return Collections.singletonMap("You havn't paid the fine", 0);
			}
		}
		else {
			int result = issueBookDao.getReturnRequest(issueBookId);
			return Collections.singletonMap("Requested for return", 1);
		}
		
	}

	public Map<String, Object> approveReturnRequestByStaff(int issueBookId, int staffId) {
		int result = issueBookDao.approveReturnRequestByStaff(issueBookId, staffId);
		if(result==1)
			return Collections.singletonMap("Request approved, Book returned", 1);
		return Collections.singletonMap("Request is not approved", 0);
	}

	public Map<String, Object> rejectReturnRequestByStaff(int issueBookId, int staffId) {
		int result = issueBookDao.rejectReturnRequestByStaff(issueBookId, staffId);
		if(result==1)
			return Collections.singletonMap("Return request rejected", 1);
		return Collections.singletonMap("Opration not done", 0);
	}

	public Map<String, Object> addFineTableRows(int issueBookId) {
				
		Optional<IssueBook> issueBook = issueBookDao.findById(issueBookId);
		if(issueBook.isPresent()) {
			if(issueBook.get().getReturnDate() == null) {
				int getDateDiff = issueBookDao.getDateDiff(issueBook.get().getIssueBookId());
				if(getDateDiff > 0) {
					Fine fine = fineDao.findByBook(issueBook.get());
					
					if(fine == null) {
						fineDao.addFineTableRows(issueBookId);
					}else {
							fine.setFineStatus("UNPAID");
					}
				}
			}else {
				return Collections.singletonMap("You have already paid the fine", 0);
			}
		}
		else {
			return Collections.singletonMap("IssueBookId doesn't exists", 0);
		}
		return null;
	}

	public List<Map<String, Object>> viewIssueBookRequest() {
		List<Map<String, Object>> issueBookRequest = issueBookDao.viewIssueBookRequest();
		//return Collections.singletonMap("List of issue book request", issueBookRequest);
		return issueBookRequest;
	}

	public List<Map<String, Object>> viewReturnBookRequest() {
		List<Map<String, Object>> returnBookRequest = issueBookDao.viewReturnBookRequest();
		//return Collections.singletonMap("List of issue book request", issueBookRequest);
		return returnBookRequest;
	}

	public List<Map<String, Object>> viewAllIssuedBooksRecord() {
		List<Map<String, Object>> allBookRecord = issueBookDao.viewAllIssuedBooksRecord();
		return allBookRecord;
	}


	public int checkFineStatusByIssueBookId(int issueBookId) {
		Optional<IssueBook> issueBook = issueBookDao.findById(issueBookId);
		if(issueBook.isPresent()) {
			Fine fine = fineDao.findByBook(issueBook.get());
			if(fine != null) {
				if(fine.getFineStatus().equals("PAID")) {
					return 1;
				}else {
					return 0;
				}
			}
			return 1;
		}else {
			return 0;
		}
		
	}

	public List<Map<String, Object>> checkFineByIssueBookId(int issueBookId) {
		
			List<Map<String, Object>> result = issueBookDao.checkFineByIssueBookId(issueBookId);
			return result;
	}

	

}
