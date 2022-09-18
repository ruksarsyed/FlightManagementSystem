package com.capg.Exception;

public class BookingException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BookingException(String msg) {
		super(msg);
	}
}
