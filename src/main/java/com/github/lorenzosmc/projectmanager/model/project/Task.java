package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.github.lorenzosmc.projectmanager.model.context.Context;
import com.github.lorenzosmc.projectmanager.model.context.ContextCollaboration;
import com.github.lorenzosmc.projectmanager.model.notification.Publisher;
import com.github.lorenzosmc.projectmanager.model.user.User;
import com.github.lorenzosmc.projectmanager.model.workgroup.Workgroup;

public class Task extends Publisher{
	private String name;
	
	private String statement;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Context context;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User creator;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant creationDate;
	
	private boolean visible;
	
	@Enumerated(EnumType.STRING)
	TaskStatus status;
	
	private int progress;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant lastUpdateDate;
	
	private Workgroup workgroup;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;	
	
	@OneToMany
	private List<Topic> topics;
	
	@OneToMany
	private List<Resource> resources;
	
	@OneToMany
	private List<TaskProgressReview> reviews;
	
	@ElementCollection
	private List<TaskTagAssignment> tagAssignments;

	@OneToMany(mappedBy = "")
	private List<ContextCollaboration> collaborations;
	
	
	//TODO override equals() and hashCode()
	
	public Task() {}
	
	public Task(String uuid) {
		super(uuid);
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

	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
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
	
	//TODO add setter
	public List<Topic> getTopics() {
		//FIXME
		//return List.copyOf(topics);
		return topics;
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void removeTopic(Topic topic) {
		topics.remove(topic);
	}
	
	//TODO add setter
	public List<Resource> getResources() {
		//FIXME
		//return List.copyOf(resources);
		return resources;
	}
	
	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public List<TaskTagAssignment> getTagAssignments() {
		return tagAssignments;
	}

	public void setTagAssignments(List<TaskTagAssignment> tagAssignments) {
		this.tagAssignments = tagAssignments;
	}

	public List<ContextCollaboration> getCollaborations() {
		return collaborations;
	}
	
	//TODO add addTagAssignemnt() and removeTagAssignent(), same for other collections.

	public void setCollaborations(List<ContextCollaboration> collaborations) {
		this.collaborations = collaborations;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public void setReviews(List<TaskProgressReview> reviews) {
		this.reviews = reviews;
	}

	public void addResource(Resource resource) {
		resources.add(resource);
	}
	
	public void removeResource(Resource resource) {
		resources.remove(resource);
	}
	
	//TODO add setter
	public List<TaskProgressReview> getReviews() {
		//FIXME
		//return List.copyOf(reviews);
		return reviews;
	}
	
	public void addReview(TaskProgressReview review) {
		reviews.add(review);
	}
	
	public void removeReview(TaskProgressReview review) {
		reviews.remove(review);
	}
	
	
//	TODO move this to business logic, so that you can handle ProjectCluster and Task interaction
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
