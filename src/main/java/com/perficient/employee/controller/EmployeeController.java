package com.perficient.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.employee.domin.Employee;
import com.perficient.employee.domin.Project;
import com.perficient.employee.model.EmployeeDto;
import com.perficient.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	@Qualifier("employeeServiceImpl")
	private EmployeeService employeeService;

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET })
	public EmployeeDto findEmployee(@PathVariable Long id) {
		EmployeeDto emp = employeeService.findEmployee(id);
		if (emp != null) {
			return emp;
		}
		return null;
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public String deleteEmployee(@PathVariable Long id) {
		EmployeeDto empDto = employeeService.findEmployee(id);
		if (empDto != null) {
			employeeService.deleteEmployee(id);
			return "delete successfully";
		} else {
			return "not such a employee";
		}
	}

	@RequestMapping(value = "/employee", method = { RequestMethod.POST })
	@ResponseBody
	public String saveEmployee(@RequestBody Employee employee) {
		List<Project> list = employee.getProject();
		for (Project project : list) {
			project.setEmployee(employee);
		}
		EmployeeDto empDto = employeeService.saveEmployee(employee);
		if (empDto != null) {
			return empDto.toString();
		}
		return "add failed";
	}

	@RequestMapping(value = "/Employee", method = { RequestMethod.PUT })
	public EmployeeDto updataEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.findEmployeeById(employee.getEmployeeId());
		if (emp != null) {
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setProject(employee.getProject());
			List<Project> list = employee.getProject();
			for (Project project : list) {
				project.setEmployee(employee);
			}
			return employeeService.saveEmployee(emp);
		}
		return null;
	}
}
