package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;
import com.github.lorenzosmc.projectmanager.model.user.User;

@Entity
public class TaskProgressReview extends BaseEntity{
	private String message;

	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant dateOfReview;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User requestor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User reviewer;
	
	
	//TODO override equals() and hashCode()

	public TaskProgressReview() {}
	
	public TaskProgressReview(String uuid) {
		super(uuid);
	}

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

	public User getRequestor() {
		return requestor;
	}

	public void setRequestor(User reqeuestor) {
		this.requestor = reqeuestor;
	}

	public User getReviewer() {
		return reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}
}
