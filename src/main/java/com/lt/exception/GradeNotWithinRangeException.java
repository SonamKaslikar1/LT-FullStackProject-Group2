package com.lt.exception;

public class GradeNotWithinRangeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GradeNotWithinRangeException(String str) {
		super(str);
	}

}
