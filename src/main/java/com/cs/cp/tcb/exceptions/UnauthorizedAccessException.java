package com.cs.cp.tcb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnauthorizedAccessException extends ApplicationException{
	private static final String DEFAULT_ERROR_CODE="50003";

	public UnauthorizedAccessException(String message) {
		super(message);
	}

	public UnauthorizedAccessException(String key, String value) {
		super(DEFAULT_ERROR_CODE, new Object[] {key,value});
	}


}
