package com.github.lorenzosmc.projectmanager.model.context;

import java.time.Instant;
import java.util.List;

import com.github.lorenzosmc.projectmanager.model.notification.Publisher;
import com.github.lorenzosmc.projectmanager.model.project.Project;
import com.github.lorenzosmc.projectmanager.model.user.User;

public class Context extends Publisher{
	private Long id;
	private String name;
	private User creator;
	private Instant creationDate;
	private List<Project> projects;
	private boolean locked;
	private boolean hidden;
	// FIXME: better way to store passwords?
	private String password;
	private List<Tag> tags;
	
	public List<Tag> getTags() {
		return List.copyOf(tags);
	}

	public void addTag(Tag tag) {
		tags.add(tag);
	}
	
	public boolean removeTag(Tag tag) {
		return tags.remove(tag) ? true : false;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public List<Project> getProjects() {
		return projects;
	}

	public void addProject(Project project) {
		projects.add(project);
	}
	
	public boolean removeProject(Project project) {
		return projects.remove(project) ? true : false;
	}
	
	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
		
	// FIXME: better way to get passwords?
	public String getPassword() {
		return password;
	}

	// FIXME: better way to set passwords?
	public void setPassword(String password) {
		this.password = password;
	}
}
