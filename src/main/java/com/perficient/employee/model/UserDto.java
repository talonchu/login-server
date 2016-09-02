package com.perficient.employee.model;

import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2063412624813005132L;

	private Long userId;
	private String userName;
	private String password;
	private List<RoleDto> roleDto;

	public UserDto() {
		// this is a constra
	}

	public UserDto(String userName, List<RoleDto> roleDto) {
		this.userName = userName;
		this.roleDto = roleDto;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<RoleDto> getRoleDto() {
		return roleDto;
	}

	public void setRoleDto(List<RoleDto> roleDto) {
		this.roleDto = roleDto;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userName=" + userName + "]";
	}

}
