package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "orders")
public class Orders 
{
	//added all params constr and also complete cat details in json of edit
	//but then it can add any rubbish categoryId and categoryName

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int orderId;
	@NotNull
	private String bookName;
	@NotEmpty
	private String aFirstName;
	@NotNull
	private int quantity;
	@NotNull
	private String language;

	@JsonProperty("vendor")
	@ManyToOne
	@JoinColumn(name="vendorId",nullable = false)
	private Vendor vendor;
	
	public Orders() {
	}
	
	

	public Orders(int orderId, @NotNull String bookName, @NotEmpty String aFirstName, @NotNull int quantity,
			@NotNull String language, Vendor vendor) {
		super();
		this.orderId = orderId;
		this.bookName = bookName;
		this.aFirstName = aFirstName;
		this.quantity = quantity;
		this.language = language;
		this.vendor = vendor;
	}


//
//	public Orders(int orderId, @NotNull String bookName, @NotEmpty String aFirstName, @NotNull int quantity,
//			@NotNull String language) {
//		super();
//		this.orderId = orderId;
//		this.bookName = bookName;
//		this.aFirstName = aFirstName;
//		this.quantity = quantity;
//		this.language = language;
//	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getaFirstName() {
		return aFirstName;
	}

	public void setaFirstName(String aFirstName) {
		this.aFirstName = aFirstName;
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

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", bookName=" + bookName + ", aFirstName=" + aFirstName + ", quantity="
				+ quantity + ", language=" + language + ", vendor=" + vendor + "]";
	}
	
	
	
		
}