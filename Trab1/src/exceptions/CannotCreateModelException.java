package exceptions;

@SuppressWarnings("serial")
public class CannotCreateModelException extends Exception{

	public CannotCreateModelException() {
		super();
	}

	public CannotCreateModelException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CannotCreateModelException(String message, Throwable cause) {
		super(message, cause);
	}

	public CannotCreateModelException(String message) {
		super(message);
	}

	public CannotCreateModelException(Throwable cause) {
		super(cause);
	}
	
}
