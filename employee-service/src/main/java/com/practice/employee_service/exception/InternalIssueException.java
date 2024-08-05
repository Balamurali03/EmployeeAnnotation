package com.practice.employee_service.exception;

public class InternalIssueException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InternalIssueException(String message) {
		super(message);
	}

}
