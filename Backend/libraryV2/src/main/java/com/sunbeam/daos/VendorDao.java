package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Vendor;

@Repository
public interface VendorDao extends JpaRepository<Vendor, Integer>
{
	
	
	public List<Vendor> findAll();
	

	Vendor findByVendorId(int vendorId);
	
	@Modifying
	@Query(value="delete from vendor where vendorId=?", nativeQuery =true)
	public int deleteByVendorId(int vendorId);
	
//	@Modifying
//	@Query(value="update vendor setVendorName=? where vendorId=?", nativeQuery =true)
//	public int updateByVendorId(int vendorId);
	

	
//	public String delete(int vendorId);
//	public String editOrders(int vendorId);
	
//	public String addVendor(int orderId,String bookName,String authorName,int quantity,String language,int vendorId);
//	try save

	
}