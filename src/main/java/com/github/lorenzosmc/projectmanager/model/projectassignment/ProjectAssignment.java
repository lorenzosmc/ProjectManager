package com.github.lorenzosmc.projectmanager.model.projectassignment;

import java.time.Instant;
import java.util.List;

import com.github.lorenzosmc.projectmanager.model.appointment.Appointment;
import com.github.lorenzosmc.projectmanager.model.project.Project;
import com.github.lorenzosmc.projectmanager.model.workgroup.Workgroup;

public class ProjectAssignment {
	private Long id;
	private Workgroup workgroup;
	private Project project;
	private Instant dateOfAssignment;
	private Instant lastUpdate;
	private int progress;
	private Appointment exam;
	private List<ProjectProgressReview> reviews;
	private List<Topic> topics;
	private List<Resource> resources;
	
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

	public Instant getDateOfAssignment() {
		return dateOfAssignment;
	}

	public void setDateOfAssignment(Instant dateOfAssignment) {
		this.dateOfAssignment = dateOfAssignment;
	}

	public Instant getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Instant lastUpdate) {
		this.lastUpdate = lastUpdate;
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

	public Appointment getExam() {
		return exam;
	}

	public void setExam(Appointment exam) {
		this.exam = exam;
	}

	public Long getId() {
		return id;
	}

}
