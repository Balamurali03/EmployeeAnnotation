package com.practice.employee_service.response_details;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
 
	private String message;
	private LocalDateTime time;
	private HttpStatus status;
}
