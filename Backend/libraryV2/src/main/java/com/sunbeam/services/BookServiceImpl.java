package com.sunbeam.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.AuthorDao;
import com.sunbeam.daos.BookDao;
import com.sunbeam.daos.CategoryDao;
import com.sunbeam.dtos.BookDTO;
import com.sunbeam.dtos.DTOEntityConverter;
import com.sunbeam.dtos.StaffDTO;
import com.sunbeam.entities.Author;
import com.sunbeam.entities.Book;
import com.sunbeam.entities.Category;

@Transactional
@Service
public class BookServiceImpl {
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private AuthorDao authorDao;
	
	@Autowired
	private DTOEntityConverter converter;
	
	
	
	/*
		public List<BookDTO> getAllBooks() {
		
		List<Book> bookList =  bookDao.findAll();
		return bookList.stream() //Collection od object
				.map(book -> converter.toBookDto(book)) //map = result of given function
				.collect(Collectors.toList()); //return the result;
	}
	 */



public Long countBooks() {
	Long count = bookDao.countBook();
	return count;
}

public Map<String, Object> addBook(BookDTO bookDto) {
	Book book = bookDao.findByIsbn(bookDto.getIsbn());
	
	if(book == null) {
		Category category = categoryDao.findByCategoryName(bookDto.getCategoryName());
		Author author = authorDao.findByAFirstNameAndALastName(bookDto.getaFirstName(), bookDto.getaLastName());
		
		
		if(category == null) {
			category = new Category(0, bookDto.getCategoryName());
			categoryDao.save(category);
		}
		
		if(author == null) {
			author = new Author(0, bookDto.getaFirstName(), bookDto.getaLastName());
			authorDao.save(author);
		}
		
		
		Book b = new Book();
		b.setIsbn(bookDto.getIsbn());
		b.setBookName(bookDto.getBookName());
		b.setBookDescription(bookDto.getBookDescription());
		b.setCategory(category);
		b.setAuthor(author);
		b.setQuantity(bookDto.getQuantity());
		b.setLanguage(bookDto.getLanguage());
		b.setPublished(bookDto.getPublished());
		bookDao.save(b);
		
		
		
		return Collections.singletonMap("New book Added, BookId: ", b.getBookId());
	}
	else {
		int id = book.getBookId();
		int result = bookDao.modifyQuantity(id, bookDto.getQuantity());
		return Collections.singletonMap("Book quantity updated, BookId: ", book.getBookId());
	}
	
	
}

public Map<String, Object> deleteBook(int issueBookId) {
	if(bookDao.existsById(issueBookId)) {
		bookDao.deleteById(issueBookId);
		return Collections.singletonMap("Book Deleted", 1);
	}
	return Collections.singletonMap("affectedRows", 0); 
}


public Map<String, Integer> updateBookDetails(int bookId, BookDTO bookDto) {
	Optional<Book> book = bookDao.findById(bookId);
	if(book.isPresent()) {
	
		if(book.get().getIsbn() != bookDto.getIsbn())
			book.get().setIsbn(bookDto.getIsbn());
		
		if(book.get().getBookName() != bookDto.getBookName()) 
			book.get().setBookName(bookDto.getBookName());
		
		if((book.get().getAuthor().getAFirstName() != bookDto.getaFirstName()) && (book.get().getAuthor().getALastName() != bookDto.getaLastName()))
		{
			Author author = authorDao.findByAFirstNameAndALastName(bookDto.getaFirstName(), bookDto.getaLastName());
			if(author == null) {
				author = new Author(0, bookDto.getaFirstName(), bookDto.getaLastName());
				authorDao.save(author);
			}
			book.get().setAuthor(author);
		}
		
		if(book.get().getCategory().getCategoryName() != bookDto.getCategoryName()) {
			Category category = categoryDao.findByCategoryName(bookDto.getCategoryName());
			if(category == null) {
				category = new Category(0, bookDto.getCategoryName());
				categoryDao.save(category);
			}
			book.get().setCategory(category);
		}
		
		if(book.get().getBookDescription() != bookDto.getBookDescription())
			book.get().setBookDescription(bookDto.getBookDescription());
		
		if(book.get().getLanguage() != bookDto.getLanguage())
			book.get().setLanguage(bookDto.getLanguage());
		
		if(book.get().getPublished() != bookDto.getPublished())
			book.get().setPublished(bookDto.getPublished());
		
		if(book.get().getQuantity() != bookDto.getQuantity())
			book.get().setQuantity(bookDto.getQuantity());
		
		bookDao.save(book.get());
		
		return Collections.singletonMap("changedRows", 1);
		
		}
		else {
			return Collections.singletonMap("No record found of given id: ", bookId);
		}
		
	
}

public List<Map<String, Object>> getAllBooks() {
	
	List<Map<String, Object>> bookList = bookDao.getAllBooks();
	
	return bookList;
	
	
}

public List<Map<String, Object>> getBooksByCategory(String categoryName) {
	
	List<Map<String, Object>> bookList = bookDao.getBookByCategory(categoryName);
//	if(bookList.isEmpty()) {
//		return Collections.singletonMap("No books are available: ", null);
//	}
//	return Collections.singletonMap("List Of Books are: ", bookList);
	return bookList;
}

public List<Map<String, Object>> getBooksByBookName(String bookName) {
	
	List<Map<String, Object>> bookList = bookDao.getBookByBookName(bookName);
	
//	if(bookList.isEmpty()) {
//		return Collections.singletonMap("No books are available of given name: ", bookName);
//	}
//	return Collections.singletonMap("List Of Books are: ", bookList);
	return bookList;
}

public List<Map<String, Object>> getBooksByIsbn(String isbn) {

	List<Map<String, Object>> bookList = bookDao.getBookByIsbn(isbn);
//	if(bookList.isEmpty()) {
//		return Collections.singletonMap("No book is available of given name: ", isbn);
//	}
//	return Collections.singletonMap("Book is: ", bookList);
	return bookList;
}

public List<Map<String, Object>> getBooksByBookId(String bookId) {
	List<Map<String, Object>> bookList = bookDao.getBooksByBookId(bookId);
//	if(bookList.isEmpty()) {
//		return Collections.singletonMap("No book is available of given Book Id: ", bookId);
//	}
//	return Collections.singletonMap("Book is: ", bookList);
	return bookList;
}

public List<Map<String, Object>> getBooksByAuthorName(String authorName, String authorName2, String authorName3, String authorName4) {
	List<Map<String, Object>> bookList =  bookDao.getBooksByAuthorName(authorName, authorName2, authorName3, authorName4);
//	if(bookList.isEmpty()) {
//		return Collections.singletonMap("No book is available of given author name: ", authorName);
//	}
//	return Collections.singletonMap("Book is: ", bookList);
	return bookList;
}

public Map<String, Integer> removeQuantityOfBooks(int bookId, int qty) {
	Optional<Book> book = bookDao.findById(bookId);
	if(book.isPresent()) {
		int quant = book.get().getQuantity();
		int currentlyIssuedBooks = bookDao.currentlyIssuedBooks(bookId);
		int availableQuantityExceptCurrentlyIssuedBooks = quant - currentlyIssuedBooks;
		if(qty > availableQuantityExceptCurrentlyIssuedBooks) {
			return Collections.singletonMap("currently requested amount of books are not available", 0);
		}
		else {
				book.get().setQuantity(quant - qty);
				bookDao.save(book.get());
				return Collections.singletonMap("Book removed, Quantity updated", 1); 
		}
	}else {
		return Collections.singletonMap("Book is not available of current book Id", 0);
	}
	
}

public Long countActiveUsers() {
	Long count = bookDao.countActiveUsers();
	return count;
}




}
