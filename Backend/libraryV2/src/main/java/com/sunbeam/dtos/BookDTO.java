package com.sunbeam.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class BookDTO {
	
	
	@NotNull
	private String bookName;
	
	@NotNull
	@Column(unique = true)
	private String isbn;
	
	private String aFirstName;
	private String aLastName;
	
	@NotNull
	private String categoryName;
	
	@NotNull
	private String bookDescription;
	
	private String language;
	
	@NotNull
	private int published;
	
	private int quantity;
	
	public BookDTO() {
		
	}


	public BookDTO(@NotNull String bookName, @NotNull String isbn, String aFirstName, String aLastName,
			String categoryName, @NotNull String bookDescription, String language, @NotNull int published,
			int quantity) {
		super();
		this.bookName = bookName;
		this.isbn = isbn;
		this.aFirstName = aFirstName;
		this.aLastName = aLastName;
		this.categoryName = categoryName;
		this.bookDescription = bookDescription;
		this.language = language;
		this.published = published;
		this.quantity = quantity;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getaFirstName() {
		return aFirstName;
	}


	public void setaFirstName(String aFirstName) {
		this.aFirstName = aFirstName;
	}


	public String getaLastName() {
		return aLastName;
	}


	public void setaLastName(String aLastName) {
		this.aLastName = aLastName;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getBookDescription() {
		return bookDescription;
	}


	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
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


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "BookDTO [bookName=" + bookName + ", isbn=" + isbn + ", aFirstName=" + aFirstName + ", aLastName="
				+ aLastName + ", categoryName=" + categoryName + ", bookDescription=" + bookDescription + ", language="
				+ language + ", published=" + published + ", quantity=" + quantity + "]";
	}
	
	
}

