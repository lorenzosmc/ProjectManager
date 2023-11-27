package com.github.lorenzosmc.projectmanager.model.notification;

import java.time.Instant;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;

@Entity
public class Notification extends BaseEntity{
	@Enumerated(EnumType.STRING)
	private NotificationType type;
	
	//FIXME how to deal with Object in JPA?
	private Object object;
	
	@Enumerated(EnumType.STRING)
	private NotificationReason reason;
	
	private String message;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant creationDate;
	
	private boolean viewed;
	
	private boolean hidden;

	
	//TODO override equals() and hashCode()
	
	public Notification(NotificationType type, NotificationReason reason, Object object) {
		this.type = type;
		this.object = object;
		this.reason = reason;
		this.creationDate = Instant.now();
		this.viewed = false;
		this.hidden = false;
	}

	public Notification() {}
	
	public Notification(String uuid) {
		super(uuid);
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
