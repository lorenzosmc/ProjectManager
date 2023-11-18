package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.user.User;

public class Message {
	private String text;
	private User creator;
	private Instant creationDate;
	private Message replyTo;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public Message getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(Message replyTo) {
		this.replyTo = replyTo;
	}

}
