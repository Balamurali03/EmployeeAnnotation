package com.practice.employee_service.model;

import java.time.LocalDate;
import java.util.List;

import com.practice.employee_service.annotations.OfficialEmpId;
import com.practice.employee_service.entity_Listener.EmployeeEntityListener;
import com.practice.employee_service.enums.Role;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@EntityListeners(EmployeeEntityListener.class)
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long snoId;
    
    @OfficialEmpId
    private String employeeId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private LocalDate dateOfBirth;
    private LocalDate hireDate;
    
    @Enumerated(EnumType.STRING)
    private Role role;

    @ElementCollection
    private List<String> skillSet;
    
    @ElementCollection
    private List<String> previousEmployers;
    
    @ElementCollection
    private List<String> previousPositions;

    @ElementCollection
    private List<String> previousExperience;

    
}