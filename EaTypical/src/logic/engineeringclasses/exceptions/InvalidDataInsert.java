package logic.engineeringclasses.exceptions;


/**
 * Nel caso in cui si verificasse un problema durante un'operazione 
 * di recupero di informazioni in persistenza o di inserimento/aggiornamento
 * di tuple all'interno della base di dati
 * L'utente dovrà controllare i dati da lui inseriti in quanto sono errati
 * 
 * @author Luca Capotombolo
 */


public class InvalidDataInsert extends Exception {
	
	/*
	 * Il valore del campo codice mi dice l'operazione sul DB che ha
	 * portato all'errore: 
	 * Modifica -> 0
	 * Inserimento -> 1
	 * Cancellazione -> 2
	 * Lettura -> 3
	 */
	
	private final int code;
	private final String message;
	
	private static final long serialVersionUID = 1L;

	public InvalidDataInsert(int code) {
		this.code = code;		
		this.message = "Si è verificato un errore nel completamento dell'operazione.\nControllare i dati inseriti.";
	}
	
	/*
	 * Metodi Getter
	 */

	public int getCode() {
		return code;
	}
	
	public String getMess() {
		return message;
	}
	
	
	

}
