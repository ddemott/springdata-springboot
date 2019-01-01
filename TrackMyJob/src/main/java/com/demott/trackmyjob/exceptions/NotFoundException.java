package com.demott.trackmyjob.exceptions;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6109597108758235345L;

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
