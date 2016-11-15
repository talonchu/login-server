package com.perficient.employee.service;

import java.util.List;

import com.perficient.employee.domin.Role;
import com.perficient.employee.domin.User;
import com.perficient.employee.model.UserDto;

public interface UserService {
	public UserDto addUser(User users);
	
	public UserDto queryUser(Long id);
	
	public void deleteUser(Long id);
	
	public Role findRole(Long id);
	
	public User findUser(Long id);
	
	public List<User> findUserById(Long id);
	
	public UserDto queryUser(String username);
	
	public void read();
}
