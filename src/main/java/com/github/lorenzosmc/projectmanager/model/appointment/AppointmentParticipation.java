package com.github.lorenzosmc.projectmanager.model.appointment;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;
import com.github.lorenzosmc.projectmanager.model.user.User;
import com.github.lorenzosmc.projectmanager.model.workgroup.Workgroup;

public class AppointmentParticipation extends BaseEntity{
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Appointment appointment;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User participant;
	
	@OneToOne
	private Workgroup participantWorkgroup;
	
	private boolean mandatory;
	
	@Enumerated(EnumType.STRING)
	private AppointmentRole role;
	
	
	//TODO override equals() and hashCode()

	public AppointmentParticipation() {}
	
	public AppointmentParticipation(String uuid) {
		super(uuid);
	}

	
	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	
	public User getParticipant() {
		return participant;
	}

	public void setParticipant(User attendee) {
		this.participant = attendee;
	}
	
	
	public Workgroup getParticipantWorkgroup() {
		return participantWorkgroup;
	}

	public void setParticipantWorkgroup(Workgroup attendeeWorkgroup) {
		this.participantWorkgroup = attendeeWorkgroup;
	}
	
	
	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	
	public AppointmentRole getRole() {
		return role;
	}

	public void setRole(AppointmentRole role) {
		this.role = role;
	}
}
