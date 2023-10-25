package com.github.lorenzosmc.projectmanager.model.workgroup;

import com.github.lorenzosmc.projectmanager.model.notification.Publisher;

public class Workgroup extends Publisher{
	private Long id;
	private WorkgroupStatus status;
	private boolean verified;
	private boolean visible;
	private boolean publishingConsent;

	public Long getId() {
		return id;
	}
	
	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isPublishingConsent() {
		return publishingConsent;
	}

	public void setPublishingConsent(boolean publishingConsent) {
		this.publishingConsent = publishingConsent;
	}

	public WorkgroupStatus getStatus() {
		return status;
	}

	public void setStatus(WorkgroupStatus status) {
		this.status = status;
	}
}
