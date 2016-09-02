package com.perficient.employee.model;

import java.io.Serializable;

public class ProjectDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6902743229934015717L;

	private Long projectId;
	private String projectName;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "ProjectDto [projectId=" + projectId + ", projectName=" + projectName + "]";
	}
}
