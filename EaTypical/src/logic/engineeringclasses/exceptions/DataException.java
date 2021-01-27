package logic.engineeringclasses.exceptions;
/**
 * Nel caso in cui i dati per il login/registrazione 
 * siano in un formato sbagliato, l'utente
 * dovrà reinserirli (eccezioni causate a livello applicativo)
 * 
 * @author Adrian Baba
 */
public class DataException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private final int code;
	/*  0=empty username
	 *  1=empty name
	 *  2=empty surname
	 *  3=empty password
	 *  
	 */
	
	public DataException(int code)
	{
		this.code=code;
	}
	
	public int getCode()
	{
		return this.code;
	}

}
