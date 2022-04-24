package com.sunbeam.controllers;


import java.util.Collections;
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

import com.sunbeam.dtos.BookDTO;
import com.sunbeam.dtos.Response;
import com.sunbeam.dtos.StaffDTO;
import com.sunbeam.entities.Book;
import com.sunbeam.services.BookServiceImpl;

@RequestMapping("/books")
@CrossOrigin("*")
@RestController
public class BookControllerImpl {

	@Autowired
	private BookServiceImpl bookService;
	
	
	
	@GetMapping("")
	public ResponseEntity<?> countBooks(){
		Long result = bookService.countBooks();
		return Response.success(result);
	}
	
	@GetMapping("/countActiveUsers")
	public ResponseEntity<?> countActiveUsers(){
		Long result = bookService.countActiveUsers();
		return Response.success(result);
	}
	
		
	@PostMapping("/add")
	public ResponseEntity<?> addBook(@RequestBody BookDTO bookDto){
		Map<String, Object> result = bookService.addBook(bookDto);
		return Response.success(result);
	}
	
	@DeleteMapping("/delete/{issueBookId}")
	public ResponseEntity<?> deleteBook(@PathVariable("issueBookId") int issueBookId){
		Map<String, Object> result = bookService.deleteBook(issueBookId);
		return Response.success(result);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBookDetails(@PathVariable("id") int bookId,@RequestBody BookDTO bookDto){
		Map<String, Integer> result =bookService.updateBookDetails(bookId, bookDto);
		return Response.success(result);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllBooks(){
		List<Map<String, Object>> bookList = bookService.getAllBooks();
		if(bookList.isEmpty()) {
			Map<String, Object> result = Collections.singletonMap("No books are available: ", null);
			return Response.error(result);
		}else {
			//Map<String, Object> result = Collections.singletonMap("List Of Books are: ", bookList);
			return Response.success(bookList);
		}
		
	}
	
	@GetMapping("/category/{categoryName}")
	public ResponseEntity<?> getBooksByCategory(@PathVariable("categoryName") String categoryName){
		List<Map<String, Object>> result = bookService.getBooksByCategory(categoryName);
		return Response.success(result);
	}
	
	@GetMapping("/isbn/{isbn}")
	public ResponseEntity<?> getBooksByIsbn(@PathVariable("isbn") String isbn){
		List<Map<String, Object>> result = bookService.getBooksByIsbn(isbn);
		return Response.success(result);
	}
	
	@GetMapping("/bookName/{bookName}")
	public ResponseEntity<?> getBooksByBookName(@PathVariable("bookName") String bookName){
		List<Map<String, Object>> result = bookService.getBooksByBookName(bookName);
		return Response.success(result);
	}
	
	@GetMapping("/bookId/{bookId}")
	public ResponseEntity<?> getBooksByBookId(@PathVariable("bookId") String bookId){
		List<Map<String, Object>> result = bookService.getBooksByBookId(bookId);
		return Response.success(result);
	}
	
	@GetMapping("/authorName/{authorName}")
	public ResponseEntity<?> getBooksByAuthorName(@PathVariable("authorName") String authorName){
		List<Map<String, Object>> result = bookService.getBooksByAuthorName(authorName, authorName, authorName, authorName);
		return Response.success(result);
	}
	
	@PutMapping("removeQuantityOfBooks/{bookId}/{qty}")
	public ResponseEntity<?> removeQuantityOfBooks(@PathVariable("bookId") int bookId,@PathVariable("qty") int qty){
		Map<String, Integer> result = bookService.removeQuantityOfBooks(bookId, qty);
		return Response.success(result);
	}
}
