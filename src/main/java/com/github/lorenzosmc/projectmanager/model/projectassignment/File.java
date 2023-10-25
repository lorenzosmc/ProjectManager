package com.github.lorenzosmc.projectmanager.model.projectassignment;

public class File {
	private byte[] data;
	//FIXME how to store type of file	

	//FIXME defensive copy
	public byte[] getData() {
		return data;
	}
	
	//FIXME defensive copy
	public void setData(byte[] data) {
		this.data = data;
	}
	
	
}
