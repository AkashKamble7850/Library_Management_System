package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "feedback")
public class Feedback {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int feedbackId;
	
	private String feedback;
	
	@JsonProperty("user")
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public Feedback() {
	}
	

	public Feedback(int feedbackId, String feedback) {
		this.feedbackId = feedbackId;
		this.feedback = feedback;
	}

	public Feedback(String feedback) {
		this.feedback = feedback;
	}


	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedback=" + feedback + ", user=" + user + "]";
	}
	
}
