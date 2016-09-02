package com.perficient.employee.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;

import com.perficient.employee.domin.Role;
import com.perficient.employee.domin.User;
import com.perficient.employee.model.UserDto;
import com.perficient.employee.service.UserService;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

public class UserControllerTest extends ControllerTestConfig {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	private static final String BASE_URI = "/user/";

	@Autowired
	private UserService userService;
	
	private User user;
	private Role role;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).build();
		reset(userService);
		
		user = new User("luna", null);
		List<User> users = new ArrayList(); 
		users.add(user);
		role = new Role("admin", users);
		List<Role> roles = new ArrayList();
		roles.add(role);
		user.setRole(roles);
	}

	@Test
	public void testAddUser() throws Exception {
		String json = "{\"userId\": 9, \"userName\": \"tom\" , \"role\":[ {\"roleId\":1 , \"roleName\": \"admin\"}]}";
		System.out.println(json);
		String uri = BASE_URI + "addUser";
		RequestBuilder request = post(uri).contentType(APPLICATION_JSON_UTF8).content(json.getBytes());
		mockMvc.perform(request).andExpect(status().isOk());
		verify(userService, times(1)).addUser(any(User.class));
		
		when(userService.findRole(1L)).thenReturn(role);
		request = post(uri).contentType(APPLICATION_JSON_UTF8).content(json.getBytes());
		mockMvc.perform(request).andExpect(status().isOk());
		verify(userService, times(2)).addUser(any(User.class));
	}

	@Test
	public void testQueryUser() throws Exception {
		UserDto userDto = new UserDto();
		when(userService.queryUser(any(Long.class))).thenReturn(userDto);
		RequestBuilder request = get(BASE_URI + "{id}", 5L);
		mockMvc.perform(request).andExpect(status().isOk());
		verify(userService, times(1)).queryUser(any(Long.class));
	}

	@Test
	public void testDeleteUser() throws Exception {
		UserDto userDto = new UserDto();
		when(userService.queryUser(any(Long.class))).thenReturn(userDto);
		RequestBuilder request = delete(BASE_URI + "{id}", any(Long.class));
		mockMvc.perform(request).andExpect(status().isOk());
		verify(userService, times(1)).findUser(any(Long.class));
	}

	@Test
	public void testUpdateUser() throws Exception {
		User user = new User("user1", null);
		List<User> users = new ArrayList();
		users.add(user);
		Role role = new Role("admin", users);
		List<Role> roles = new ArrayList();
		roles.add(role);
		user.setRole(roles);
		when(userService.findUser(1L)).thenReturn(user);
		String json = "{\"userId\": 1, \"userName\": \"lucy\" , \"role\":[ {\"roleId\":1 , \"roleName\": \"admin\"}]}";
		String uri = BASE_URI + "updateUser";
		RequestBuilder request = put(uri).contentType(APPLICATION_JSON_UTF8).content(json.getBytes());
		mockMvc.perform(request).andExpect(status().isOk());
		verify(userService, times(1)).findUser(1L);
	}

}
