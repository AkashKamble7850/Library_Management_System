package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "vendor")
public class Vendor 
{
	//added all params constr and also complete cat details in json of edit
	//but then it can add any rubbish categoryId and categoryName
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int vendorId;
	@NotEmpty
	private String vendorName;
	@NotEmpty
	private String vendorAddress;
	@NotEmpty 
	private String vendorContact;
	
	
	@JsonProperty("category")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categoryId", referencedColumnName = "categoryId")
	private Category category;
	
	//*****removed ignore here
	@JsonIgnore
	@OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL)
	private List<Orders> orders;
	
	public Vendor() {
		orders = new ArrayList<Orders>();
	}
	
	

	public Vendor(int vendorId, @NotEmpty String vendorName, @NotEmpty String vendorAddress,
			@NotEmpty String vendorContact) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorContact = vendorContact;
	}

//
//
//	public Vendor(int vendorId, @NotEmpty String vendorName, @NotEmpty String vendorAddress,
//			@NotEmpty String vendorContact) {
//		super();
//		this.vendorId = vendorId;
//		this.vendorName = vendorName;
//		this.vendorAddress = vendorAddress;
//		this.vendorContact = vendorContact;
//	}

	public Vendor(int vendorId) {
		this.vendorId=vendorId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorContact() {
		return vendorContact;
	}

	public void setVendorContact(String vendorContact) {
		this.vendorContact = vendorContact;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	public void setVendor(int vendorId)
	{
		this.vendorId=vendorId;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", vendorAddress=" + vendorAddress
				+ ", vendorContact=" + vendorContact + ", category=" + category + ", orders=" + orders + "]";
	}

	

	

	
	

}