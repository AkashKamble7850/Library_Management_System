package com.sunbeam.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Fine;
import com.sunbeam.entities.IssueBook;

public interface FineDao extends JpaRepository<Fine, Integer>{
	//Fine getByBook(IssueBook issueBookId);

	Fine findByBook(IssueBook book);

	@Modifying
	@Query(value = "INSERT INTO Fine (fineStatus, issueBookId) VALUES (\"UNPAID\", ?;", nativeQuery=true) 
	int addFine(int issueBookId);

	@Modifying
	@Query(value = "UPDATE Fine set fineStatus=\"UNPAID\" WHERE issueBookId=?;", nativeQuery=true) 
	int updateFine(int issueBookId);

	@Modifying
	@Query(value = "INSERT INTO Fine (fineStatus, issueBookId) VALUES (\"UNPAID\", ?);", nativeQuery=true)  
	void addFineTableRows(int issueBook);

	//Fine findByBook(Optional<IssueBook> issueBook);
}
