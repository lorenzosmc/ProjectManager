package com.github.lorenzosmc.projectmanager.model.context;

import java.time.Instant;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;

@Entity
public class Tag extends BaseEntity{
	private String name;

	@Enumerated(EnumType.STRING)
	private TagType type;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant creationDate;
	
	//FIXME need to use java.time.OffsetDateTime instead? Don't see JPA 2.2 supporting java.time.Instant
	private Instant lastModified;

	
	public Tag() {}
	
	public Tag(String uuid) {
		super(uuid);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TagType getType() {
		return type;
	}

	public void setType(TagType type) {
		this.type = type;
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
}
