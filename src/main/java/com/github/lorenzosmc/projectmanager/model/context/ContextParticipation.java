package com.github.lorenzosmc.projectmanager.model.context;

import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.user.User;

public class ContextParticipation {
	private User participant;
	private Context context;
	private Instant joinDate;
	
	public User getParticipant() {
		return participant;
	}
	public void setParticipant(User participant) {
		this.participant = participant;
	}
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	public Instant getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Instant joinDate) {
		this.joinDate = joinDate;
	}
	
}
