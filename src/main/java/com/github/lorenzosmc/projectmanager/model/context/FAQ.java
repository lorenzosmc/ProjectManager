package com.github.lorenzosmc.projectmanager.model.context;

import java.time.Instant;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;
import com.github.lorenzosmc.projectmanager.model.project.Discussion;
import com.github.lorenzosmc.projectmanager.model.project.Message;
import com.github.lorenzosmc.projectmanager.model.project.Project;
import com.github.lorenzosmc.projectmanager.model.project.Resource;
import com.github.lorenzosmc.projectmanager.model.project.Task;
import com.github.lorenzosmc.projectmanager.model.project.Topic;

public class FAQ extends BaseEntity{
	private String question;
	
	private boolean posted;
	
	// FIXME support for rich text?
	private String answer;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant creationDate;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant lastModified;
	
	private boolean visible;
	
	@ManyToMany
	private List<Context> contexts;
	
	@OneToMany
	private List<Project> citedProjects;
	
	@OneToMany
	private List<Task> citedTasks;
	
	@OneToMany
	private List<Resource> citedResources;
	
	@OneToMany
	private List<Topic> citedTopics;
	
	@OneToMany
	private List<Discussion> citedDiscussions;
	
	@OneToMany
	private List<Message> citedMessages;

	@OneToMany
	private List<FAQTagAssignment> tagAssignments;
	
	
	//TODO override equals() and hashCode()
	
	public FAQ() {}
	
	public FAQ(String uuid) {
		super(uuid);
	}

	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	
	public boolean isPosted() {
		return posted;
	}

	public void setPosted(boolean posted) {
		this.posted = posted;
	}
	
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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
		//FIXME
		//return List.copyOf(contexts);
		return contexts;
	}
	
	public void addContext(Context context) {
		contexts.add(context);
	}
	
	public boolean removeContext(Context context) {
		return contexts.remove(context) ? true : false;
	}
	
	public void setContexts(List<Context> contexts) {
		this.contexts = contexts;
	}

	
	public List<Project> getCitedProjects() {
		//FIXME
		//return List.copyOf(citedProjects);
		return citedProjects;
	}
	
	public void addCitedProject(Project project) {
		citedProjects.add(project);
	}
	
	public boolean removeCitedProject(Project project) {
		return citedProjects.remove(project) ? true : false;
	}
	
	public void setCitedProjects(List<Project> citedProjects) {
		this.citedProjects = citedProjects;
	}

	
	public List<Task> getCitedTasks() {
		//FIXME
		//return List.copyOf(citedTasks);
		return citedTasks;
	}
	
	public void addCitedTask(Task task) {
		citedTasks.add(task);
	}
	
	public boolean removeCitedTask(Task task) {
		return citedTasks.remove(task) ? true : false;
	}
	
	public void setCitedTasks(List<Task> citedTasks) {
		this.citedTasks = citedTasks;
	}

	
	public List<Resource> getCitedResources() {
		//FIXME
		//return List.copyOf(citedResources);
		return citedResources;
	}

	public void addCitedResource(Resource citedResource) {
		citedResources.add(citedResource);
	}
	
	public boolean removeCitedResource(Resource citedResource) {
		return citedResources.remove(citedResource) ? true : false;
	}
	
	public void setCitedResources(List<Resource> citedResources) {
		this.citedResources = citedResources;
	}

	
	public List<Topic> getCitedTopics() {
		//FIXME
		//return List.copyOf(citedTopics);
		return citedTopics;
	}

	public void addCitedTopic(Topic topic) {
		citedTopics.add(topic);
	}
	
	public boolean removeCitedTopic(Topic topic) {
		return citedTopics.remove(topic) ? true : false;
	}
	
	public void setCitedTopics(List<Topic> citedTopics) {
		this.citedTopics = citedTopics;
	}

	
	public List<Discussion> getCitedDiscussions() {
		//FIXME
		//return List.copyOf(citedDiscussions);
		return citedDiscussions;
	}

	public void addCitedDiscussion(Discussion discussion) {
		citedDiscussions.add(discussion);
	}
	
	public boolean removeCitedDiscussion(Discussion discussion) {
		return citedDiscussions.remove(discussion) ? true : false;
	}
	
	public void setCitedDiscussions(List<Discussion> citedDiscussions) {
		this.citedDiscussions = citedDiscussions;
	}

	
	public List<Message> getCitedMessages() {
		//FIXME
		//return List.copyOf(citedMessages);
		return citedMessages;
	}

	public void addCitedMessage(Message message) {
		citedMessages.add(message);
	}
	
	public boolean removeCitedMessage(Message message) {
		return citedMessages.remove(message) ? true : false;
	}

	public void setCitedMessages(List<Message> citedMessages) {
		this.citedMessages = citedMessages;
	}

	
	public List<FAQTagAssignment> getTagAssignments() {
		//FIXME
		return tagAssignments;
	}

	public void addTagAssignment(FAQTagAssignment assignment) {
		//FIXME parameter validation
		tagAssignments.add(assignment);
	}
	
	public boolean removeTagAssignment(FAQTagAssignment assignment) {
		return tagAssignments.remove(assignment) ? true : false;
	}
	
	public void setTagAssignments(List<FAQTagAssignment> tagAssignments) {
		this.tagAssignments = tagAssignments;
	}	








}
