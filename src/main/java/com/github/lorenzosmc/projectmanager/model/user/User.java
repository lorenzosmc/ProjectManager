package com.github.lorenzosmc.projectmanager.model.user;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.github.lorenzosmc.projectmanager.model.BaseEntity;
import com.github.lorenzosmc.projectmanager.model.appointment.Appointment;
import com.github.lorenzosmc.projectmanager.model.appointment.AppointmentParticipation;
import com.github.lorenzosmc.projectmanager.model.context.Context;
import com.github.lorenzosmc.projectmanager.model.context.ContextCollaboration;
import com.github.lorenzosmc.projectmanager.model.context.ContextParticipation;
import com.github.lorenzosmc.projectmanager.model.notification.Notification;
import com.github.lorenzosmc.projectmanager.model.notification.Subscriber;
import com.github.lorenzosmc.projectmanager.model.project.Message;
import com.github.lorenzosmc.projectmanager.model.project.Project;
import com.github.lorenzosmc.projectmanager.model.project.Task;
import com.github.lorenzosmc.projectmanager.model.request.RequestParticipation;
import com.github.lorenzosmc.projectmanager.model.workgroup.Workgroup;
import com.github.lorenzosmc.projectmanager.model.workgroup.WorkgroupParticipation;

@Entity
public class User extends BaseEntity implements Subscriber{	
	private String academicEmail;
	
	private String secondaryEmail;
	
	private String name;
	
	private String surname;
	
	private String phoneNumber;
	
	private String username;
	
	// FIXME: better way to store passwords?
	private String password;
	
	@Lob
	private byte[] profilePicture;
	
	private boolean verified;
	
	// TODO how to model notification preferences?
	
	@OneToMany
	private List<Notification> readNotifications;
	
	@OneToMany
	private List<Notification> unreadNotifications;
	
	private String about;

	@OneToMany(mappedBy = "creator")
	private List<Message> messages;
	
	@OneToMany(mappedBy = "creator")
	private List<Project> createdProjects;
	
	@OneToMany(mappedBy = "creator")
	private List<Task> createdTasks;

	@OneToMany(mappedBy = "participant")
	private List<RequestParticipation> requestParticipations;
	
	@OneToMany(mappedBy = "creator")
	private List<Context> createdContexts;
	
	@OneToMany(mappedBy = "participant")
	private List<ContextParticipation> contextParticipations;

	@OneToMany(mappedBy = "creator")
	private List<Appointment> createdAppointments;
	
	@OneToMany(mappedBy = "participant")
	private List<AppointmentParticipation> appointmentParticipations;
	
	@OneToMany(mappedBy = "creator")
	private List<Workgroup> createdWorkgroups;
	
	@OneToMany(mappedBy = "participant")
	private List<WorkgroupParticipation> workgroupParticipations;

	@OneToMany(mappedBy = "collaborator")
	private List<ContextCollaboration> collaborations;


	//TODO override equals() and hashCode()
	
	public User() {}
	
	public User(String uuid) {
		super(uuid);
	}

	
	public void update(Notification notification) {
		this.addNotification(notification);
	}


	public List<Notification> getReadNotifications(){
		//FIXME defensive copy?
		return this.readNotifications;
	}

	public void setReadNotifications(List<Notification> notifications) {
		this.readNotifications = notifications;
	}
	
	public boolean readNotification(Notification notification) {
		int indexOfNotification = unreadNotifications.indexOf(notification);

		if (indexOfNotification >= 0) {
			Notification unviewedNotification = unreadNotifications.get(indexOfNotification);
			unviewedNotification.setViewed(true);
			unreadNotifications.remove(unviewedNotification);
			readNotifications.add(unviewedNotification);

			return true;
		}

		return false;
	}

	public void addNotification(Notification notification) {
		unreadNotifications.add(notification);
	}

	public boolean removeNotification(Notification notification) {
		if (readNotifications.contains(notification))
			return readNotifications.remove(notification);

		if (unreadNotifications.contains(notification))
			return unreadNotifications.remove(notification);

		return false;
	}

	public List<Notification> getUnreadNotifications(){
		return this.unreadNotifications;
	}
	
	public void setUnreadNotifications(List<Notification> notifications) {
		this.unreadNotifications = notifications;
	}
	
