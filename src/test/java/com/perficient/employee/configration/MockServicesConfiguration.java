package com.perficient.employee.configration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.mock;

import com.perficient.employee.repository.EmployeeRepository;
import com.perficient.employee.repository.RoleRepository;
import com.perficient.employee.repository.UserRepository;
import com.perficient.employee.service.EmployeeService;
import com.perficient.employee.service.UserService;
import com.perficient.employee.util.ConvertUtil;

@Configuration
@ComponentScan(basePackages = { "com.perficient.employee.service" })
public class MockServicesConfiguration {

	@Bean
	public RestTemplate restTemplate() {
		return mock(RestTemplate.class);
	}

	@Bean
	@Qualifier("userServiceImpl")
	public UserService userService() {
		return mock(UserService.class);
	}

	@Bean
	@Qualifier("employeeServiceImpl")
	public EmployeeService employeeService() {
		return mock(EmployeeService.class);
	}

	@Bean
	public EmployeeRepository employeeRepository() {
		return mock(EmployeeRepository.class);
	}

	@Bean
	public UserRepository userRepository() {
		return mock(UserRepository.class);
	}

	@Bean
	public RoleRepository roleRepository() {
		return mock(RoleRepository.class);
	}

	@Bean
	public ConvertUtil convertUtil() {
		return mock(ConvertUtil.class);
	}
}
