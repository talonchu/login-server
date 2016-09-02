package com.perficient.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perficient.employee.domin.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public List<User> findUserByUserId(Long id);
	
	public User findUserByUserName(String username);
}
