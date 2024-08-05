package com.practice.employee_service.global_handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.practice.employee_service.exception.InternalIssueException;
import com.practice.employee_service.exception.NoDataFoundException;
import com.practice.employee_service.exception.UserAlreadyExistException;
import com.practice.employee_service.exception.UserNotFoundException;
import com.practice.employee_service.response_details.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = InternalIssueException.class)
	public ResponseEntity<ErrorDetails> handleInternalIssueException(InternalIssueException ex) {
		ErrorDetails errorResponse = new ErrorDetails(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@ExceptionHandler(value = NoDataFoundException.class)
	public ResponseEntity<ErrorDetails> handleNoDataFoundException(NoDataFoundException ex) {
		ErrorDetails errorResponse = new ErrorDetails(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.BAD_GATEWAY);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_GATEWAY);

	}
	
	@ExceptionHandler(value = UserAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handleUserAlreadyExistException(UserAlreadyExistException ex) {
		ErrorDetails errorResponse = new ErrorDetails(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.ALREADY_REPORTED);
		return new ResponseEntity<>(errorResponse, HttpStatus.ALREADY_REPORTED);

	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException ex) {
		ErrorDetails errorResponse = new ErrorDetails(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);

	}

}
