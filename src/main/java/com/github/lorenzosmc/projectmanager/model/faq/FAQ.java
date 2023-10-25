package com.github.lorenzosmc.projectmanager.model.faq;

import java.time.Instant;
import java.util.List;

import com.github.lorenzosmc.projectmanager.model.project.Project;
import com.github.lorenzosmc.projectmanager.model.projectassignment.Discussion;
import com.github.lorenzosmc.projectmanager.model.projectassignment.Message;
import com.github.lorenzosmc.projectmanager.model.projectassignment.ProjectAssignment;
import com.github.lorenzosmc.projectmanager.model.projectassignment.Resource;
import com.github.lorenzosmc.projectmanager.model.projectassignment.Topic;

public class FAQ {
	private String question;
	// FIXME support for rich text?
	private String answer;
	private FAQStatus status;
	private Instant creationDate;
	private Instant lastModified;
	private List<Project> citedProjects;
	private List<ProjectAssignment> citedProjectAssignments;
	private List<Resource> citedResources;
	private List<Topic> citedTopics;
	private List<Discussion> citedDiscussions;
	private List<Message> citedMessages;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public FAQStatus getStatus() {
		return status;
	}

	public void setStatus(FAQStatus status) {
		this.status = status;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	public Instant getLastModified() {
		return lastModified;
	}

	public void setLastModified(Instant lastModified) {
		this.lastModified = lastModified;
	}
	
	public void addCitedProject(Project project) {
		citedProjects.add(project);
	}
	
	public boolean removeCitedProject(Project project) {
		return citedProjects.remove(project) ? true : false;
	}
	
	public void addCitedProjectAssignment(ProjectAssignment projectAssignment) {
		citedProjectAssignments.add(projectAssignment);
	}
	
	public boolean removeCitedProjectAssignment(ProjectAssignment projectAssignment) {
		return citedProjectAssignments.remove(projectAssignment) ? true : false;
	}
	
	public void addCitedResource(Resource citedResource) {
		citedResources.add(citedResource);
	}
	
	public boolean removeCitedResource(Resource citedResource) {
		return citedResources.remove(citedResource) ? true : false;
	}
		
	public void addCitedTopic(Topic topic) {
		citedTopics.add(topic);
	}
	
	public boolean removeCitedTopic(Topic topic) {
		return citedTopics.remove(topic) ? true : false;
	}
	
	public void addCitedDiscussion(Discussion discussion) {
		citedDiscussions.add(discussion);
	}
	
	public boolean removeCitedDiscussion(Discussion discussion) {
		return citedDiscussions.remove(discussion) ? true : false;
	}
	
	public void addCitedMessage(Message message) {
		citedMessages.add(message);
	}
	
	public boolean removeCitedMessage(Message message) {
		return citedMessages.remove(message) ? true : false;
	}
}
