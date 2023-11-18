package com.github.lorenzosmc.projectmanager.model.request;

import com.github.lorenzosmc.projectmanager.model.appointment.Appointment;
import com.github.lorenzosmc.projectmanager.model.notification.Notification;
import com.github.lorenzosmc.projectmanager.model.notification.NotificationReason;
import com.github.lorenzosmc.projectmanager.model.notification.NotificationType;
import com.github.lorenzosmc.projectmanager.model.notification.Publisher;
import com.github.lorenzosmc.projectmanager.model.project.Project;

public class Request extends Publisher {
	private Long id;
	private RequestType type;
	private String message;
	private RequestStatus status;
	private String reasonOfDenial;
	private Appointment appointment;
	private boolean meetingWithCollaborators;
	private Project projectProposalDraft;
	private boolean projectProposalWithCollaborators;

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
	
	public boolean isPending() {
		return status == RequestStatus.PENDING;
	}

	public boolean isAccepted() {
		return status == RequestStatus.ACCEPTED;
	}
	
	public boolean isDenied() {
		return status == RequestStatus.DENIED;
	}

	public Long getId() {
		return id;
	}

	public RequestType getType() {
		return type;
	}

	public void setType(RequestType type) {
		this.type = type;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
