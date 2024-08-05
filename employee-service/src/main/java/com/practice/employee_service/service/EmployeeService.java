package com.practice.employee_service.service;

import java.util.List;
import java.util.Optional;

import com.practice.employee_service.model.Employee;

public interface EmployeeService {
	
	public Optional<Employee> createEmployee (Employee employee);
	public Optional<Employee> updateEmployee (Long id,Employee employee);
	public Optional<Employee> getEmployeeByPrimaryKey (Long id);
	public Optional<Employee> getEmployeeByEmployeeId (String id);
	public Optional<List<Employee>> getAllEmployee ();
	public Optional<Boolean> deleteEmployeeByEmployeeId (String id);

}
