package logic.engineeringclasses.exceptions;

import logic.engineeringclasses.bean.manageMenu.BeanAddDish;
import logic.engineeringclasses.bean.manageMenu.BeanErrorDish;

/**
 * L'utente ha la possibilità di modificare un piatto che viene cucinato in un suo ristorante
 * L'utente sceglie il piatto da modificare ed il ristorante in cui modificarlo
 * Tuttavia, può accadere che scelga di modificare un piatto in un ristorante che in realtà non lo offre ai clienti
 * L'utente dovrà essere avvisato di tale errore in modo che possa inserire il giusto ristorante/piatto 
 * @author Luca Capotombolo
 *
 */
public class InvalidDishModify extends Exception {

	private final String restaurant;
	private final String dish;
	private static final long serialVersionUID = 1L;
	
	public InvalidDishModify(String dish,String restaurant) {
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
