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

public class ApplicantNotFoundException extends Exception {
	//public static final long serialVersionUID = 43L;
	
	public ApplicantNotFoundException() {
		super("The applicant was not found");
	}
	
	public ApplicantNotFoundException(String message) {
		super(message);
	}
}
