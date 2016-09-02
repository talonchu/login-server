package com.perficient.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perficient.employee.domin.Role;
import com.perficient.employee.domin.User;
import com.perficient.employee.model.UserDto;
import com.perficient.employee.repository.RoleRepository;
import com.perficient.employee.repository.UserRepository;
import com.perficient.employee.service.UserService;
import com.perficient.employee.util.ConvertUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDto addUser(User user) {
		User u = userRepository.save(user);
		if (u != null) {
			return ConvertUtil.convertFromUser(u);
		}
		return null;
	}

	@Override
	public UserDto queryUser(Long id) {
		User user = userRepository.findOne(id);
		if (user != null) {
			return ConvertUtil.convertFromUser(user);
		}
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}

	@Override
	public Role findRole(Long id) {
		return roleRepository.findOne(id);
	}

	@Override
	public User findUser(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findUserById(Long id) {
		return userRepository.findUserByUserId(id);
	}

	@Override
	public UserDto queryUser(String username) {
		User user = userRepository.findUserByUserName(username);
		return ConvertUtil.convertFromUser(user);
	}

}
