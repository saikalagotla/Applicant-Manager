
public class ApplicantNotFoundException extends Exception {
	public static final long serialVersionUID = 43L;
	
	public ApplicantNotFoundException() {
		super("The applicant was not found");
	}
	
	public ApplicantNotFoundException(String message) {
		super(message);
	}
}
