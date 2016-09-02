package com.perficient.employee.model;

import java.io.Serializable;

public class RoleDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 948580433862805850L;
	private Long roleId;
	private String roleName;

	public RoleDto() {
		//this is a constra
	}

	public RoleDto(String roleName) {
		this.roleName = roleName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RoleDto [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
