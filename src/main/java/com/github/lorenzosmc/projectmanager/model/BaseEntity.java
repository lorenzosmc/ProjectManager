package com.github.lorenzosmc.projectmanager.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	//FIXME is GenerationType.TABLE better?
	//FIXME should it be protected? "The entity has no primary key attribute defined"
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//FIXME is @Column(unique=true) needed?
	private String uuid;
	
	//FIXME is there a need for this? (reasoning would be: there is no default constructor)
	protected BaseEntity() {};
	
	public BaseEntity(String uuid) {
		//FIXME exception in a constructor?
		if(uuid == null)
			throw new IllegalArgumentException("uuid cannot be null");
		this.uuid = uuid;
	}
	
	public Long getId() {
		return id;
	}
	
	//FIXME protected or package-private? (for JPA to be able to use)
	protected void setId(Long id) {
		this.id = id;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void SetUuid(String uuid) {
		this.uuid = uuid;
	}
	
	//FIXME can two BaseEntity have different id (e.g. one is null) but equal uuid?
	@Override
	public int hashCode() {
	    int result = 17;
	    result = 31 * result + ((id == null) ? 0 : id.hashCode());
	    result = 31 * result + ((uuid == null) ? 0 : uuid.hashCode());
	    return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof BaseEntity))
			return false;

		return uuid.equals(((BaseEntity) obj).getUuid());		
	}
	
	
}
