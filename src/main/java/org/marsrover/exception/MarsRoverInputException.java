package org.marsrover.exception;

public class MarsRoverInputException extends RuntimeException {

	private static final long serialVersionUID = -7491161658369113032L;

	public MarsRoverInputException() {
	}

	public MarsRoverInputException(Exception e) {
		super(e);
	}

	public MarsRoverInputException(String msg) {
		super(msg);
	}

	public MarsRoverInputException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MarsRoverInputException(Throwable cause) {
		super(cause);

	}

}
