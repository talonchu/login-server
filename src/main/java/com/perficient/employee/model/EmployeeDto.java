package com.perficient.employee.model;

import java.io.Serializable;
import java.util.List;

public class EmployeeDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6390376672400377034L;
	private Long employeeId;
	private String firstName;
	private String lastName;
	private List<ProjectDto> projectDto;

	public EmployeeDto() {
		//this is a constra
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<ProjectDto> getProjectDto() {
		return projectDto;
	}

	public void setProjectDto(List<ProjectDto> projectDto) {
		this.projectDto = projectDto;
	}

	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", projectDto=" + projectDto + "]";
	}

}
