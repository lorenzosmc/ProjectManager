package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.user.User;

public class Project {
	private Long id;
	private String name;
	//FIXME 'statement' should allow for storing rich text
	private String statement;
	private User creator;
	private Instant creationDate; 
	private ProjectStatus status;
	private boolean visible;
	
	public boolean isDrafted() {
		return status == ProjectStatus.DRAFTED;
	}

	public boolean isUnassigned() {
		return status == ProjectStatus.UNASSIGNED;
	}
	
	public boolean isActive() {
		return status == ProjectStatus.ACTIVE;
	}
	
	public boolean isArchived() {
		return status == ProjectStatus.ARCHIVED;
	}
	
	public boolean advanceState() {
		switch(status) {
			case DRAFTED:
				status = ProjectStatus.ACTIVE;
				break;
			
			case UNASSIGNED:
				status = ProjectStatus.ACTIVE;
				break;
				
			case ACTIVE:
				status = ProjectStatus.ARCHIVED;
				break;
				
			default:
				return false;
		}
		
		return true;
	}
	
	public boolean regressState() {
		switch(status) {
		case ARCHIVED:
			status = ProjectStatus.ACTIVE;
			break;
		
		//FIXME it could either be UNASSIGNED (if Professor created it) or DRAFTED (if Student created it). Pass in parameters boolean 'professorCreated' perhaps.
		case ACTIVE:
			status = ProjectStatus.UNASSIGNED;
			break;
						
		default:
			return false;
	}
	
	return true;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
