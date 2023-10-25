package com.github.lorenzosmc.projectmanager.model.appointment;

import com.github.lorenzosmc.projectmanager.model.user.User;
import com.github.lorenzosmc.projectmanager.model.workgroup.Workgroup;

public class Attendance {
	private User attendee;
	private Workgroup attendeeWorkgroup;
	private Appointment appointment;
	private boolean mandatory;
	private AttendanceRole role;
	
	public User getAttendee() {
		return attendee;
	}

	public void setAttendee(User attendee) {
		this.attendee = attendee;
	}
	
	public Workgroup getAttendeeWorkgroup() {
		return attendeeWorkgroup;
	}

	public void setAttendeeWorkgroup(Workgroup attendeeWorkgroup) {
		this.attendeeWorkgroup = attendeeWorkgroup;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public AttendanceRole getRole() {
		return role;
	}

	public void setRole(AttendanceRole role) {
		this.role = role;
	}
}
