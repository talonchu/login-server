package com.perficient.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perficient.employee.domin.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByFirstName(String firstName);

}
