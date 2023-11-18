package com.github.lorenzosmc.projectmanager.model.workgroup;

import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.appointment.Appointment;
import com.github.lorenzosmc.projectmanager.model.notification.Publisher;
import com.github.lorenzosmc.projectmanager.model.project.Task;

public class Workgroup extends Publisher{
	private Long id;
	private boolean verified;
	private boolean visible;
	private boolean publishingConsent;
	private WorkgroupStatus status;
	private Task task;
	private Instant dateOfAssignment;
	private int progress; 
	private Appointment exam;

	public Long getId() {
		return id;
	}
	
	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isPublishingConsent() {
		return publishingConsent;
	}

	public void setPublishingConsent(boolean publishingConsent) {
		this.publishingConsent = publishingConsent;
	}

	public WorkgroupStatus getStatus() {
		return status;
	}

	public void setStatus(WorkgroupStatus status) {
		this.status = status;
	}
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Instant getDateOfAssignment() {
		return dateOfAssignment;
	}

	public void setDateOfAssignment(Instant dateOfAssignment) {
		this.dateOfAssignment = dateOfAssignment;
	}
	
	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		if(progress < 0)
			this.progress = 0;
		else if(progress > 100)
			this.progress = 100;
		else
			this.progress = progress;
	}
	
	public Appointment getExam() {
		return exam;
	}

	public void setExam(Appointment exam) {
		this.exam = exam;
	}
}
