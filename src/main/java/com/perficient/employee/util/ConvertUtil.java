package com.perficient.employee.util;

import java.util.ArrayList;
import java.util.List;

import com.perficient.employee.domin.Employee;
import com.perficient.employee.domin.Project;
import com.perficient.employee.domin.Role;
import com.perficient.employee.domin.User;
import com.perficient.employee.model.EmployeeDto;
import com.perficient.employee.model.ProjectDto;
import com.perficient.employee.model.RoleDto;
import com.perficient.employee.model.UserDto;

public class ConvertUtil {
	private ConvertUtil(){
		
	}
	public static EmployeeDto convertFromEmployee(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		if (employee != null) {
			employeeDto.setEmployeeId(employee.getEmployeeId());
			employeeDto.setFirstName(employee.getFirstName());
			employeeDto.setLastName(employee.getLastName());
			List<Project> projects = employee.getProject();
			List<ProjectDto> list = new ArrayList();
			for (Project pro : projects) {
				ProjectDto projectDto = new ProjectDto();
				projectDto.setProjectId(pro.getProjectId());
				projectDto.setProjectName(pro.getProjectName());
				list.add(projectDto);
			}
			employeeDto.setProjectDto(list);
			return employeeDto;
		}
		return null;
	}
	public static UserDto convertFromUser(User user){
		UserDto userDto = new UserDto();
		if (user != null) {
			userDto.setUserId(user.getUserId());
			userDto.setUserName(user.getUserName());
			userDto.setPassword(user.getPassword());
			List<Role> roles = user.getRole();
			List<RoleDto> roleDtos = new ArrayList();
			for (Role role : roles) {
				RoleDto roleDto = new RoleDto();
				roleDto.setRoleId(role.getRoleId());
				roleDto.setRoleName(role.getRoleName());
				roleDtos.add(roleDto);
			}
			userDto.setRoleDto(roleDtos);
			return userDto;
		}
		return null;
	}
}
