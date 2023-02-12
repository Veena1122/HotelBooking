package com.sprint1.HBA.exceptions;

public class InvalidUserException extends RuntimeException {
	public InvalidUserException (String string) {
		super(string);
	}

}