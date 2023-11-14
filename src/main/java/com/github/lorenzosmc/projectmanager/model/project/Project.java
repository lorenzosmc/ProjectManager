package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;
import java.util.List;

import com.github.lorenzosmc.projectmanager.model.appointment.Appointment;
import com.github.lorenzosmc.projectmanager.model.user.User;
import com.github.lorenzosmc.projectmanager.model.workgroup.Workgroup;

public class Project {
	private Long id;
	private String name;
	private User creator;
	private Instant creationDate;
	//TODO sub-statements?
	private String statement;
	private boolean visible;
	//FIXME how would status work when a workgroup has already been assigned but others have to work on it. 
	// does it work in SEPERATE stages? Or can it work in parallel.
	private ProjectStatus status;
	private int progress;
	private Instant lastUpdate;
	private List<Workgroup> workgroups;
	//TODO add number of sub projects.
	
	//FIXME how do these work when multiple workgroups work on the project?
	private List<ProjectProgressReview> reviews;
	private List<Topic> topics;
	private List<Resource> resources;
	
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
	
	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		if(progress < 0)
			this.progress = 0;
		else if(progress > 100)
			this.progress = 100;
		else
			this.progress = progress;
	}
	
	public List<ProjectProgressReview> getReviews() {
		return reviews;
	}

	public void addReview(ProjectProgressReview review) {
		reviews.add(review);
	}
	
	public void removeReview(ProjectProgressReview review) {
		reviews.remove(review);
	}
	
	public List<Topic> getTopics() {
		return topics;
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void removeTopic(Topic topic) {
		topics.remove(topic);
	}
	
	public List<Resource> getResources() {
		return resources;
	}	
	
	public void addResource(Resource resource) {
		resources.add(resource);
	}
	
	public void removeResource(Resource resource) {
		resources.remove(resource);
	}
	
	public List<Workgroup> getWorkgroups() {
		return List.copyOf(workgroups);
	}

	public void addWorkgroup(Workgroup workgroup) {
		workgroups.add(workgroup);
	}
	
	public boolean removeWorkgroup(Workgroup workgroup) {
		return workgroups.remove(workgroup) ? true : false;
	}

	public Instant getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Instant lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public Long getId() {
		return id;
	}

}
