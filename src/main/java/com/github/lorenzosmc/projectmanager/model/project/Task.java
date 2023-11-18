package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;
import java.util.List;

import com.github.lorenzosmc.projectmanager.model.notification.Publisher;
import com.github.lorenzosmc.projectmanager.model.user.User;
import com.github.lorenzosmc.projectmanager.model.workgroup.Workgroup;

public class Task extends Publisher{
	private Long id;
	private String name;
	private String statement;
	private User creator;
	private Instant creationDate;
	private boolean visible;
	TaskStatus status;
	private int progress;
	private Instant lastUpdateDate;
	private Workgroup workgroup;
	private Project project;	
	private List<Topic> topics;
	private List<Resource> resources;
	private List<TaskProgressReview> reviews;

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

	//FIXME no need: can be set in constructor.
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
		return status == TaskStatus.DRAFTED;
	}

	public boolean isUnassigned() {
		return status == TaskStatus.UNASSIGNED;
	}
	
	public boolean isActive() {
		return status == TaskStatus.ACTIVE;
	}
	
	public boolean isArchived() {
		return status == TaskStatus.ARCHIVED;
	}
	
	public void setToDrafted() {
		status = TaskStatus.DRAFTED;
	}

	public void setToUnassigned() {
		status = TaskStatus.UNASSIGNED;
	}
	
	public void setToActive() {
		status = TaskStatus.ACTIVE;
	}
	
	public void setToArchived() {
		status = TaskStatus.ARCHIVED;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		if(progress > 100)
			this.progress = 100;
		else if(progress < 0)
			this.progress = 0;
		else
			this.progress = progress;
	}

	public Instant getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Instant lastUpdate) {
		this.lastUpdateDate = lastUpdate;
	}

	public Workgroup getWorkgroup() {
		return workgroup;
	}

	public void setWorkgroup(Workgroup workgroup) {
		this.workgroup = workgroup;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public List<Topic> getTopics() {
		return List.copyOf(topics);
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void removeTopic(Topic topic) {
		topics.remove(topic);
	}
	
	public List<Resource> getResources() {
		return List.copyOf(resources);
	}
	
	public void addResource(Resource resource) {
		resources.add(resource);
	}
	
	public void removeResource(Resource resource) {
		resources.remove(resource);
	}
	
	public List<TaskProgressReview> getReviews() {
		return List.copyOf(reviews);
	}
	
	public void addReview(TaskProgressReview review) {
		reviews.add(review);
	}
	
	public void removeReview(TaskProgressReview review) {
		reviews.remove(review);
	}
	
//	FIXME move this to business logic, so that you can handle ProjectCluster and Task interaction
//	public boolean advanceState() {
//		switch(status) {
//			case DRAFTED:
//				status = ProjectStatus.ACTIVE;
//				break;
//			
//			case UNASSIGNED:
//				status = ProjectStatus.ACTIVE;
//				break;
//				
//			case ACTIVE:
//				status = ProjectStatus.ARCHIVED;
//				break;
//				
//			default:
//				return false;
//		}
//		
//		return true;
//	}
//	
//	public boolean regressState() {
//		switch(status) {
//		case ARCHIVED:
//			status = ProjectStatus.ACTIVE;
//			break;
//		
//		//FIXME it could either be UNASSIGNED (if Professor created it) or DRAFTED (if Student created it). Pass in parameters boolean 'professorCreated' perhaps.
//		case ACTIVE:
//			status = ProjectStatus.UNASSIGNED;
//			break;
//						
//		default:
//			return false;
//		}
//	
//		return true;
//	}
}
