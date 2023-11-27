package com.github.lorenzosmc.projectmanager.model.project;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.github.lorenzosmc.projectmanager.model.notification.Publisher;

@Entity
public class Discussion extends Publisher{
	@OneToMany
	private List<Message> comments;
	
	
	//TODO override equals() and hashCode()

	public Discussion() {}
	
	public Discussion(String uuid) {
		super(uuid);
	}

	
	public List<Message> getComments() {
		//FIXME
		//return List.copyOf(comments);
		return comments;
	}
	
	public void setComments(List<Message> comments) {
		this.comments = comments;
	}
	
	public void addMessage(Message message) {
		comments.add(message);
	}
	
	public void removeMessage(Message message) {
		comments.remove(message);
	}
}
