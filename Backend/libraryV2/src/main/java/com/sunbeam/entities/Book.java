package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "book")
public class Book {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int bookId;
	
	@Column(unique = true)
	@NotNull
	private String isbn;
	
	@NotNull
	private String bookName;
	
	
	private String bookDescription;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "authorId", nullable = false)
	private Author author;
	
	private int quantity;
	
	private String language;
	
	@NotNull
	private int published;
	
	
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private List<IssueBook> book;
	
	
	public Book() {
		book = new ArrayList<>();
	}


	public Book(int bookId, @NotNull String isbn, @NotNull String bookName, String bookDescription, int quantity,
			String language, @NotNull int published, List<IssueBook> book) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.quantity = quantity;
		this.language = language;
		this.published = published;
		this.book = book;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookDescription() {
		return bookDescription;
	}


	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public int getPublished() {
		return published;
	}


	public void setPublished(int published) {
		this.published = published;
	}


	public List<IssueBook> getBook() {
		return book;
	}


	public void setBook(List<IssueBook> book) {
		this.book = book;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", isbn=" + isbn + ", bookName=" + bookName + ", bookDescription="
				+ bookDescription + ", category=" + category + ", author=" + author + ", quantity=" + quantity
				+ ", language=" + language + ", published=" + published + ", book=" + book + "]";
	}

	
}
