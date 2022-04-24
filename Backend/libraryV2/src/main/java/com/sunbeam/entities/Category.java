package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class Category {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int categoryId;
	
	@NotNull
	private String categoryName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Book> bookList;

	@JsonIgnore
	@OneToOne(mappedBy = "category")
	private Vendor vendor;
	
	public Category() {
		this.bookList = new ArrayList<Book>();
	}

	public Category(int categoryId, @NotNull String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

	
	

	
	
}