package com.practice.employee_service.exception;

public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoDataFoundException(String message) {
		super(message);
	}

}
