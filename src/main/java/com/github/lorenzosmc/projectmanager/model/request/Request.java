package com.github.lorenzosmc.projectmanager.model.request;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.github.lorenzosmc.projectmanager.model.appointment.Appointment;
import com.github.lorenzosmc.projectmanager.model.context.Context;
import com.github.lorenzosmc.projectmanager.model.context.ContextCollaboration;
import com.github.lorenzosmc.projectmanager.model.notification.Notification;
import com.github.lorenzosmc.projectmanager.model.notification.NotificationReason;
import com.github.lorenzosmc.projectmanager.model.notification.NotificationType;
import com.github.lorenzosmc.projectmanager.model.notification.Publisher;
import com.github.lorenzosmc.projectmanager.model.project.Project;

@Entity
public class Request extends Publisher {
	@Enumerated(EnumType.STRING)
	private RequestType type;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Context context;
	
	@OneToMany(mappedBy = "request")
	private List<RequestParticipation> participants;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant creationDate;
	
	private String message;
	
	@Enumerated(EnumType.STRING)
	private RequestStatus status;
	
	private String reasonOfDenial;
	
	@OneToOne
	private Appointment appointment;
	
	private boolean meetingWithCollaborators;
	
	@OneToOne
	private Project projectProposalDraft;
	
	private boolean projectProposalWithCollaborators;


	//TODO override equals() and hashCode()
	
	public Request() {}
	
	public Request(String uuid) {
		super(uuid);
	}

	
	//FIXME hide enumeration
	public RequestType getType() {
		return type;
	}
	
	//FIXME hide enumeration
	public void setType(RequestType type) {
		this.type = type;
	}
	
	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	
	public List<RequestParticipation> getParticipants() {
		return participants;
	}
	
	public void setParticipants(List<RequestParticipation> participants) {
		this.participants = participants;
	}

	public void addParticipant(RequestParticipation participant) {
		participants.add(participant);
	}
	
	public boolean removeParticipant(RequestParticipation participant){
		return participants.remove(participant) ? true : false;
	}
	
	
	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	RequestStatus getStatus() {
		return status;
	}
	
	public boolean isPending() {
		return status == RequestStatus.PENDING;
	}

	public boolean isAccepted() {
		return status == RequestStatus.ACCEPTED;
	}
	
	public boolean isDenied() {
		return status == RequestStatus.DENIED;
	}
	
	void setStatus(RequestStatus status) {
		this.status = status;
	}
	
	public boolean accept() {
		if (isPending()) {
			status = RequestStatus.ACCEPTED;

			Notification notification = new Notification(NotificationType.REQUEST, NotificationReason.ACCEPTED, this);
			notifySubscribers(notification);

			return true;
		}

		return false;
	}
	
	public boolean deny(String reason) {
		if(isPending()) {
			status = RequestStatus.DENIED;
			reasonOfDenial = reason;
			
			Notification notification = new Notification(NotificationType.REQUEST, NotificationReason.DENIED, this);
			notifySubscribers(notification);

			return true;
		}
		
		return false;
	}
	
	
	public String getReasonOfDenial() {
		return reasonOfDenial;
	}

	public void setReasonOfDenial(String reasonOfDenial) {
		this.reasonOfDenial = reasonOfDenial;
	}

	
	public Appointment getMeeting() {
		return appointment;
	}

	public void setMeeting(Appointment appointment) {
		this.appointment = appointment;
	}

	
	public boolean isMeetingWithCollaborators() {
		return meetingWithCollaborators;
	}

	public void setMeetingWithCollaborators(boolean meetingWithCollaborators) {
		this.meetingWithCollaborators = meetingWithCollaborators;
	}

	
	public Project getProjectProposalDraft() {
		return projectProposalDraft;
	}

	public void setProjectProposalDraft(Project projectProposalDraft) {
		this.projectProposalDraft = projectProposalDraft;
	}
	
	
	public boolean isProjectProposalWithCollaborators() {
		return projectProposalWithCollaborators;
	}

	public void setProjectProposalWithCollaborators(boolean projectProposalWithCollaborators) {
		this.projectProposalWithCollaborators = projectProposalWithCollaborators;
	}
}
