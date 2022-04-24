package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>
{
	
		Category findByCategoryName(String CategoryName);
	
		Category findByCategoryId(int categoryId);
		
		public List<Category> findAll();
}