package com.github.lorenzosmc.projectmanager.model.context;

import java.time.Instant;
import java.util.List;

import com.github.lorenzosmc.projectmanager.model.project.Project;
import com.github.lorenzosmc.projectmanager.model.user.User;

public class ContextCollaboration {
	private User collaborator;
	private Context context;
	private Instant startDate;
	private List<Project> collaborations;
	private int maxProjects;

	public List<Project> getCollaborations() {
		return List.copyOf(collaborations);
	}

	public void addCollaboration(Project collaboration) {
		collaborations.add(collaboration);
	}
	
	public boolean removeCollaboration(Project collaboration) {
		return collaborations.remove(collaboration) ? true : false;
	}
		
	public User getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(User collaborator) {
		this.collaborator = collaborator;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public Instant getStartDate() {
		return startDate;
	}

	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}

	public int getMaxProjects() {
		return maxProjects;
	}

	public void setMaxProjects(int maxProjects) {
		this.maxProjects = maxProjects;
	}

}
