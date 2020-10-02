package com.cs.cp.tcb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PermissionDeniedException extends ApplicationException{
	private static final String DEFAULT_ERROR_CODE="50009";

	public PermissionDeniedException(String message) {
		super(message);
	}

	public PermissionDeniedException(String key, String value) {
		super(DEFAULT_ERROR_CODE, new Object[] {key,value});
	}


}
