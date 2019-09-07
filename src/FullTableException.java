/*
 * Sai Kalagotla
 * 113033883
 * Professor Esmaili
 * 9/2/2019
 * 
 * Homework #1
 * CSE 214
 * Fall 2019
 */

public class FullTableException extends Exception {
	//public static final long serialVersionUID = 42L;
	
	public FullTableException() {
		super("No more applicants can be added");
	}
	
	public FullTableException(String message) {
		super(message);
	}
}
