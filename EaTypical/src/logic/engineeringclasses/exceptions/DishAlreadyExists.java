package logic.engineeringclasses.exceptions;

import logic.engineeringclasses.bean.manageMenu.BeanErrorDishAlreadyExists;

/**
 * 
 * @author Luca Capotombolo
 *
 */


/*
 * 
 * Questa eccezione verrà lanciata nel momento in cui l'utente richiede l'inserimento di un piatto che
 * è stato registrato in un momento precedente. L'eccezione SQL viene tradotta in un'eccezione utile per l'utente
 * Possibilità di aggiungere altri campi per informazioni sul piatto richiesto da inserire
 * 
 */

public class DishAlreadyExists extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	private final String nomePiatto;
	
	public DishAlreadyExists(String nomePiatto) {
		this.nomePiatto = nomePiatto;
	}

	public BeanErrorDishAlreadyExists getMess() {
		return new BeanErrorDishAlreadyExists(nomePiatto);
	}		
	
}
