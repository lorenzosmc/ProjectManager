package com.github.lorenzosmc.projectmanager.model.context;

import java.time.Instant;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.github.lorenzosmc.projectmanager.model.notification.Publisher;
import com.github.lorenzosmc.projectmanager.model.project.Task;
import com.github.lorenzosmc.projectmanager.model.request.Request;
import com.github.lorenzosmc.projectmanager.model.user.User;
import com.github.lorenzosmc.projectmanager.model.workgroup.Workgroup;

@Entity
public class Context extends Publisher{
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User creator;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant creationDate;
	
	@OneToMany(mappedBy = "context")
	private List<Task> tasks;
	
	private boolean locked;
	
	private boolean hidden;
	
	// FIXME: better way to store passwords?
	private String password;
	
	@OneToMany(mappedBy = "context")
	private List<Tag> tags;
	
	@ManyToMany(mappedBy = "contexts")
	private List<FAQ> faqs;
	
	//TODO add methods and JPA
	private List<Request> requests;
	
	//TODO
	private List<ContextParticipation> participants;
	
	//TODO
	private List<Workgroup> workgroups;
	
	//TODO
	private List<ContextCollaboration> collaborations;
	
	

	//TODO override equals() and hashCode()
	
	public Context() {}
	
	public Context(String uuid) {
		super(uuid);
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
	
	public List<Task> getTasks() {
		//FIXME
		//return List.copyOf(tasks);
		return tasks;
	}

	public void addTask(Task task) {
		tasks.add(task);
	}
	
	public boolean removeTask(Task task) {
		return tasks.remove(task) ? true : false;
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
	
	public List<Tag> getTags() {
		//FIXME
		//return List.copyOf(tags);
		return tags;
	}

	public void addTag(Tag tag) {
		tags.add(tag);
	}
	
	public boolean removeTag(Tag tag) {
		return tags.remove(tag) ? true : false;
	}
	
	public List<FAQ> getFaqs() {
		//FIXME
		//return List.copyOf(faqs);
		return faqs;
	}

	public void addFAQ(FAQ faq) {
		faqs.add(faq);
	}
	
	public boolean removeFAQ(FAQ faq) {
		return faqs.remove(faq) ? true : false;
	}
}
