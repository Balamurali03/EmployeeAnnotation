package com.practice.employee_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.employee_service.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
	public Boolean existsByEmployeeId(String employeeId);
	
	public Boolean existsByEmail(String email);
	
	public Optional<Employee> findByEmployeeId(String employeeId);

}
