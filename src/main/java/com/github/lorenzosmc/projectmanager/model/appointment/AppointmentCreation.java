package com.github.lorenzosmc.projectmanager.model.appointment;

import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.context.Context;
import com.github.lorenzosmc.projectmanager.model.user.User;

public class AppointmentCreation {
	private Instant creationDate;
	private Appointment appointment;
	private Context context;
	private User creator;

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
}
