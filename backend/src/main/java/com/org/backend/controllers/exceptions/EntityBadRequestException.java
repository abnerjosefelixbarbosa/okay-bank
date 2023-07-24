package com.org.backend.controllers.exceptions;

public class EntityBadRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntityBadRequestException(String message) {
		super(message);
	}
}
