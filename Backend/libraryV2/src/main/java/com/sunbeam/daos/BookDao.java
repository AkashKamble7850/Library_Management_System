package com.sunbeam.daos;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Book;




public interface BookDao extends JpaRepository<Book, Integer>{
	
	@Query("select count(bookid) from Book")
	Long countBook();
	
	
	Book findByIsbn(String isbn);

	@Modifying
    @Query("Update Book b SET b.quantity = b.quantity + ?2 WHERE bookId = ?1")
	int modifyQuantity(int bookId, int quantity);

	@Query(value = "select b.bookId as bookId, b.bookName as bookName, b.isbn as isbn, a.aFirstName as firstName, a.aLastName lastName, c.categoryName category, b.quantity quantity, (Select b.quantity - count(i.issueBookId) from issueBook i WHERE issueStatus=\"i\" AND i.bookId= b.bookId) as \"availableQuantity\" From Book b inner join author a on b.authorId = a.authorId inner join category c on b.categoryId = c.categoryId;", nativeQuery = true)
	List<Map<String, Object>> getAllBooks();

	@Query(value = "select b.bookId as bookId, b.bookName as bookName, b.isbn as isbn, a.aFirstName as firstName, a.aLastName lastName, c.categoryName category, b.quantity quantity, (Select b.quantity - count(i.issueBookId) from issueBook i WHERE issueStatus=\"i\" AND i.bookId= b.bookId) as \"availableQuantity\" From Book b inner join author a on b.authorId = a.authorId inner join category c on b.categoryId = c.categoryId where c.categoryName = ?;", nativeQuery = true)
	List<Map<String, Object>> getBookByCategory(String categoryName);

	@Query(value = "select b.bookId as bookId, b.bookName as bookName, b.isbn as isbn, a.aFirstName as firstName, a.aLastName lastName, c.categoryName category, b.quantity quantity, (Select b.quantity - count(i.issueBookId) from issueBook i WHERE issueStatus=\"i\" AND i.bookId= b.bookId) as \"availableQuantity\" From Book b inner join author a on b.authorId = a.authorId inner join category c on b.categoryId = c.categoryId where b.bookName = ?;", nativeQuery = true)
	List<Map<String, Object>> getBookByBookName(String bookName);

	@Query(value = "select b.bookId as bookId, b.bookName as bookName, b.isbn as isbn, a.aFirstName as firstName, a.aLastName lastName, c.categoryName category, b.quantity quantity, (Select b.quantity - count(i.issueBookId) from issueBook i WHERE issueStatus=\"i\" AND i.bookId= b.bookId) as \"availableQuantity\" From Book b inner join author a on b.authorId = a.authorId inner join category c on b.categoryId = c.categoryId where b.isbn = ?;", nativeQuery = true)
	List<Map<String, Object>> getBookByIsbn(String isbn);

	@Query(value = "select b.bookId as bookId, b.bookName as bookName, b.isbn as isbn, a.aFirstName as firstName, a.aLastName lastName, c.categoryName category, b.quantity quantity, (Select b.quantity - count(i.issueBookId) from issueBook i WHERE issueStatus=\"i\" AND i.bookId= b.bookId) as \"availableQuantity\" From Book b inner join author a on b.authorId = a.authorId inner join category c on b.categoryId = c.categoryId where b.bookId = ?;", nativeQuery = true)
	List<Map<String, Object>> getBooksByBookId(String bookId);

	@Query(value = "select b.bookId as bookId, b.bookName as bookName, b.isbn as isbn, a.aFirstName as firstName, a.aLastName lastName, c.categoryName category, b.quantity quantity, (Select b.quantity - count(i.issueBookId) from issueBook i WHERE issueStatus=\"i\" AND i.bookId= b.bookId) as \"availableQuantity\" From Book b inner join author a on b.authorId = a.authorId inner join category c on b.categoryId = c.categoryId where aFirstName = (select SUBSTR(?1,1,(LOCATE(' ',?2)-1)) as first) And aLastName = (select SUBSTR(?3,(LOCATE(' ',?4)+1)) as second);", nativeQuery = true)
	List<Map<String, Object>> getBooksByAuthorName(String authorName, String authorName2, String authorName3, String authorName4);

	@Query(value = "SELECT COUNT(issueBookId) FROM issueBook WHERE (issueStatus=\"I\" AND returnDate IS NULL) AND BOOKID=?", nativeQuery = true)
	int currentlyIssuedBooks(int bookId);


	@Query(value = "SELECT COUNT(userId) FROM user WHERE uStatus=1;", nativeQuery=true)
	Long countActiveUsers();

	


	


	
	
}
