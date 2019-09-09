/**
 * @author Sai Kalagotla
 * ID: 113033883
 * Recotation section: R07
 * Professor Esmaili
 * 9/2/2019
 *
 * Homework #1
 * CSE 214
 * Fall 2019
 *
 * An exception class that is ment to run when the hiring table of 50
 * applicants becomes full and no more applicants can be added.
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
