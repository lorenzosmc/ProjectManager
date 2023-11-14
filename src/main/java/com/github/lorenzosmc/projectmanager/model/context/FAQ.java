package com.github.lorenzosmc.projectmanager.model.context;

import java.time.Instant;
import java.util.List;

import com.github.lorenzosmc.projectmanager.model.project.Discussion;
import com.github.lorenzosmc.projectmanager.model.project.Message;
import com.github.lorenzosmc.projectmanager.model.project.Project;
import com.github.lorenzosmc.projectmanager.model.project.Resource;
import com.github.lorenzosmc.projectmanager.model.project.Topic;

public class FAQ {
	private String question;
	// FIXME support for rich text?
	private String answer;
	private FAQStatus status;
	private Instant creationDate;
	private Instant lastModified;
	private boolean visible;
	private List<Context> contexts;
	private List<Project> citedProjects;
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
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public List<Context> getContexts() {
		return List.copyOf(contexts);
	}
	
	public void addContext(Context context) {
		contexts.add(context);
	}
	
	public boolean removeContext(Context context) {
		return contexts.remove(context) ? true : false;
	}
	
	public List<Project> getCitedProjects() {
		return List.copyOf(citedProjects);
	}
	
	public void addCitedProject(Project project) {
		citedProjects.add(project);
	}
	
	public boolean removeCitedProject(Project project) {
		return citedProjects.remove(project) ? true : false;
	}
	
	public List<Resource> getCitedResources() {
		return List.copyOf(citedResources);
	}

	public void addCitedResource(Resource citedResource) {
		citedResources.add(citedResource);
	}
	
	public boolean removeCitedResource(Resource citedResource) {
		return citedResources.remove(citedResource) ? true : false;
	}
		
	public List<Topic> getCitedTopics() {
		return List.copyOf(citedTopics);
	}

	public void addCitedTopic(Topic topic) {
		citedTopics.add(topic);
	}
	
	public boolean removeCitedTopic(Topic topic) {
		return citedTopics.remove(topic) ? true : false;
	}
	
	public List<Discussion> getCitedDiscussions() {
		return List.copyOf(citedDiscussions);
	}

	public void addCitedDiscussion(Discussion discussion) {
		citedDiscussions.add(discussion);
	}
	
	public boolean removeCitedDiscussion(Discussion discussion) {
		return citedDiscussions.remove(discussion) ? true : false;
	}
	
	public List<Message> getCitedMessages() {
		return List.copyOf(citedMessages);
	}

	public void addCitedMessage(Message message) {
		citedMessages.add(message);
	}
	
	public boolean removeCitedMessage(Message message) {
		return citedMessages.remove(message) ? true : false;
	}
}
