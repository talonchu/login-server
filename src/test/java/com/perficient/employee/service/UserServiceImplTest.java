package com.perficient.employee.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import com.perficient.employee.domin.Role;
import com.perficient.employee.domin.User;
import com.perficient.employee.repository.RoleRepository;
import com.perficient.employee.repository.UserRepository;
import com.perficient.employee.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest{
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private RoleRepository roleRepository;
	
	private User user;
			
	private Role roleTest;
	
	@Before
	public void setUp() throws Exception {
		user = new User("mike", null);
		user.setUserId(1L);
		List<User> list = new ArrayList<User>();
		list.add(user);
		List<Role> list2 = new ArrayList<Role>();
		Role role = new Role("admin", list);
		list2.add(role);
		user.setRole(list2);
		
		roleTest = new Role("admin", list);
		
	}

	@Test
	public void testAddUser() {
		when(userRepository.save(any(User.class))).thenReturn(user);
		
		assertThat(userService.addUser(any(User.class)).getUserName(), is(user.getUserName()));
		
		verify(userRepository, times(1)).save(any(User.class));
	}

	@Test
	public void testQueryUser() {
		when(userRepository.findOne(any(Long.class))).thenReturn(user);
		
		assertThat(userService.queryUser(any(Long.class)).getUserName(), is(user.getUserName()));
		
		verify(userRepository, times(1)).findOne(any(Long.class));
		
		when(userRepository.findOne(1L)).thenReturn(null);
		
		assertEquals(userService.queryUser(1L), null);
		
	}

	@Test
	public void testDeleteUser() {
		userService.deleteUser(any(Long.class));
		
		verify(userRepository, times(1)).delete(any(Long.class));
	}

	@Test
	public void testFindRole() {
		when(roleRepository.findOne(any(Long.class))).thenReturn(roleTest);
		
		assertThat(userService.findRole(any(Long.class)).getRoleName(), is(roleTest.getRoleName()));
		
		verify(roleRepository,times(1)).findOne(any(Long.class));
	}

	@Test
	public void testFindUser() {
		when(userRepository.findOne(any(Long.class))).thenReturn(user);
		
		assertThat(userService.findUser(any(Long.class)).getUserName(), is(user.getUserName()));
		
		verify(userRepository, times(1)).findOne(any(Long.class));
	}

	@Test
	public void testFindUserById() {
		when(userRepository.findOne(any(Long.class))).thenReturn(user);
		
		assertThat(userService.findUserById(any(Long.class)).size(),is(0));
		
		verify(userRepository, times(1)).findUserByUserId(any(Long.class));
	}

}
