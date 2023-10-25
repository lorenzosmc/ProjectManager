package com.github.lorenzosmc.projectmanager.model.project;


public class Project {
	private Long id;
	private String name;
	//FIXME 'statement' should allow for storing rich text
	private String statement;
	private ProjectStatus status;
	private boolean visible;
	
	//FIXME does this have any business being here? Perhaps it should go in the Business Logic.
	public boolean isDrafted() {
		return status == ProjectStatus.DRAFTED;
	}

	//FIXME does this have any business being here? Perhaps it should go in the Business Logic.
	public boolean isUnassigned() {
		return status == ProjectStatus.UNASSIGNED;
	}
	
	//FIXME does this have any business being here? Perhaps it should go in the Business Logic.
	public boolean isActive() {
		return status == ProjectStatus.ACTIVE;
	}
	
	//FIXME does this have any business being here? Perhaps it should go in the Business Logic.
	public boolean isArchived() {
		return status == ProjectStatus.ARCHIVED;
	}
	
	//FIXME does this have any business being here? Perhaps it should go in the Business Logic.
	public boolean advanceState() {
		switch(status) {
			case DRAFTED:
				status = ProjectStatus.ACTIVE;
				break;
			
			case UNASSIGNED:
				status = ProjectStatus.ACTIVE;
				break;
				
			case ACTIVE:
				status = ProjectStatus.ARCHIVED;
				break;
				
			default:
				return false;
		}
		
		return true;
	}
	
	//FIXME does this have any business being here? Perhaps it should go in the Business Logic.
	public boolean regressState() {
		switch(status) {
		case ARCHIVED:
			status = ProjectStatus.ACTIVE;
			break;
		
		//FIXME it could either be UNASSIGNED (if Professor created it) or DRAFTED (if Student created it). Pass in parameters boolean 'professorCreated' perhaps.
		case ACTIVE:
			status = ProjectStatus.UNASSIGNED;
			break;
						
		default:
			return false;
	}
	
	return true;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
