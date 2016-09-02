package com.perficient.employee.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.perficient.employee.domin.Employee;
import com.perficient.employee.model.EmployeeDto;
import com.perficient.employee.service.EmployeeService;

public class EmployeeControllerTest extends ControllerTestConfig {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	private static final String BASE_URI = "/employee/";

	@Autowired
	private EmployeeService employeeService;

	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(this.wac).build();
		reset(employeeService);
	}

	@Test
	public void testFindEmployee() throws Exception {
		EmployeeDto employeeDto = new EmployeeDto();
		when(employeeService.findEmployee(any(Long.class))).thenReturn(employeeDto);
		RequestBuilder request = get(BASE_URI + "{id}", 5L);
		mockMvc.perform(request).andExpect(status().isOk());
		verify(employeeService, times(1)).findEmployee(any(Long.class));

		when(employeeService.findEmployee(0L)).thenReturn(null);
		request = get(BASE_URI + "{id}", 0L);
		mockMvc.perform(request).andExpect(status().isOk());
		verify(employeeService, times(1)).findEmployee(0L);
	}

	@Test
	public void testDeleteEmployee() throws Exception {
		EmployeeDto employeeDto = new EmployeeDto();
		when(employeeService.findEmployee(any(Long.class))).thenReturn(employeeDto);
		RequestBuilder request = delete(BASE_URI + "{id}", any(Long.class));
		mockMvc.perform(request).andExpect(status().isOk());
		verify(employeeService, times(1)).deleteEmployee(any(Long.class));

		when(employeeService.findEmployee(0L)).thenReturn(null);
		request = delete(BASE_URI + "{id}", 0L);
		mockMvc.perform(request).andExpect(status().isOk());
		verify(employeeService, times(1)).deleteEmployee(0L);
	}

	@Test
	public void testSaveEmployee() throws Exception {
		String json = "{\"employeeId\": 9, \"employeeName\": \"tom\" , \"project\":[ {\"projectId\":1 , \"projectName\": \"pro1\"}]}";
		String uri = BASE_URI + "employee";
		RequestBuilder request = post(uri).contentType(APPLICATION_JSON_UTF8).content(json.getBytes());
		mockMvc.perform(request).andExpect(status().isOk());
		verify(employeeService, times(1)).saveEmployee(any(Employee.class));

	}

	@Test
	public void testUpdataEmployee() throws Exception {
		Employee employee = new Employee("l", "l", null);
		when(employeeService.findEmployeeById(1L)).thenReturn(employee);
		String json = "{\"employeeId\": 1, \"employeeName\": \"jack\" , \"project\":[ {\"projectId\":1 , \"projectName\": \"pro1\"}]}";
		String uri = BASE_URI + "Employee";
		RequestBuilder request = put(uri).contentType(APPLICATION_JSON_UTF8).content(json.getBytes());
		mockMvc.perform(request).andExpect(status().isOk());
		verify(employeeService, times(1)).findEmployeeById(1L); 
	}

}
