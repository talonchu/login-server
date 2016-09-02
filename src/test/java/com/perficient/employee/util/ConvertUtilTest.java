package com.perficient.employee.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import com.perficient.employee.domin.Employee;
import com.perficient.employee.domin.Project;
import com.perficient.employee.domin.Role;
import com.perficient.employee.domin.User;

public class ConvertUtilTest {

	private Employee employee;

	private User user;

	@Before
	public void setUp() throws Exception {
		employee = new Employee("luna", "mel", null);
		List<Project> projects = new ArrayList();
		projects.add(new Project("pro1", employee));
		employee.setProject(projects);

		user = new User("luna", null);
		List<User> users = new ArrayList();
		users.add(user);
		List<Role> roles = new ArrayList();
		roles.add(new Role("admin", users));
		user.setRole(roles);
	}

	@Test
	public void testConvertFromEmployee() {
		assertEquals(ConvertUtil.convertFromEmployee(employee).getFirstName(), employee.getFirstName());

	}

	@Test
	public void testConvertFromUser() {
		assertEquals(ConvertUtil.convertFromUser(user).getUserName(), user.getUserName());
	}

}
