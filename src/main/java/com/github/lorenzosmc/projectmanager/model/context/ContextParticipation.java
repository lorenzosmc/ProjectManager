package com.github.lorenzosmc.projectmanager.model.context;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;
import com.github.lorenzosmc.projectmanager.model.user.User;

@Entity
public class ContextParticipation extends BaseEntity{
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User participant;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant joinDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Context context;
	
	private int maxCollaborations;
	
	
	//TODO override equals() and hashCode()
	public ContextParticipation() {}
	
	public ContextParticipation(String uuid) {
		super(uuid);
	}
	
	
	public User getParticipant() {
		return participant;
	}
	
	public void setParticipant(User participant) {
		this.participant = participant;
	}
	
	
	public Instant getJoinDate() {
		return joinDate;
	}
	
	public void setJoinDate(Instant joinDate) {
		this.joinDate = joinDate;
	}
	
	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
	
	public int getMaxCollaborations() {
		return maxCollaborations;
	}
	
	public void setMaxCollaborations(int maxCollaborations) {
		this.maxCollaborations = maxCollaborations;
	}
	
}
