package com.github.lorenzosmc.projectmanager.model.appointment;

import java.time.Duration;
import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.notification.Notification;
import com.github.lorenzosmc.projectmanager.model.notification.NotificationReason;
import com.github.lorenzosmc.projectmanager.model.notification.NotificationType;
import com.github.lorenzosmc.projectmanager.model.notification.Publisher;

public class Appointment extends Publisher {
	private Long id;
	private Instant startDate;
	private Duration duration;
	private String location;
	private AppointmentType type;
	private AppointmentStatus status;
	private int examScore;
	private boolean examPassed;
	private String meetingTopic;
	private String meetingTopicDetailed;

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

	public Long getId() {
		return id;
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
}
