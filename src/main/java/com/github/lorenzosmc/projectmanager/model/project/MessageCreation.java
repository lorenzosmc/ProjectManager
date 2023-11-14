package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.user.User;

public class MessageCreation {
	private Message message;
	private User creator;
	private Instant creationDate;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}
}
