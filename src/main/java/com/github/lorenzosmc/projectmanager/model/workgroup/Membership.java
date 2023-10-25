package com.github.lorenzosmc.projectmanager.model.workgroup;

import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.user.User;

public class Membership {
	private Instant joinDate;
	private boolean isLeader;
	private User member;
	private Workgroup workgroup;
	private boolean publishingConsent;

	public Instant getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Instant joinDate) {
		this.joinDate = joinDate;
	}

	public boolean isLeader() {
		return isLeader;
	}

	public void setLeader(boolean isLeader) {
		this.isLeader = isLeader;
	}

	public User getMember() {
		return member;
	}

	public void setMember(User member) {
		this.member = member;
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
