package com.github.lorenzosmc.projectmanager.model.project;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;
import com.github.lorenzosmc.projectmanager.model.context.Tag;
import com.github.lorenzosmc.projectmanager.model.user.User;

@Embeddable
public class TaskTagAssignment{
	@OneToOne
	private Tag tag;
	
	@OneToOne
	private User assigner;

	
	//TODO override equals() and hashCode()

	public User getAssigner() {
		return assigner;
	}

	public void setAssigner(User assigner) {
		this.assigner = assigner;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}	
}
