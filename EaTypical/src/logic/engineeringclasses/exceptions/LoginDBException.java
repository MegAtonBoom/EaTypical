package logic.engineeringclasses.exceptions;
/**
 * Nel caso in cui i dati per il login 
 * siano errati oppure l'username per la registrazione
 * sia già in uso, da propagare fino a livello applicativo
 * 
 * @author Adrian Baba
 */
public class LoginDBException extends Exception{
	private static final long serialVersionUID = 1L;
	private final int code;
	/*  0=wrong username or password for login
	 *  1=username already in use 
	 */
	
	public LoginDBException(int code)
	{
		this.code=code;
	}
	
	public int getCode()
	{
		return this.code;
	}
}
