package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.github.lorenzosmc.projectmanager.model.notification.Publisher;
import com.github.lorenzosmc.projectmanager.model.user.User;

@Entity
public class Project extends Publisher{
	private String title;
	
	private String statement;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User creator;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant creationDate;
	
	@OneToMany(mappedBy = "project")
	private List<Task> tasks;

	
	//TODO override equals() and hashCode()
	
	public Project() {}
	
	public Project(String uuid) {
		super(uuid);
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

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}
	
	public List<Task> getTasks(){
		//FIXME
		//return List.copyOf(tasks);
		return tasks;
	}
	
	public void addTask(Task task) {
		tasks.add(task);
	}
	
	public boolean removeTask(Task task) {
		return tasks.remove(task) ? true : false;
	}
}
