package com.sunbeam.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fine")
public class Fine {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int fineId;
	
	@NotNull
	private String fineStatus;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@OneToOne(mappedBy = "issueBookId"/*, cascade = CascadeType.ALL*/)
//	@JoinColumn(name = "issueId", referencedColumnName = "issueBookId")
	/*@PrimaryKeyJoinColumn
	@OneToOne
	@MapsId */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "issueBookId")
	private IssueBook book;
	
	//parameterless Constructor
	public Fine() {
	}

	//Parameterized Constructor
	public Fine(int fineId, @NotNull String fineStatus, IssueBook book) {
		super();
		this.fineId = fineId;
		this.fineStatus = fineStatus;
		this.book = book;
	}

	//Getter and Setter
	public int getFineId() {
		return fineId;
	}

	

	public void setFineId(int fineId) {
		this.fineId = fineId;
	}

	public String getFineStatus() {
		return fineStatus;
	}

	public void setFineStatus(String fineStatus) {
		this.fineStatus = fineStatus;
	}

	public IssueBook getBook() {
		return book;
	}

	public void setBook(IssueBook book) {
		this.book = book;
	}
	
	//toSrting
	@Override
	public String toString() {
		return "Fine [fineId=" + fineId + ", fineStatus=" + fineStatus + ", book=" + book + "]";
	}

	
	
	
	
}
