package com.github.lorenzosmc.projectmanager.model.user;

import java.util.List;

import com.github.lorenzosmc.projectmanager.model.context.Context;
import com.github.lorenzosmc.projectmanager.model.notification.Notification;
import com.github.lorenzosmc.projectmanager.model.notification.Subscriber;
import com.github.lorenzosmc.projectmanager.model.project.Project;

public class User implements Subscriber {
	private Long id;
	private String academicEmail;
	private String secondaryEmail;
	private String name;
	private String surname;
	private String phoneNumber;
	private String username;
	// FIXME: better way to store passwords?
	private String password;
	private byte[] profilePicture;
	private boolean verified;
	// TODO how to model notification preferences?
	private List<Notification> viewedNotifications;
	private List<Notification> unviewedNotifications;
	private UserRole role;
	private String about;
	private List<Context> createdContexts;
	private List<Project> createdProjects;

	public void update(Notification notification) {
		this.addNotification(notification);
	}

	public void addNotification(Notification notification) {
		unviewedNotifications.add(notification);
	}

	public boolean removeNotification(Notification notification) {
		if (viewedNotifications.contains(notification))
			return viewedNotifications.remove(notification);

		if (unviewedNotifications.contains(notification))
			return unviewedNotifications.remove(notification);

		return false;
	}

	public boolean viewNotification(Notification notification) {
		int indexOfNotification = unviewedNotifications.indexOf(notification);

		if (indexOfNotification >= 0) {
			Notification unviewedNotification = unviewedNotifications.get(indexOfNotification);
			unviewedNotification.setViewed(true);
			unviewedNotifications.remove(unviewedNotification);
			viewedNotifications.add(unviewedNotification);

			return true;
		}

		return false;
	}

	public boolean unViewNotification(Notification notification) {
		int indexOfNotification = viewedNotifications.indexOf(notification);

		if (indexOfNotification >= 0) {
			Notification viewedNotification = viewedNotifications.get(indexOfNotification);
			viewedNotification.setViewed(false);
			viewedNotifications.remove(viewedNotification);
			unviewedNotifications.add(viewedNotification);

			return true;
		}

		return false;
	}
	
	public Long getId() {
		return id;
	}

	public String getAcademicEmail() {
		return academicEmail;
	}

	public void setAcademicEmail(String academicEmail) {
		this.academicEmail = academicEmail;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// FIXME: better way to get passwords?
	public String getPassword() {
		return password;
	}

	// FIXME: better way to set passwords?
	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
	public List<Context> getCreatedContexts() {
		return List.copyOf(createdContexts);
	}

	public void addCreatedContext(Context context) {
		createdContexts.add(context);
	}
	
	public boolean removeCreatedContext(Context context) {
		return createdContexts.remove(context) ? true : false;
	}

	public List<Project> getCreatedProjects() {
		return List.copyOf(createdProjects);
	}
	
	public void addCreatedProject(Project project) {
		createdProjects.add(project);
	}
	
	public boolean removeCreatedProject(Project project){
		return createdProjects.remove(project) ? true : false;
	}
}
