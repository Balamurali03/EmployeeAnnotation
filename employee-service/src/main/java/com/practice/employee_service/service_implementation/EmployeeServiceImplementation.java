package com.practice.employee_service.service_implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.employee_service.model.Employee;
import com.practice.employee_service.repository.EmployeeRepo;
import com.practice.employee_service.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;

	@Override
	public Optional<Employee> createEmployee(Employee employee) {

		if(! repo.existsByEmail(employee.getEmail())) {
			return Optional.of(repo.save(employee));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Employee> updateEmployee(Long id, Employee employee) {
		if(repo.existsById(id)) {
			employee.setSnoId(id);
			return Optional.of(repo.save(employee));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Employee> getEmployeeByPrimaryKey(Long id) {
		if(repo.existsById(id)) {
			return repo.findById(id);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Employee> getEmployeeByEmployeeId(String id) {
		if(repo.existsByEmployeeId(id)) {
			return repo.findByEmployeeId(id);
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Employee>> getAllEmployee() {
		List<Employee> all = repo.findAll();
		if(!all.isEmpty()) {
			return Optional.of(all);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Boolean> deleteEmployeeByEmployeeId(String id) {
		Optional<Employee> byEmployeeId = repo.findByEmployeeId(id);
		if(byEmployeeId.isPresent()) {
			repo.delete(byEmployeeId.get());
			return Optional.of(true);
		}
		return Optional.empty();
	}

}
