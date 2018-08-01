package com.wan.erp.exception;

public class ErpException extends RuntimeException {

	public ErpException() {
		super();
	}

	public ErpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ErpException(String message, Throwable cause) {
		super(message, cause);
	}

	public ErpException(String message) {
		super(message);
	}

	public ErpException(Throwable cause) {
		super(cause);
	}

	
}
