package com.lt.exception;

public class NameOrPasswordInvalidException extends Exception{

	private static final long serialVersionUID = 1L;
	public NameOrPasswordInvalidException(String message) {
		super(message);
	}

}
