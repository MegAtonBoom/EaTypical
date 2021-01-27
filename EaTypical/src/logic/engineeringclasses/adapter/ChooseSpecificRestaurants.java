package logic.engineeringclasses.adapter;

import java.util.List;

import logic.model.Restaurant;

public interface ChooseSpecificRestaurants {
	List<Restaurant> findallRestaurants(String city);
	
	List<Restaurant> findCeliacRestaurants(String city);
	
	List<Restaurant> findVeganRestaurants(String city);
	
	List<Restaurant> findBothRestaurants(String city);
}
