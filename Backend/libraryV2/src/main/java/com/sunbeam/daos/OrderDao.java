package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Orders;

@Repository
public interface OrderDao extends JpaRepository<Orders, Integer>
{
	
	
	public List<Orders> findAll();
	
	@Modifying
	@Query(value="delete from orders where orderId=?", nativeQuery =true)
	public int deleteByOrderId(int orderId);
	
		
	
		
	
//	public String delete(int orderId);
//	public String editOrders(int orderId);
	
//	public String orderBook(int orderId,String bookName,String authorName,int quantity,String language,int vendorId);
//	try save

	
}