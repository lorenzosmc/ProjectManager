package com.github.lorenzosmc.projectmanager.model.notification;

import java.time.Instant;

public class Notification {
	private NotificationType type;
	private Object object;
	private NotificationReason reason;
	private String message;
	private Instant creationDate;
	private boolean viewed;
	private boolean hidden;

	public Notification(NotificationType type, NotificationReason reason, Object object) {
		this.type = type;
		this.object = object;
		this.reason = reason;
		this.creationDate = Instant.now();
		this.viewed = false;
		this.hidden = false;
	}

	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public NotificationReason getReason() {
		return reason;
	}

	public void setReason(NotificationReason reason) {
		this.reason = reason;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isViewed() {
		return viewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

}
