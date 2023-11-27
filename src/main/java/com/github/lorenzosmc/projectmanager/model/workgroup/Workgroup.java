package com.github.lorenzosmc.projectmanager.model.workgroup;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.github.lorenzosmc.projectmanager.model.appointment.Appointment;
import com.github.lorenzosmc.projectmanager.model.context.Context;
import com.github.lorenzosmc.projectmanager.model.notification.Publisher;
import com.github.lorenzosmc.projectmanager.model.project.Message;
import com.github.lorenzosmc.projectmanager.model.project.Task;
import com.github.lorenzosmc.projectmanager.model.user.User;

@Entity
public class Workgroup extends Publisher{	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant creationDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	private User creator;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Context context;
	
	private boolean verified;
		
	private boolean visible;
	
	private boolean publishingConsent;

	@Enumerated(EnumType.STRING)
	private WorkgroupStatus status;
	
	@OneToOne
	private Task task;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant dateOfAssignment;
	
	private int progress; 
	
	@OneToOne
	private Appointment exam;
	
	@OneToMany(mappedBy = "workgroup")
	private List<WorkgroupParticipation> participants;

	
	//TODO override equals() and hashCode()
	
	public Workgroup() {
		super();
	}
	
	public Workgroup(String uuid) {
		super(uuid);
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

	
	public List<WorkgroupParticipation> getMessages(){
		//FIXME defensive copy
		return participants;
	}
	
	public void setMessages(List<WorkgroupParticipation> participants) {
		this.participants = participants;
	}
	
	public void addParticipant(WorkgroupParticipation participant) {
		participants.add(participant);
	}
	
	public boolean removeParticipant(WorkgroupParticipation participant) {
		return participants.remove(participant) ? true : false;
	}
}
