package com.practice.employee_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.practice.employee_service.exception.NoDataFoundException;
import com.practice.employee_service.exception.UserAlreadyExistException;
import com.practice.employee_service.exception.UserNotFoundException;
import com.practice.employee_service.model.Employee;
import com.practice.employee_service.service.EmployeeService;
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee (@RequestBody Employee employee){
		
		 Optional<Employee> employeeResponse = service.createEmployee(employee);
		 if(employeeResponse.isPresent()) {
			 return ResponseEntity.ok().body(employeeResponse.get());
		 }
		 throw new UserAlreadyExistException("Employee email is already registered");
	}
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee (@RequestHeader Long id,@RequestBody Employee employee){
		 Optional<Employee> employeeResponse = service.updateEmployee(id, employee);
		 
		 if(employeeResponse.isPresent()) {
			 return ResponseEntity.ok().body(employeeResponse.get());
		 }
		 throw new UserNotFoundException("Cannot find the given id ");
	}
	@GetMapping("/getEmployee")
	public ResponseEntity<Employee> getEmployeeByPrimaryKey (@RequestHeader Long id){
		
		Optional<Employee> employeeResponse = service.getEmployeeByPrimaryKey(id);
		 
		 if(employeeResponse.isPresent()) {
			 return ResponseEntity.ok().body(employeeResponse.get());
		 }
		 throw new UserNotFoundException("Cannot find the given id ");
	}
	@GetMapping("/getEmployeeByEmpId")
	public ResponseEntity<Employee> getEmployeeByEmployeeId (@RequestHeader String id){
		
		Optional<Employee> employeeResponse = service.getEmployeeByEmployeeId(id);
		 
		 if(employeeResponse.isPresent()) {
			 return ResponseEntity.ok().body(employeeResponse.get());
		 }
		 throw new UserNotFoundException("The given Employee id is not exist");
	}
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee (){
		Optional<List<Employee>> employeeResponse = service.getAllEmployee();
		 
		 if(employeeResponse.isPresent()) {
			 return ResponseEntity.ok().body(employeeResponse.get());
		 }
		 throw new NoDataFoundException("Cannot find any Data ");
	}
	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<String> deleteEmployeeByEmployeeId (@RequestHeader String id){
		
		Optional<Boolean> employeeResponse = service.deleteEmployeeByEmployeeId(id);
		 
		 if(employeeResponse.isPresent()) {
			 return ResponseEntity.ok().body("Employee data deleted Successfully");
		 }
		 throw new UserNotFoundException("The given Employee id is not exist");
	}
}
