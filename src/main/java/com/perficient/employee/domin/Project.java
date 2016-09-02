package com.perficient.employee.domin;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2118070816999118355L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long projectId;
	private String projectName;
	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;

	protected Project() {
		//this is a constra
	}

	public Project(String projectName, Employee employee) {
		this.projectName = projectName;
		this.employee = employee;
	}

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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", employee=" + employee + "]";
	}

}
