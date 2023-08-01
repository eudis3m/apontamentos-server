package br.com.ibrowse.projeto.exceptionhandlers.exceptions;

public class EmptyElementException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyElementException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyElementException(String message) {
		super(message);
	}
	
}
