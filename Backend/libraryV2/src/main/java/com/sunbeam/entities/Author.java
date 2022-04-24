package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "author")
public class Author 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int authorId;
	@NotEmpty
	private String AFirstName;
	@NotEmpty 
	private String ALastName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
	private List<Book> books;
	
	public Author() 
	{
		books = new ArrayList<>();
	}

	public Author(int authorId, @NotEmpty String aFirstName, @NotEmpty String aLastName) {
		super();
		this.authorId = authorId;
		AFirstName = aFirstName;
		ALastName = aLastName;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAFirstName() {
		return AFirstName;
	}

	public void setAFirstName(String aFirstName) {
		AFirstName = aFirstName;
	}

	public String getALastName() {
		return ALastName;
	}

	public void setALastName(String aLastName) {
		ALastName = aLastName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", AFirstName=" + AFirstName + ", ALastName=" + ALastName + ", books="
				+ books + "]";
	}

		
}
