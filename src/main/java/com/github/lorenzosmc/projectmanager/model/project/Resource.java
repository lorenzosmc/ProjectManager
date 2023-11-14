package com.github.lorenzosmc.projectmanager.model.project;

import java.time.Instant;
import java.util.List;

import com.github.lorenzosmc.projectmanager.model.user.User;

public abstract class Resource {
	private String name;
	private Instant creationDate;
	private User creator;
	private int size;
	private int revisionNumber;
	private Resource previousRevision;
	private Discussion discussion;

	public List<Resource> getResources() throws UnsupportedOperationByResource{
		throw new UnsupportedOperationByResource("Unable to retrieve resources from the resource.");
	}
	
	public void addElement(Resource resource) throws UnsupportedOperationByResource{
		throw new UnsupportedOperationByResource("Unable to add an element to the resource.");
	}
	
	public boolean removeElement(Resource resource) throws UnsupportedOperationByResource{
		throw new UnsupportedOperationByResource("Unable to remove an element from the resource.");
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

	//FIXME defensive copy
	public Discussion getDiscussion() {
		return discussion;
	}

	//FIXME defensive copy
	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}
}
