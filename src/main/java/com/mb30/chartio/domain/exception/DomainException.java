package com.mb30.chartio.domain.exception;


public class DomainException extends RuntimeException {
	
	public DomainException(String message) {
		super(message);
	}
	
	public DomainException(String message, Throwable cause) {
		super(message, cause);
	}
}
