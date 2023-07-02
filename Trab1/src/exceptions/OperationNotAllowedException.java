package exceptions;

@SuppressWarnings("serial")
public class OperationNotAllowedException extends Exception{

	public OperationNotAllowedException() {
		super();
	}

	public OperationNotAllowedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OperationNotAllowedException(String message, Throwable cause) {
		super(message, cause);
	}

	public OperationNotAllowedException(String message) {
		super(message);
	}

	public OperationNotAllowedException(Throwable cause) {
		super(cause);
	}
	
}
