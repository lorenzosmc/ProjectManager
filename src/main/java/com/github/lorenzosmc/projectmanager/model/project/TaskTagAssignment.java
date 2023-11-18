package com.github.lorenzosmc.projectmanager.model.project;

import com.github.lorenzosmc.projectmanager.model.context.Tag;
import com.github.lorenzosmc.projectmanager.model.user.User;

public class TaskTagAssignment {
	private Task task;
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
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
}
