package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.github.lorenzosmc.projectmanager.model.notification.Publisher;
import com.github.lorenzosmc.projectmanager.model.user.User;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Resource extends Publisher{
	private String name;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant creationDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User creator;
	
	private int size;
	
	private int revisionNumber;
	
	//FIXME is this a problem for JPA?
	@OneToOne
	private Resource previousRevision;
	
	
	@OneToOne(optional = false)
	private Discussion discussion;

	
	//TODO override equals() and hashCode()

	public Resource() {}
	
	public Resource(String uuid) {
		super(uuid);
	}

	public List<Resource> getResource() throws UnsupportedOperationByResource{
		throw new UnsupportedOperationByResource("Unable to retrieve resources.");
	}

	public void addResource(Resource resource) throws UnsupportedOperationByResource{
		throw new UnsupportedOperationByResource("Unable to add a resource.");
	}

	public boolean removeResource(Resource resource) throws UnsupportedOperationByResource{
		throw new UnsupportedOperationByResource("Unable to remove a resource.");
	}
	
	public void setResource(Resource resource) throws UnsupportedOperationByResource{
		throw new UnsupportedOperationByResource("Unable to set resiyrces.");
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	
	public int getRevisionNumber() {
		return revisionNumber;
	}

	public void setRevisionNumber(int revisionNumber) {
		this.revisionNumber = revisionNumber;
	}

	
	public Resource getPreviousRevision() {
		return previousRevision;
	}

	public void setPreviousRevision(Resource previousRevision) {
		this.previousRevision = previousRevision;
	}

	
	public Discussion getDiscussion() {
		return discussion;
	}

	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}
}
