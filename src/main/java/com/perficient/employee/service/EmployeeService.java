package com.perficient.employee.service;

import com.perficient.employee.domin.Employee;
import com.perficient.employee.model.EmployeeDto;

public interface EmployeeService {

	void deleteEmployee(Long id);

	EmployeeDto saveEmployee(Employee employee);

	EmployeeDto findEmployee(Long id);

	Employee findEmployeeById(Long id);
}
