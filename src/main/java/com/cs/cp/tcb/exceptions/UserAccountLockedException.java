package com.cs.cp.tcb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserAccountLockedException extends ApplicationException{
	private static final String DEFAULT_ERROR_CODE="50005";

	public UserAccountLockedException(String message) {
		super(message);
	}

	public UserAccountLockedException(String key, String value) {
		super(DEFAULT_ERROR_CODE, new Object[] {key,value});
	}


}
