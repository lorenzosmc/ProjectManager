package com.github.lorenzosmc.projectmanager.model.request;

import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.context.Context;
import com.github.lorenzosmc.projectmanager.model.user.User;
import com.github.lorenzosmc.projectmanager.model.workgroup.Workgroup;

public class RequestCreation {
	private Request request;
	private User creator;
	private Workgroup creatorWorkgroup;
	private Context context;
	private Instant creationDate;

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
	
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	public Workgroup getCreatorWorkgroup() {
		return creatorWorkgroup;
	}

	public void setCreatorWorkgroup(Workgroup requesterWorkgroup) {
		this.creatorWorkgroup = requesterWorkgroup;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}
}
