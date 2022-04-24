package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Author;

public interface AuthorDao extends JpaRepository<Author, Integer>
{
	//@Query("SELECT * FROM Author WHERE aFirstName = ?1, aLastName = ?2")
	Author findByAFirstNameAndALastName(String aFirstName, String aLastName);

//	@Query(nativeQuery = true,value="SELECT * FROM Author a")
	
	@Query(nativeQuery = true,value="SELECT * FROM author a")
	List<Author> findAll();
}