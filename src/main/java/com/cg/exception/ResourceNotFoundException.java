package com.cg.exception;


public class ResourceNotFoundException extends RuntimeException{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(final String message) {
		super(message);
	}
	
}
