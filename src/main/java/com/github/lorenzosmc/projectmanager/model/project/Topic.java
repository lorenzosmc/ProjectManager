package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;
import com.github.lorenzosmc.projectmanager.model.user.User;

@Entity
public class Topic extends BaseEntity{
	private String title;
	
	private String content;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant creationDate;
	
	private boolean locked;
	
	@Enumerated(EnumType.STRING)
	private TopicUrgency urgency;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User creator;
	
	@OneToOne(optional = false)
	private Discussion discussion;

	
	//TODO override equals() and hashCode()

	public Topic() {}
	
	public Topic(String uuid) {
		super(uuid);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public TopicUrgency getUrgency() {
		return urgency;
	}

	public void setUrgency(TopicUrgency urgency) {
		this.urgency = urgency;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	public Discussion getDiscussion() {
		return discussion;
	}
	
	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}

}
