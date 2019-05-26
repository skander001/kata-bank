package fr.kata.bank.exception;

/**
 * The InvalidOperationException
 * 
 * @author Skander
 *
 */
public class InvalidOperationException extends Exception {
	/**
	 * The constructor
	 * 
	 * @param opertation The operation name
	 */
	public InvalidOperationException(String opertation) {
		super(String.format("operation %s refused, The amount must not be null.", opertation));
	}

}
