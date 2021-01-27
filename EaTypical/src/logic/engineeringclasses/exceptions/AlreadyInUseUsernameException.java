package logic.engineeringclasses.exceptions;

public class AlreadyInUseUsernameException extends Exception{
private static final long serialVersionUID = 1L;
	
	public AlreadyInUseUsernameException(String message) {
		super(message);
	}
}
