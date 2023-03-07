package org.marsrover.exception;

public class InvalidCoordinatesException extends RuntimeException {

	private static final long serialVersionUID = -8938986121206922731L;

	public InvalidCoordinatesException() {

	}

	public InvalidCoordinatesException(Exception e) {
		super(e);
	}

	public InvalidCoordinatesException(String msg) {
		super(msg);
	}

	public InvalidCoordinatesException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidCoordinatesException(Throwable cause) {
		super(cause);
	}
}
