package com.github.lorenzosmc.projectmanager.model.notification;

import java.util.List;

public abstract class Publisher {
	private List<Subscriber> subscribers;
	
	public void attatch(Subscriber subscriber){
		subscribers.add(subscriber);
	}
	
	public boolean detatch(Subscriber subscriber) {
		if(subscribers.contains(subscriber))
			return subscribers.remove(subscriber);
			
		return false;
	}
	
	protected void notifySubscribers(Notification notification) {
		for(Subscriber subscriber : subscribers) 
			subscriber.update(notification);
	}
	
}
