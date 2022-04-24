package com.sunbeam.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.OrderDao;
import com.sunbeam.entities.Orders;
import com.sunbeam.entities.Vendor;

@Transactional
@Service
public class OrderServiceImpl {

	@Autowired
	private OrderDao orderDao;
	
	public List<Orders> getAllOrders()
	{
		return orderDao.findAll();
	}
	
	public Map<String, Object> addOrder(int vendorId, Orders order) 
	{
	
		
		System.out.println(vendorId);
//		vendorId is coming here in the request method args
//		set vendorId for that orderId
//		order.getVendor().setVendorId(vendorId);
		
		Vendor v = new Vendor(vendorId);
		order.setVendor(v);
		System.out.println(order);
		
		
		Orders orderSave = orderDao.save(order);
		
		return Collections.singletonMap("insertedId", orderSave.getOrderId());	
	}
	
//	EditOrder
	public Map<String, Object> editOrder(int orderId, Orders order)
	{
		//Staff exist, then update it
		if(orderDao.existsById(orderId)) 
		{
			//set the Staffdto with id 
			order.setOrderId(orderId);
			//Convert DTO into Staff Entity
			//Orders order = converter.toStaffEntity(staffDto);
			//save the Staff
			Orders orderSave = orderDao.save(order);
			System.out.println(orderSave);
			return Collections.singletonMap("Order updated", 1);
		}
		//if not exist, return zero updated rows
		return Collections.singletonMap("Order does not exist", 0);
	}
	
	
//  Delete Order
	public Map<String, Object> deleteOrder(int orderId){

		if(orderDao.existsById(orderId)) 
		{
			System.out.println(orderId);
			orderDao.deleteByOrderId(orderId);
		
		return Collections.singletonMap("order Deleted", 1);
		}

		return Collections.singletonMap("order does not exist", 0);
	}
	
	
	
}