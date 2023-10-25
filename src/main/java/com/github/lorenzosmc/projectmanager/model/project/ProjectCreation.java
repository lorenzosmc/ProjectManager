package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.context.Context;
import com.github.lorenzosmc.projectmanager.model.user.User;

public class ProjectCreation {
	private Project project;
	private User creator;
	private Context context;
	private Instant creationDate;

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
