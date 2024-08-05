package com.practice.employee_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.employee_service.model.RoleCounter;

public interface RoleCounterRepo extends JpaRepository<RoleCounter, Long>{
	
	public RoleCounter findByRole(String role);

}
