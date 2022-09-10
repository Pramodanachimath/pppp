package com.vfislk.training.exceptions;

public class CustomerNotFoundExcepion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundExcepion() {
		super();
	}

	public CustomerNotFoundExcepion(String message) {
		super(message);
	}

}
