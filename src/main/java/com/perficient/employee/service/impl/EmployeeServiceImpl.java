package com.perficient.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perficient.employee.domin.Employee;
import com.perficient.employee.model.EmployeeDto;
import com.perficient.employee.repository.EmployeeRepository;
import com.perficient.employee.service.EmployeeService;
import com.perficient.employee.util.ConvertUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.delete(id);
	}

	@Override
	public EmployeeDto saveEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return ConvertUtil.convertFromEmployee(emp);
	}

	@Override
	public EmployeeDto findEmployee(Long id) {
		Employee employee = employeeRepository.findOne(id);
		return ConvertUtil.convertFromEmployee(employee);
	}

	@Override
	public Employee findEmployeeById(Long id) {
		return employeeRepository.findOne(id);
	}
}
