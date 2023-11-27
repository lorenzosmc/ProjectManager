package com.github.lorenzosmc.projectmanager.model;

import java.util.UUID;

import com.github.lorenzosmc.projectmanager.model.appointment.*;
import com.github.lorenzosmc.projectmanager.model.context.*;
import com.github.lorenzosmc.projectmanager.model.notification.*;
import com.github.lorenzosmc.projectmanager.model.project.*;
import com.github.lorenzosmc.projectmanager.model.request.*;
import com.github.lorenzosmc.projectmanager.model.user.*;
import com.github.lorenzosmc.projectmanager.model.workgroup.*;

//FIXME why not just put UUID responsibility in BaseEntity void constructor? And remove single-argument constructor. (DRY)
public class ModelFactory {
	private ModelFactory() {};
	
	// com.github.lorenzosmc.projectmanager.model.appointment
	public static Appointment appointment() {
		return new Appointment(UUID.randomUUID().toString());
	}
	
	public static AppointmentParticipation appointmentParticipation() {
		return new AppointmentParticipation(UUID.randomUUID().toString());
	}
	
	// com.github.lorenzosmc.projectmanager.model.context
	public static Context context() {
		return new Context(UUID.randomUUID().toString());
	}
	
	public static ContextCollaboration contextCollaboration() {
		return new ContextCollaboration(UUID.randomUUID().toString());
	}
	
	public static ContextParticipation contextParticipation() {
		return new ContextParticipation(UUID.randomUUID().toString());
	}
	
	public static FAQ faq() {
		return new FAQ(UUID.randomUUID().toString());
	}
	
	public static FAQTagAssignment faqTagAssignment() {
		return new FAQTagAssignment(UUID.randomUUID().toString());
	}
	public static Tag tag() {
		return new Tag(UUID.randomUUID().toString());
	}
	
	
	// com.github.lorenzosmc.projectmanager.model.notification
	public static Notification notification() {
		return new Notification(UUID.randomUUID().toString());
	}
	
	
	// com.github.lorenzosmc.projectmanager.model.project
	public static Discussion discussion() {
		return new Discussion(UUID.randomUUID().toString());
	}
	
	public static File file() {
		return new File(UUID.randomUUID().toString());
	}
	
	public static Folder folder() {
		return new Folder(UUID.randomUUID().toString());
	}
	
	public static Message message() {
		return new Message(UUID.randomUUID().toString());
	}
	
	public static Project project() {
		return new Project(UUID.randomUUID().toString());
	}
	
	public static Task task() {
		return new Task(UUID.randomUUID().toString());
	}
	
	public static TaskProgressReview taskProgressReview() {
		return new TaskProgressReview(UUID.randomUUID().toString());
	}
	
	public static Topic topic() {
		return new Topic(UUID.randomUUID().toString());
	}
	
	
	// com.github.lorenzosmc.projectmanager.model.request
	public static Request request() {
		return new Request(UUID.randomUUID().toString());
	}
	
	public static RequestParticipation requestParticipation() {
		return new RequestParticipation(UUID.randomUUID().toString());
	}
	
	
	// com.github.lorenzosmc.projectmanager.model.user
	public static User user() {
		return new User(UUID.randomUUID().toString());
	}
	
	
	// com.github.lorenzosmc.projectmanager.model.workgroup
	public static Workgroup workgroup() {
		return new Workgroup(UUID.randomUUID().toString());
	}
	
	public static WorkgroupParticipation membership() {
		return new WorkgroupParticipation(UUID.randomUUID().toString());
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
}
