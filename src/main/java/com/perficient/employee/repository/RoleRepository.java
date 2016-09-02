package com.perficient.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perficient.employee.domin.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
}
