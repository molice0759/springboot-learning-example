package com.molice.exception;

public class CommonLimitException extends RuntimeException {

	private static final long serialVersionUID = 5490028627612617487L;

	public CommonLimitException() {
		super();
	}

	public CommonLimitException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommonLimitException(String message) {
		super(message);
	}

	public CommonLimitException(Throwable cause) {
		super(cause);
	}

}
