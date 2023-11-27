package com.github.lorenzosmc.projectmanager.model.context;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;
import com.github.lorenzosmc.projectmanager.model.project.Task;
import com.github.lorenzosmc.projectmanager.model.user.User;

@Entity
public class ContextCollaboration extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User collaborator;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Context context;
	
	private Instant startDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Task task;

	
	//TODO override equals() and hashCode()
	
	public ContextCollaboration() {}
	
	public ContextCollaboration(String uuid) {
		super(uuid);
	}

	public Task getTask() {
		//FIXME defensive copy
		return task;
	}
	
	public void setTask(Task task) {
		this.task = task;
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

}
