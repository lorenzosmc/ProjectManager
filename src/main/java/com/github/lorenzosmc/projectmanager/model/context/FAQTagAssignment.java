package com.github.lorenzosmc.projectmanager.model.context;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;
import com.github.lorenzosmc.projectmanager.model.user.User;

@Entity
public class FAQTagAssignment extends BaseEntity{
	@OneToOne(optional = false)
	private Tag tag;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant dateOfAssignment;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User assigner;


	//TODO override equals() and hashCode()

	public FAQTagAssignment() {}
	
	public FAQTagAssignment(String uuid) {
		super(uuid);
	}

	
	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	
	public Instant getDateOfAssignment() {
		return dateOfAssignment;
	}

	public void setDateOfAssignment(Instant dateOfAssignment) {
		this.dateOfAssignment = dateOfAssignment;
	}

	
	public User getAssigner() {
		return assigner;
	}

	public void setAssigner(User assigner) {
		this.assigner = assigner;
	}
}
