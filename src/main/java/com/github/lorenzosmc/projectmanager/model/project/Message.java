package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;
import com.github.lorenzosmc.projectmanager.model.user.User;

@Entity
public class Message extends BaseEntity{
	private String text;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User creator;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant creationDate;
	
	//FIXME is this a problem for JPA?
	@OneToOne
	private Message replyTo;

	
	//TODO override equals() and hashCode()

	public Message() {}
	
	public Message(String uuid) {
		super(uuid);
	}

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
