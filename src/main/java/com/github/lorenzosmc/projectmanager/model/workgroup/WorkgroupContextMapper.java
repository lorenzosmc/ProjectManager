package com.github.lorenzosmc.projectmanager.model.workgroup;

import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.context.Context;

public class WorkgroupContextMapper {
	private Workgroup workgroup;
	private Context context;
	private Instant dateOfAssignment;

	public Workgroup getWorkgroup() {
		return workgroup;
	}

	public void setWorkgroup(Workgroup workgroup) {
		this.workgroup = workgroup;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public Instant getDateOfAssignment() {
		return dateOfAssignment;
	}

	public void setDateOfAssignment(Instant dateOfAssignment) {
		this.dateOfAssignment = dateOfAssignment;
	}
}
