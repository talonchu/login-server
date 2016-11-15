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

import com.perficient.employee.domin.Employee;
import com.perficient.employee.domin.Project;
import com.perficient.employee.repository.EmployeeRepository;
import com.perficient.employee.service.impl.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	private Employee employee;
		
	@Before
	public void setUp() throws Exception {
		employee = new Employee("mikee", "li", null);
		employee.setEmployeeId(1L);
		List<Project> list = new ArrayList<Project>();
		Project project = new Project("pro1", employee);
		project.setProjectId(1L);
		list.add(project);
		employee.setProject(list);

	}

	@Test
	public void testDeleteEmployee() {
		employeeService.deleteEmployee(any(Long.class));
		
		verify(employeeRepository, times(1)).delete(any(Long.class));
	}

	@Test
	public void testSaveEmployee() {
		when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
		
		assertThat(employeeService.saveEmployee(employee).getFirstName(), is(employee.getFirstName()));
		
		verify(employeeRepository, times(1)).save(any(Employee.class));
	}

	@Test
	public void testFindEmployee() {
		when(employeeRepository.findOne(any(Long.class))).thenReturn(employee);
		
		assertThat(employeeService.findEmployee(any(Long.class)).getFirstName(), is(employee.getFirstName()));
		
		verify(employeeRepository, times(1)).findOne(any(Long.class));
	}

	@Test
	public void testFindEmployeeById() {
		when(employeeRepository.findOne(any(Long.class))).thenReturn(employee);
		
		assertThat(employeeService.findEmployeeById(any(Long.class)).getFirstName(), is(employee.getFirstName()));
		
		verify(employeeRepository, times(1)).findOne(any(Long.class));
	}

}
