package com.sunbeam.daos;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Fine;
import com.sunbeam.entities.IssueBook;

public interface IssueBookDao extends JpaRepository<IssueBook, Integer>{

	@Query(value = "SELECT COUNT(issueBookId) FROM issueBook WHERE ((issueStatus=\"I\" AND returnDate IS NULL) OR (issueStatus=\"RR\" AND returnDate IS NOT NULL) ) AND DATEDIFF((NOW()), dueDate)<0;", nativeQuery = true)
	int getIssueBookCount();

	@Query(value = "select count(issueBookId) from issueBook where (issueStatus=\"I\" AND returndate is null) and DATEDIFF((now()), dueDate)>0;", nativeQuery = true)
	int getDefaulterBooksCount();

	@Query(value = "SELECT i.issueBookId as issueBookId, b.bookId as bookId, bookName as bookName, u.uFirstName as firstName, u.uLastName as lastName, issueDate as issueDate, dueDate as dueDate, ReturnDate as returnDate, GREATEST(DATEDIFF(IFNULL(returndate, now()), duedate)*5, 0) as fine from issueBook i inner join Book b on b.bookid = i.bookid inner join user u on i.userId = u.userId where u.userId=?;", nativeQuery = true)
	List<Map<String, Object>> getFineOnUser(int userId);
	
	@Query(value = "SELECT b.bookId as bookId, bookName as bookName, u.uFirstName as firstName, u.uLastName as lastName, issueDate as issueDate, dueDate as dueDate, ReturnDate as returnDate, GREATEST(DATEDIFF(IFNULL(returndate, now()), duedate)*5, 0) as fine from issueBook i inner join Book b on b.bookid = i.bookid inner join user u on i.userId = u.userId where i.bookId=?;", nativeQuery = true)
	List<Map<String, Object>> getFineOnBook(int bookId);
	
	@Query(value = "SELECT b.bookId as bookId, bookName as bookName, u.uFirstName as firstName, u.uLastName as lastName, issueDate as issueDate, dueDate as dueDate, ReturnDate as returnDate, GREATEST(DATEDIFF(IFNULL(returndate, now()), duedate)*5, 0) as fine from issueBook i inner join Book b on b.bookid = i.bookid inner join user u on i.userId = u.userId;", nativeQuery = true)
	List<Map<String, Object>> getFineOnAllBooks();

	@Modifying
	@Query(value = "UPDATE fine SET fineStatus = \"Paid\" WHERE issueBookId = ?", nativeQuery = true)
	int payFineByIssueBookId(int issueBookId);

	@Query(value = "select i.issuebookid as issueBookId, b.bookid as bookId, b.bookname as BookName, u.userid as userId, u.ufirstname as firstName, u.uLastName as lastName, i.issuedate as issueDate, i.returndate as returnDate, i.issuestatus as issueStatus from issueBook i inner join Book b on b.bookid = i.bookid inner join user u on u.userid = i.userid where b.bookid = ?;", nativeQuery = true)
	List<Map<String, Object>> viewRecordByBookId(int bookId);

	@Query(value = "select i.issuebookid as issueBookId, b.bookid as bookId, b.bookname as BookName, u.userid as userId, u.ufirstname as firstName, u.uLastName as lastName, i.issuedate as issueDate, i.returndate as returnDate, i.issuestatus as issueStatus from issueBook i inner join Book b on b.bookid = i.bookid inner join user u on u.userid = i.userid where u.userId = ?;", nativeQuery = true)
	List<Map<String, Object>> viewRecordByUserId(int userId);

	@Query(value = "select i.issuebookid as issueBookId, b.bookid as bookId, b.bookname as BookName, u.userid as userId, u.ufirstname as firstName, u.uLastName as lastName, i.issuedate as issueDate, i.returndate as returnDate, i.issuestatus as issueStatus from issueBook i inner join Book b on b.bookid = i.bookid inner join user u on u.userid = i.userid where b.bookName = ?", nativeQuery = true)
	List<Map<String, Object>> viewRecordByBookName(String bookName);

	@Query(value = "select i.issuebookid as issueBookId, b.bookid as bookId, b.bookname as BookName, u.userid as userId, u.ufirstname as firstName, u.uLastName as lastName, i.issuedate as issueDate, i.returndate as returnDate, i.issuestatus as issueStatus from issueBook i inner join Book b on b.bookid = i.bookid inner join user u on u.userid = i.userid where u.uFirstName = (select SUBSTR(?,1,(LOCATE(' ',?)-1)) as first) And u.uLastName = (select SUBSTR(?,(LOCATE(' ',?)+1)) as second);", nativeQuery = true)
	List<Map<String, Object>> viewRecordByUserName(String userName, String userName2, String userName3, String userName4);

