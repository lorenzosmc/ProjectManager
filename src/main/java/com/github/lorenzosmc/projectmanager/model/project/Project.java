package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;
import java.util.List;

import com.github.lorenzosmc.projectmanager.model.notification.Publisher;

public class Project extends Publisher{
	private Long id;
	private String title;
	private String statement;
	private Instant creationDate;
	private List<Task> tasks;
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}
	
	public List<Task> getTasks(){
		return List.copyOf(tasks);
	}
	
	public void addTask(Task task) {
		tasks.add(task);
	}
	
	public boolean removeTask(Task task) {
		return tasks.remove(task) ? true : false;
	}
}
