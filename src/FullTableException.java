
public class FullTableException extends Exception {
	public static final long serialVersionUID = 42L;
	
	public FullTableException() {
		super("No more applicants can be added");
	}
	
	public FullTableException(String message) {
		super(message);
	}
}
