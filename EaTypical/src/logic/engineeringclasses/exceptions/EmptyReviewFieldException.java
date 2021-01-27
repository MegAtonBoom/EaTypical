package logic.engineeringclasses.exceptions;

public class EmptyReviewFieldException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public EmptyReviewFieldException(String message)
	{
		super(message);
	}
}
