package com.sunbeam.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "issueBook")
public class IssueBook {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int issueBookId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookId")
	private Book book;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date issueDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date returnDate;
	
	@NotNull
	private String issueStatus;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "staffId")
	private Staff staff;
	
	
	@OneToOne(mappedBy = "book"/*, cascade = CascadeType.ALL*/)
	private Fine fine;

	public IssueBook() {
		
	}

	public IssueBook(int issueBookId, @NotNull Date issueDate, Date dueDate, Date returnDate,
			@NotNull String issueStatus) {
		super();
		this.issueBookId = issueBookId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.issueStatus = issueStatus;
	}

	public int getIssueBookId() {
		return issueBookId;
	}

	public void setIssueBookId(int issueBookId) {
		this.issueBookId = issueBookId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Fine getFine() {
		return fine;
	}

	public void setFine(Fine fine) {
		this.fine = fine;
	}

	@Override
	public String toString() {
		return "IssueBook [issueBookId=" + issueBookId + ", book=" + book + ", issueDate=" + issueDate + ", dueDate="
				+ dueDate + ", returnDate=" + returnDate + ", issueStatus=" + issueStatus + ", user=" + user
				+ ", staff=" + staff + ", fine=" + fine + "]";
	}

	
	
}
