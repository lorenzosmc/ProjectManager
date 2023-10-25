package com.github.lorenzosmc.projectmanager.model.projectassignment;

import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.user.User;

public class Topic {
	private String title;
	// FIXME support for rich text?
	private String content;
	private Instant creationDate;
	private boolean locked;
	private TopicUrgency urgency;
	private User creator;
	private Discussion discussion;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// FIXME support for rich text?
	public String getContent() {
		return content;
	}

	// FIXME support for rich text?
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
	
	//FIXME defensive copy
	public Discussion getDiscussion() {
		return discussion;
	}
	
	//FIXME defensive copy
	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}

}
