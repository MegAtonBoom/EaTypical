package logic.engineeringclasses.exceptions;

import logic.engineeringclasses.bean.manageMenu.BeanErrorDish;

/**
 * 
 * L'utente ha la possibilità di eliminare un piatto che viene cucinato in un suo ristorante
 * L'utente sceglie il piatto da eliminare ed il ristorante in cui eliminarlo
 * Tuttavia, può accadere che scelga di eliminare un piatto in un ristorante che in realtà non offre ai clienti
 * L'utente dovrà essere avvisato di tale errore in modo che possa inserire il giusto ristorante/piatto
 * @author Luca Capotombolo
 *
 */

public class InvalidDishDelete extends Exception{

	
	private static final long serialVersionUID = 1L;
	private final String dish;
	private final String restaurant;
	
	public InvalidDishDelete(String dish, String restaurant) {
		this.dish = dish;
		this.restaurant = restaurant;
	}
	
	/*
	 * Metodi Getter 
	 */

	public BeanErrorDish getMess() {
		return new BeanErrorDish(dish, restaurant);
	}	

	

	

}
