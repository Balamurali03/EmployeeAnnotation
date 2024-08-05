package com.practice.employee_service.entity_Listener;

import java.lang.reflect.InvocationTargetException;

import org.springframework.stereotype.Component;

import com.practice.employee_service.annotation_processor.EmployeeIdGenerator;
import com.practice.employee_service.custom_classes.SpringContextHolder;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Component
public class EmployeeEntityListener {

	@PrePersist
	@PreUpdate
	public void setEmployeeId(Object obj)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		EmployeeIdGenerator employeeIdGenerator = SpringContextHolder.getBean(EmployeeIdGenerator.class);
		employeeIdGenerator.generateEmployeeId(obj);
		
	}
}
