package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.user.User;

public class TaskProgressReview {
	private String message;
	private Instant dateOfReview;
	private User reqeuestor;
	private User reviewer;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Instant getDateOfReview() {
		return dateOfReview;
	}

	public void setDateOfReview(Instant dateOfReview) {
		this.dateOfReview = dateOfReview;
	}

	public User getReqeuestor() {
		return reqeuestor;
	}

	public void setReqeuestor(User reqeuestor) {
		this.reqeuestor = reqeuestor;
	}

	public User getReviewer() {
		return reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}
}
