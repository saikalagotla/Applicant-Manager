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
 * An exception class that is ment to run when a user
 * searches for an applicant that is not in the table.
 */

public class ApplicantNotFoundException extends Exception {
	//public static final long serialVersionUID = 43L;
	
	public ApplicantNotFoundException() {
		super("The applicant was not found");
	}
	
	public ApplicantNotFoundException(String message) {
		super(message);
	}
}
