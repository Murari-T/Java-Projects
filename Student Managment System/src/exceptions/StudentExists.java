package exceptions;

public class StudentExists extends Exception {

	
	private static final long serialVersionUID = 1L;

	

	public StudentExists(String message) {
		super(message);
	}

}
