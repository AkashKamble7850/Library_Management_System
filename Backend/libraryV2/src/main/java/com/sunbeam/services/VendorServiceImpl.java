package com.sunbeam.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.AuthorDao;
import com.sunbeam.daos.CategoryDao;
import com.sunbeam.daos.VendorDao;
import com.sunbeam.entities.Author;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Vendor;

@Transactional
@Service
public class VendorServiceImpl {

	@Autowired
	private VendorDao vendorDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private AuthorDao authorDao;
	
	
	public List<Vendor> getAllVendor()
	{
		return vendorDao.findAll();
	}
	
//	Add Vendor
	public Map<String, Object> addVendor(int categoryId, Vendor vendor) 
	{		
//		Category c = new Category(categoryId);
//		vendor.setCategory(c);
		
		//ONLY 1 Vendor for 1 category since 1-1 relationship was the real issue 
		
		Optional<Category> cat = categoryDao.findById(categoryId);
		
		if(cat.isEmpty()) {
			return Collections.singletonMap("Wrong category Id", 0);
		}
		else {
			vendor.setCategory(cat.get());
			
			//System.out.println(vendor);
			
			Vendor vendorSave = vendorDao.save(vendor);
			
			System.out.println(vendorSave);
			
			return Collections.singletonMap("insertedId", vendorSave.getVendorId());
		}
		
	
	}
	
	
	
	
//	EditOrder
	public Map<String, Object> editVendor(int vendorId, Vendor vendor)
	{
		//Staff exist, then update it
		if(vendorDao.existsById(vendorId)) 
		{
			vendor.setVendorId(vendorId);
			Vendor vendorSave = vendorDao.save(vendor);
			System.out.println(vendorSave);
			return Collections.singletonMap("Vendor updated", 1);
		}
		//if not exist, return zero updated rows
		return Collections.singletonMap("Vendor does not exist", 0);
	}
	
	//need to keep CATEGORY unaffected/as it is
	//it's getting changed to null
	

	
//  Delete Order
	public Map<String, Object> deleteVendor(int vendorId)
	{
		//if Order exists
		if(vendorDao.existsById(vendorId)) 
		{
			vendorDao.deleteByVendorId(vendorId);
			return Collections.singletonMap("Vendor Deleted", 1);
		}
		////if Staff Member does not exists
		return Collections.singletonMap("Vendor does not exist", 0);
	}
	
	
	
	
	public Category findCategoryByCategoryId(int categoryId)
	{
		System.out.println(findCategoryByCategoryId(categoryId));
		return categoryDao.findByCategoryId(categoryId);
	}

	
	public List<Category> getAllCategory() {
		return categoryDao.findAll();
	}

	public List<Author> getAllAuthor() 
	{
		return authorDao.findAll();
	}
	
	
	
}


//Vendor v = new Vendor(vendorId);
//order.setVendor(v);
//System.out.println(order);

//Category c = new Category(categoryId);
//vendor.setCategory(c);


//int categoryId = vendor.getCategory().getCategoryId();
//Category category = new Category(categoryId);
//
//vendor.setCategory(category);


//		vendor.getCategory().setCategoryId(2);





//set the Staffdto with id 
//Convert DTO into Staff Entity
//Orders order = converter.toStaffEntity(staffDto);
//save the Staff