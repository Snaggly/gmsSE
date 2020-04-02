package snaggly;

@SuppressWarnings("serial")
public class UnexpectedFileException extends Exception {
	public UnexpectedFileException() {
		super();
	}
	
	public UnexpectedFileException(String message) {
		super(message);
	}
}
