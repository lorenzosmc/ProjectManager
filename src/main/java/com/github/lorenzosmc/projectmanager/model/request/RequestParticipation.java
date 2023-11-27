package com.github.lorenzosmc.projectmanager.model.request;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;
import com.github.lorenzosmc.projectmanager.model.user.User;
import com.github.lorenzosmc.projectmanager.model.workgroup.Workgroup;

@Entity
public class RequestParticipation extends BaseEntity{
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User participant;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Request request;
	
	@OneToOne
	private Workgroup participantWorkgroup;
	
	private boolean creator;
	
	
	//TODO override equals() and hashCode()
	public RequestParticipation() {}
	
	public RequestParticipation(String uuid) {
		super(uuid);
	}

	public User getParticipant() {
		return participant;
	}

	public void setParticipant(User participant) {
		this.participant = participant;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public boolean isCreator() {
		return creator;
	}

	public void setCreator(boolean creator) {
		this.creator = creator;
	}
	
}
