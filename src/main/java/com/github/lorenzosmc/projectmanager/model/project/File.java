package com.github.lorenzosmc.projectmanager.model.project;

import javax.persistence.Lob;

public class File extends Resource{
	@Lob
	private byte[] data;
	
	//FIXME how to store type of file	
	private String typeOfFile;
	
	
	public File() {}
	
	public File(String uuid) {
		super(uuid);
	}

	public byte[] getData() {
		return data;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}

	
	public String getTypeOfFile() {
		return typeOfFile;
	}

	public void setTypeOfFile(String typeOfFile) {
		this.typeOfFile = typeOfFile;
	}
	
	
}
