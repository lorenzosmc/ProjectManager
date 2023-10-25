package com.github.lorenzosmc.projectmanager.model.project;

import com.github.lorenzosmc.projectmanager.model.context.Tag;
import com.github.lorenzosmc.projectmanager.model.user.User;

public class ProjectTagAssignment {
	private Project project;
	private Tag tag;
	private User assigner;

	public User getAssigner() {
		return assigner;
	}

	public void setAssigner(User assigner) {
		this.assigner = assigner;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}	
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}
