package com.github.lorenzosmc.projectmanager.model.projectassignment;

import java.util.List;

public class Folder extends Resource {
	private List<Resource> resources;

	@Override
	public List<Resource> getResources(){
		return List.copyOf(resources);
	}
	
	@Override
	public void addElement(Resource resource) {
		resources.add(resource);
	}

	@Override
	public boolean removeElement(Resource resource) {
		return resources.remove(resource) ? true : false;
	}	
}
