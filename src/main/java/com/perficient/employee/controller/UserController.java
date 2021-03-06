package com.perficient.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.employee.domin.Role;
import com.perficient.employee.domin.User;
import com.perficient.employee.model.UserDto;
import com.perficient.employee.service.UserService;
import com.perficient.employee.util.MD5Util;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public UserDto addUser(@RequestBody User user) {
		UserDto userDto;
		List<Role> roles = user.getRole();
		for (Role role : roles) {
			if (userService.findRole(role.getRoleId()) != null) {
				Role role2 = userService.findRole(role.getRoleId());
				if (role2 != null) {
					List<User> list = role2.getUser();
					list.add(user);
					role.setUser(list);
				}
			}
			if (userService.findRole(role.getRoleId()) == null) {
				List<User> users = new ArrayList<User>();
				users.add(user);
				role.setUser(users);
			}
		}
		userDto = userService.addUser(user);
		return userDto;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDto queryUser(@PathVariable Long id) {
		UserDto userDto = userService.queryUser(id);
		if (userDto != null) {
			return userDto;
		}
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		User user = userService.findUser(id);
		if (user != null) {
			for (Role role : user.getRole()) {
				role.getUser().remove(user);
			}
			userService.deleteUser(id);
			return "delete successfully";
		}
		return "there is no such a user";
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public UserDto updateUser(@RequestBody User user) {
		User u = userService.findUser(user.getUserId());
		if (u != null) {
			u.setUserName(user.getUserName());
			for (Role role : u.getRole()) {
				role.getUser().remove(u);
			}
			for (Role role : user.getRole()) {
				List<User> list = new ArrayList<User>();
				list.add(user);
				role.setUser(list);
			}
			return userService.addUser(u);
		}
		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody UserDto login(@RequestBody User user) {
		UserDto userDto = userService.queryUser(user.getUserName());
		if (user.getPassword().equals(MD5Util.convertMD5(userDto.getPassword()))) {
			System.out.println("ok");
			return userDto;
		}
		System.out.println("null");
		return null;
	}
	@RequestMapping(value = "/registerVerification",method = RequestMethod.GET)
	public @ResponseBody UserDto registerVerification(String userName){
		System.out.println(userName);
		System.out.println(userService.queryUser(userName));
		return userService.queryUser(userName);
	}
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public @ResponseBody UserDto register(@RequestBody User user){
		return null;
	}
	
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	public void read(){
		userService.read();
	}
}
