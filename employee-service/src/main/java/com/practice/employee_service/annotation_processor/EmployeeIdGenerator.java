package com.practice.employee_service.annotation_processor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.employee_service.annotations.OfficialEmpId;
import com.practice.employee_service.enums.Role;
import com.practice.employee_service.model.RoleCounter;
import com.practice.employee_service.repository.RoleCounterRepo;


@Component
public class EmployeeIdGenerator {

	@Autowired
    private RoleCounterRepo roleCounterRepository;
  
	 public void generateEmployeeId(Object obj) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
	        Class<?> clazz = obj.getClass();
	        Field[] fields = clazz.getDeclaredFields();

	        for (Field field : fields) {
	            if (field.isAnnotationPresent(OfficialEmpId.class)) {
	                field.setAccessible(true);

	                Role role = (Role) clazz.getMethod("getRole").invoke(obj);
	                String prefix = role.name().length() >= 3 ? role.name().substring(0, 3) : role.name();

	               RoleCounter roleCounter = roleCounterRepository.findByRole(role.name());
	              
	                Long counter;
	                if (roleCounter == null) {
	                    counter = 1L;
	                    roleCounter = new RoleCounter(role.name(), counter);
	                    roleCounterRepository.save(roleCounter);
	                } else {
	                    counter = roleCounter.getCounter() + 1;
	                    roleCounter.setCounter(counter);
	                    roleCounterRepository.save(roleCounter);
	                }
	               

	                String employeeId = String.format("%s%04d", prefix.toUpperCase(), counter);
	                field.set(obj, employeeId);
	            }
	        }
	    }
	
	
}

