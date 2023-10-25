package com.github.lorenzosmc.projectmanager.model.request;

import com.github.lorenzosmc.projectmanager.model.user.User;

public class RequestParticipation {
	private Request request;
	private User participant;
	private RequestRole role;

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public User getParticipant() {
		return participant;
	}

	public void setParticipant(User participant) {
		this.participant = participant;
	}
	
	public RequestRole getRole() {
		return role;
	}

	public void setRole(RequestRole role) {
		this.role = role;
	}
}
