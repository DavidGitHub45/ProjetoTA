package com.example.projetota.exception;

public class NotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public NotFound(String msg) {
		super(msg);
	}
	
	public NotFound(String msg, Throwable cause) {
		super(msg, cause);
	}
}
