package logic.engineeringclasses.exceptions;
/**
 * Nel caso in cui i dati per il login/registrazione 
 * siano in un formato sbagliato, l'utente
 * dovrà reinserirli
 * 
 * @author Adrian Baba
 */
public class LoginException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private final int code;
	/*  0=username
	 *  1=name
	 *  2=surname
	 *  3=password
	 */
	
	public LoginException(int code)
	{
		this.code=code;
	}
	
	public int getCode()
	{
		return this.code;
	}

}
