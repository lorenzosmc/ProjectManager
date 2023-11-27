package com.github.lorenzosmc.projectmanager.model.notification;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;

@Entity
//FIXME how to deal with multi-level hierarchies? e.g. Publisher -> Resource -> Folder/File
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Publisher extends BaseEntity{
	@OneToMany
	private List<Subscriber> subscribers;
	
	
	public Publisher() {
		super();
	}
	
	public Publisher(String uuid) {
		super(uuid);
	}
	
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
