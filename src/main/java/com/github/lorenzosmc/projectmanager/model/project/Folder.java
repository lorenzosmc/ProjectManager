package com.github.lorenzosmc.projectmanager.model.project;

import java.util.List;

import javax.persistence.OneToMany;

public class Folder extends Resource {
	@OneToMany
	private List<Resource> resources;


	//TODO override equals() and hashCode()

	public Folder() {}
	
	public Folder(String uuid) {
		super(uuid);
	}

	@Override
	public List<Resource> getResource(){
		//FIXME
		//return List.copyOf(resources);
		return resources;
	}
	
	@Override
	public void addResource(Resource resource) {
		resources.add(resource);
	}

	@Override
	public boolean removeResource(Resource resource) {
		return resources.remove(resource) ? true : false;
	}	
}