	public boolean unreadNotification(Notification notification) {
		int indexOfNotification = readNotifications.indexOf(notification);

		if (indexOfNotification >= 0) {
			Notification readNotification = readNotifications.get(indexOfNotification);
			readNotification.setViewed(false);
			readNotifications.remove(readNotification);
			unreadNotifications.add(readNotification);

			return true;
		}

		return false;
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

	
	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
	
	public List<Context> getCreatedContexts() {
		//FIXME
		//return List.copyOf(createdContexts);
		return createdContexts;
	}

	public void setCreatedContexts(List<Context> contexts) {
		this.createdContexts = contexts;
	}
	
	public void addCreatedContext(Context context) {
		createdContexts.add(context);
	}
	
	public boolean removeCreatedContext(Context context) {
		return createdContexts.remove(context) ? true : false;
	}

	
	public List<Project> getCreatedProjects() {
		//FIXME
		//return List.copyOf(createdProjects);
		return createdProjects;
	}
	
	public void setCreatedProjects(List<Project> projects) {
		this.createdProjects = projects;
	}
	
	public void addCreatedProject(Project project) {
		createdProjects.add(project);
	}
	
	public boolean removeCreatedProject(Project project){
		return createdProjects.remove(project) ? true : false;
	}
	
	
	public List<Task> getCreatedTasks() {
		//FIXME
		//return List.copyOf(createdTasks);
		return createdTasks;
	}
	
	public void setCreatedTasks(List<Task> tasks) {
		this.createdTasks = tasks;
	}
	
	public void addCreatedProject(Task task) {
		createdTasks.add(task);
	}
	
	public boolean removeCreatedProject(Task task){
		return createdTasks.remove(task) ? true : false;
	}

	
	
	public List<Message> getMessages() {
		return messages;
	}

	
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	
	public void addMessage(Message message) {
		messages.add(message);
	}
	
	public boolean removeMessage(Message message){
		return messages.remove(message) ? true : false;
	}

	
	public List<RequestParticipation> getRequestParticipations() {
		return requestParticipations;
	}

	
	public void setRequestParticipations(List<RequestParticipation> requestParticipations) {
		this.requestParticipations = requestParticipations;
	}

	
	public void addRequestParticipation(RequestParticipation participation) {
		requestParticipations.add(participation);
	}
	
	public boolean removeRequestParticipation(RequestParticipation participation){
		return requestParticipations.remove(participation) ? true : false;
	}
	
	
	public List<ContextParticipation> getContextParticipations() {
		return contextParticipations;
	}

	
	public void setContextParticipations(List<ContextParticipation> contextParticipations) {
		this.contextParticipations = contextParticipations;
	}

	
	public void addContextParticipation(ContextParticipation participation) {
		contextParticipations.add(participation);
	}
	
	public boolean removeContextParticipation(ContextParticipation participation){
		return contextParticipations.remove(participation) ? true : false;
	}
	
	
	public List<Appointment> getCreatedAppointments() {
		return createdAppointments;
	}

	
	public void setCreatedAppointments(List<Appointment> createdAppointments) {
		this.createdAppointments = createdAppointments;
	}

	
	public void addCreatedAppointment(Appointment appointment) {
		createdAppointments.add(appointment);
	}
	
	public boolean removeCreatedAppointments(Appointment appointment){
		return createdAppointments.remove(appointment) ? true : false;
	}
	
	
	public List<AppointmentParticipation> getAppointmentParticipations() {
		return appointmentParticipations;
	}

	
	public void setAppointmentParticipations(List<AppointmentParticipation> appointmentParticipations) {
		this.appointmentParticipations = appointmentParticipations;
	}

	
	public void addAppointmentParticipation(AppointmentParticipation participation) {
		appointmentParticipations.add(participation);
	}
	
	public boolean removeCreatedAppointments(AppointmentParticipation participation){
		return appointmentParticipations.remove(participation) ? true : false;
	}
	
	
	public List<Workgroup> getCreatedWorkgroups() {
		return createdWorkgroups;
	}

	
	public void setCreatedWorkgroups(List<Workgroup> createdWorkgroups) {
		this.createdWorkgroups = createdWorkgroups;
	}

	
	public void addCreatedWorkgroup(Workgroup workgroup) {
		createdWorkgroups.add(workgroup);
	}
	
	public boolean removeCreatedWorkgroup(Workgroup workgroup){
		return createdWorkgroups.remove(workgroup) ? true : false;
	}
	
	
	public List<WorkgroupParticipation> getWorkgroupParticipations() {
		return workgroupParticipations;
	}

	
	public void setWorkgroupParticipations(List<WorkgroupParticipation> workgroupParticipations) {
		this.workgroupParticipations = workgroupParticipations;
	}

	
	public void addWorkgroupParticipation(WorkgroupParticipation participation) {
		workgroupParticipations.add(participation);
	}
	
	public boolean removeWorkgroupParticipation(WorkgroupParticipation participation){
		return workgroupParticipations.remove(participation) ? true : false;
	}
		
	
	public List<ContextCollaboration> getCollaborations() {
		return collaborations;
	}
	
	public void setCollaborations(List<ContextCollaboration> collaborations) {
		this.collaborations = collaborations;
	}

	public void addContextCollaboration(ContextCollaboration collaboration) {
		collaborations.add(collaboration);
	}
	
	public boolean removeContextCollaboration(ContextCollaboration collaboration){
		return collaborations.remove(collaboration) ? true : false;
	}
}
