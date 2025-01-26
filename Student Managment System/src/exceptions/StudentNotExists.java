package exceptions;

public class StudentNotExists extends Exception {

	private static final long serialVersionUID = 1L;

	

	public StudentNotExists(String message) {
		super(message);
	}

}
