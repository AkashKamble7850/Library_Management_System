package com.sunbeam.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dtos.Response;
import com.sunbeam.entities.Author;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Orders;
import com.sunbeam.entities.Vendor;
import com.sunbeam.services.OrderServiceImpl;
import com.sunbeam.services.VendorServiceImpl;


@CrossOrigin("*")
@RestController
public class InventoryMControllerImpl 
{
	@Autowired 
	private OrderServiceImpl orderService;
	
	@Autowired 
	private VendorServiceImpl vendorService;
	
	 //GetAllOrders  
	 @GetMapping("/orders") 
	 public ResponseEntity<?> getAllOrder()
	 { 
		 List<Orders> result = orderService.getAllOrders();
		 return Response.success(result); 
	 }
	 
	 
	//ORDER BOOK
	//AddOrder
	@PostMapping("/orders/add/{id}")
	public ResponseEntity<?> addOrder(@PathVariable("id") int vendorId, @Valid @RequestBody Orders order)
	{
		Map<String, Object> map = orderService.addOrder(vendorId,order);			
		return Response.success(map) ;
	}
	
	
	
//	EditOrder
//	@PutMapping("/orders/{id}")
//	public ResponseEntity<?> editOrder(@PathVariable("id") int orderId, @Valid @RequestBody Orders order)
//	{
//		Map<String, Object> result =orderService.editOrder(orderId, order);
//		return Response.success(result);
//	}
	 
	
		
	//DeleteOrder
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable("id") int orderId)
	{
		Map<String, Object> result =orderService.deleteOrder(orderId);
		return Response.success(result);
	}
	
	
	 
	//__________________________________________________________________________
	
	 //GetAllVendors  
	 @GetMapping("/vendor") 
	 public ResponseEntity<?> getAllVendor()
	 { 
		 List<Vendor> result = vendorService.getAllVendor();
		 return Response.success(result); 
	 }
	 
	 
	 
	//AddVendor
	@PostMapping("/vendor/add/{id}")
	public ResponseEntity<?> addVendor(@PathVariable("id") int categoryId, @Valid @RequestBody Vendor vendor)
	{			
		Map<String, Object> map = vendorService.addVendor(categoryId,vendor);
		System.out.println(categoryId);
		return Response.success(map) ;
	}
		
		
		
//	EditVendor
	@PutMapping("/vendor/{id}")
	public ResponseEntity<?> editVendor(@PathVariable("id") int vendorId, @Valid @RequestBody Vendor vendor)
	{
		Map<String, Object> result =vendorService.editVendor(vendorId, vendor);
		return Response.success(result);
	}
		 
		
			
	//DeleteVendor
	@DeleteMapping("/vendor/{id}")
	public ResponseEntity<?> deleteVendor(@PathVariable("id") int vendorId)
	{
		Map<String, Object> result =vendorService.deleteVendor(vendorId);
		return Response.success(result);
	} 
	 
	
	
	
	@GetMapping("/category") 
	 public ResponseEntity<?> getAllCategory()
	 { 
		 List<Category> result = vendorService.getAllCategory();
		 return Response.success(result); 
	 }
	
	//@GetMapping("/author") 

	@GetMapping("/author") 
	 public ResponseEntity<?> getAllAuthor()
	 { 
		 List<Author> result = vendorService.getAllAuthor();
		 return Response.success(result); 
	 }
	

}