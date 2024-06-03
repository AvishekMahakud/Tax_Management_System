package com.imaginnovate.tms.exception;

/**
 * @author Avishek Mahakud
 * 
 */

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8502260163040140068L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
