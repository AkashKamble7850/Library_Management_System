package com.sunbeam.dtos;

import java.util.Date;

public class IssueBookDTO {
	// issueBookId | bookId | issueDate  | dueDate    | returnDate | issueStatus | userId | staffId
	private int issueBookId;
	private int bookId;
	private Date issueDate;
	private Date dueDate;
	private Date returnDate;
	private String issueStatus;
	private int userId;
	private int staffId;
	
	
	public IssueBookDTO() {
		
	}


	public IssueBookDTO(int issueBookId, int bookId, Date issueDate, Date dueDate, Date returnDate, String issueStatus,
			int userId, int staffId) {
		super();
		this.issueBookId = issueBookId;
		this.bookId = bookId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.issueStatus = issueStatus;
		this.userId = userId;
		this.staffId = staffId;
	}


	public int getIssueBookId() {
		return issueBookId;
	}


	public void setIssueBookId(int issueBookId) {
		this.issueBookId = issueBookId;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
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


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getStaffId() {
		return staffId;
	}


	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	@Override
	public String toString() {
		return "IssueBookDTO [issueBookId=" + issueBookId + ", bookId=" + bookId + ", issueDate=" + issueDate
				+ ", dueDate=" + dueDate + ", returnDate=" + returnDate + ", issueStatus=" + issueStatus + ", userId="
				+ userId + ", staffId=" + staffId + "]";
	}

	
		
}
