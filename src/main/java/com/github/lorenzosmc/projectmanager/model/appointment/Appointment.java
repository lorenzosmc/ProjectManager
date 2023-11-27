package com.github.lorenzosmc.projectmanager.model.appointment;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.github.lorenzosmc.projectmanager.model.context.Context;
import com.github.lorenzosmc.projectmanager.model.notification.Notification;
import com.github.lorenzosmc.projectmanager.model.notification.NotificationReason;
import com.github.lorenzosmc.projectmanager.model.notification.NotificationType;
import com.github.lorenzosmc.projectmanager.model.notification.Publisher;
import com.github.lorenzosmc.projectmanager.model.user.User;

@Entity
public class Appointment extends Publisher {
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User creator;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant creationDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Context context;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant startDate;
	
	//FIXME need to use some other class from java.timeTime? Perhaps just an integer representing minutes.
	private Duration duration;
	
	private String location;
	
	@Enumerated(EnumType.STRING)
	private AppointmentType type;
	
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status;
		
	private int examScore;
	
	private boolean examPassed;
	
	private String meetingTopic;
	
	private String meetingTopicDetailed;
	
	@OneToMany(mappedBy = "appointment")
	private List<AppointmentParticipation> participants;

	
	//TODO override equals() and hashCode()

	public Appointment() {}
	
	public Appointment(String uuid) {
		super(uuid);
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

	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
	
	public boolean schedule() {
		if (isAvailable()) {
			status = AppointmentStatus.SCHEDULED;

			Notification notification = new Notification(NotificationType.APPOINTMENT, NotificationReason.SCHEDULED, this);
			notifySubscribers(notification);

			return true;
		}
		return false;
	}

	public boolean cancel() {
		if (isScheduled()) {
			status = AppointmentStatus.AVAILABLE;

			Notification notification = new Notification(NotificationType.APPOINTMENT, NotificationReason.CANCELLED, this);
			notifySubscribers(notification);

			return true;
		}

		return false;
	}

	public boolean end() {
		if (isScheduled()) {
			status = AppointmentStatus.CONCLUDED;

			Notification notification = new Notification(NotificationType.APPOINTMENT, NotificationReason.CONCLUDED, this);
			notifySubscribers(notification);

			return true;
		}

		return false;
	}

	public boolean isScheduled() {
		return status == AppointmentStatus.SCHEDULED;
	}

	public boolean isAvailable() {
		return status == AppointmentStatus.AVAILABLE;
	}

	public boolean isConcluded() {
		return status == AppointmentStatus.CONCLUDED;
	}

	
	public Instant getStartDate() {
		return startDate;
	}

	public boolean setStartDate(Instant date) {
		if (isAvailable()) {
			this.startDate = date;
			return true;
		}
		return false;
	}

	
	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	
	public String getLocation() {
		return location;
	}

	public boolean setLocation(String location) {
		if (isAvailable()) {
			this.location = location;
			return true;
		}
		return false;
	}

	
	public AppointmentType getType() {
		return type;
	}

	public void setType(AppointmentType type) {
		this.type = type;
	}

	
	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	
	public int getExamScore() {
		return examScore;
	}

	public void setExamScore(int score) {
		this.examScore = score;
	}

	
	public boolean isExamPassed() {
		return examPassed;
	}

	public void setExamPassed(boolean passed) {
		this.examPassed = passed;
	}

	
	public String getMeetingTopic() {
		return meetingTopic;
	}

	public void setMeetingTopic(String topic) {
		this.meetingTopic = topic;
	}

	
	public String getMeetingTopicDetailed() {
		return meetingTopicDetailed;
	}

	public void setMeetingTopicDetailed(String detailedDescription) {
		this.meetingTopicDetailed = detailedDescription;
	}

	
	
	public List<AppointmentParticipation> getParticipants() {
		return participants;
	}
	

	public void setParticipants(List<AppointmentParticipation> participants) {
		this.participants = participants;
	}

	public void addParticipant(AppointmentParticipation participant) {
		participants.add(participant);
	}
	
	public boolean removeParticipant(AppointmentParticipation participant) {
		return participants.remove(participant) ? true : false;
	}
}