	@Query(value = "SELECT quantity - (SELECT COUNT(issueBookId) FROM issueBook WHERE (issueStatus=\"I\" AND returnDate IS NULL) AND issueBook.BOOKID=Book.bookId) FROM Book WHERE bookId = ?;", nativeQuery = true)
	int getAvailableQuantityOfBookByBookId(int bookId);

	@Query(value = "SELECT COUNT(issueBookId) FROM issueBook WHERE (userId = ?1 AND bookId = ?2) AND issueStatus = \"I\";", nativeQuery = true)
	int currentlyIssueBookByGivenBookId(int userId, int bookId);

	@Modifying
	@Query(value = "INSERT INTO issueBook (bookId, issueDate, issueStatus, userId) VALUES (?1, now(), \"IR\", ?2);", nativeQuery = true)
	int issueBookRequestByUser(int bookId, int userId);

	@Modifying
	@Query(value = "UPDATE issueBook SET issueStatus=\"I\", issuedate=now(), duedate=adddate(now(), 15), staffId = ?2 where issuebookid=?1 AND issueStatus=\"IR\";", nativeQuery = true)
	int approveRequestByStaff(int issueBookId, int staffId);

	@Modifying
	@Query(value = "delete from issueBook where issuebookid=? and issueStatus=\"IR\";", nativeQuery = true)
	int deleteRequestByStaff(int issueBookId);

	@Modifying
	@Query(value = "update issueBook set issueStatus=\"RR\", returnDate=now() where issuebookid=? AND issueStatus=\"I\";", nativeQuery = true)
	int getReturnRequest(int issueBookId);

	@Modifying
	@Query(value = "update issueBook set issueStatus=\"R\", staffId=?2 where issuebookid=?1 AND issueStatus=\"RR\";", nativeQuery = true) 
	int approveReturnRequestByStaff(int issueBookId, int staffId);

	@Modifying
	@Query(value = "update issueBook set issueStatus=\"I\", staffId = ?2 where issuebookid=?1 AND issueStatus=\"RR\";", nativeQuery = true)
	int rejectReturnRequestByStaff(int issueBookId, int staffId);
	
	
	@Query(value = "SELECT GREATEST(DATEDIFF(IFNULL(returndate, now()), duedate)*5, 0) from issueBook WHERE issueBookId=?;", nativeQuery = true)
	Integer GetFineByIssueBookId(int issueBookId);

	@Query(value = "SELECT DATEDIFF(NOW(), dueDate) FROM issueBook WHERE issueBookId=?", nativeQuery = true)
	int getDateDiff(int issueBookId);

	@Query(value = "select i.issuebookid as issueBookId, b.bookid as bookId, b.bookname as BookName, u.userid as userId, u.ufirstname as firstName, u.uLastName as lastName, i.issuedate as issueDate, i.returndate as returnDate, i.issuestatus as issueStatus from issueBook i inner join Book b on b.bookid = i.bookid inner join user u on u.userid = i.userid where i.issueStatus = 'IR';", nativeQuery = true)
	List<Map<String, Object>> viewIssueBookRequest();

	@Query(value = "select i.issuebookid as issueBookId, b.bookid as bookId, b.bookname as BookName, u.userid as userId, u.ufirstname as firstName, u.uLastName as lastName, i.issuedate as issueDate, i.returndate as returnDate, i.issuestatus as issueStatus from issueBook i inner join Book b on b.bookid = i.bookid inner join user u on u.userid = i.userid where i.issueStatus = 'RR';", nativeQuery = true)
	List<Map<String, Object>> viewReturnBookRequest();

	@Query(value = "select i.issuebookid as issueBookId, b.bookid as bookId, b.bookname as BookName, u.userid as userId, u.ufirstname as firstName, u.uLastName as lastName, i.issuedate as issueDate, i.returndate as returnDate, i.issuestatus as issueStatus from issueBook i inner join Book b on b.bookid = i.bookid inner join user u on u.userid = i.userid;", nativeQuery = true)
	List<Map<String, Object>> viewAllIssuedBooksRecord();

	@Query(value="SELECT bookName as bookName, COUNT(issueBookId) as count from issueBook i inner join Book b on b.bookId = i.bookId WHERE issueStatus=\"I\" OR issueStatus=\"IR\" GROUP BY i.bookId ORDER BY count DESC LIMIT 5;", nativeQuery=true)
	List<Map<String, Object>> issueBookGraph();


	@Query(value = "SELECT i.issueBookId as issueBookId, b.bookId as bookId, bookName as bookName, u.uFirstName as firstName, u.uLastName as lastName, issueDate as issueDate, dueDate as dueDate, ReturnDate as returnDate, GREATEST(DATEDIFF(IFNULL(returndate, now()), duedate)*5, 0) as fine from issueBook i inner join Book b on b.bookid = i.bookid inner join user u on i.userId = u.userId where i.issueBookId=?;", nativeQuery = true)
	List<Map<String, Object>> checkFineByIssueBookId(int issueBookId);


	
	
	
	
}
