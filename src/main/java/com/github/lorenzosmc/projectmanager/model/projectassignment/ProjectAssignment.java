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
	// FIXME how is progress measured?
	private int progress;
	private Appointment exam;
	private List<ProjectProgressReview> reviews;
	private List<Topic> topics;
	private List<Resource> resources;
	
	//FIXME defensive copy
	public void addReview(ProjectProgressReview review) {
		reviews.add(review);
	}
	
	public void removeReview(ProjectProgressReview review) {
		reviews.remove(review);
	}
	
	//FIXME defensive copy
	public void addResource(Resource resource) {
		resources.add(resource);
	}
	
	public void removeResource(Resource resource) {
		resources.remove(resource);
	}

	//FIXME defensive copy
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void removeTopic(Topic topic) {
		topics.remove(topic);
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
	
	// FIXME how is progress measured?
	public int getProgress() {
		return progress;
	}

	// FIXME how is progress measured?
	public void setProgress(int progress) {
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
