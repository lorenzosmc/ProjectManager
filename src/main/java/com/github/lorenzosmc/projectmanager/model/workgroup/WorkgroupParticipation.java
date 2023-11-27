package com.github.lorenzosmc.projectmanager.model.workgroup;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;
import com.github.lorenzosmc.projectmanager.model.user.User;

@Entity
public class WorkgroupParticipation extends BaseEntity{
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant joinDate;
	
	private boolean leader;
	
	@OneToOne(optional = false)
	private User participant;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Workgroup workgroup;
	
	private boolean publishingConsent;


	//TODO override equals() and hashCode()
	
	public WorkgroupParticipation() {
		super();
	}
	
	public WorkgroupParticipation(String uuid) {
		super(uuid);
	}
	
	
	public Instant getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Instant joinDate) {
		this.joinDate = joinDate;
	}

	
	public boolean isLeader() {
		return leader;
	}

	public void setLeader(boolean isLeader) {
		this.leader = isLeader;
	}

	
	public User getParticipant() {
		return participant;
	}

	public void setParticipant(User participant) {
		this.participant = participant;
	}

	
	public Workgroup getWorkgroup() {
		return workgroup;
	}

	public void setWorkgroup(Workgroup workgroup) {
		this.workgroup = workgroup;
	}

	
	public boolean isPublishingConsent() {
		return publishingConsent;
	}

	public void setPublishingConsent(boolean publishingConsent) {
		this.publishingConsent = publishingConsent;
	}
}
