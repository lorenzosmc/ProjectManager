package com.github.lorenzosmc.projectmanager.model.projectassignment;

import java.util.List;

import com.github.lorenzosmc.projectmanager.model.notification.Publisher;


public class Discussion extends Publisher{
	private List<Message> comments;
	
	public List<Message> getComments() {
		return List.copyOf(comments);
	}

	public void addMessage(Message message) {
		comments.add(message);
	}
	
	public void removeMessage(Message message) {
		comments.remove(message);
	}
}
