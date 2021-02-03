package logic.engineeringclasses.adapter;

import java.sql.SQLException;
import java.util.List;

import logic.engineeringclasses.exceptions.NoResultException;
import logic.model.Restaurant;

public interface ChooseSpecificRestaurants {
	List<Restaurant> findallRestaurants(String city) throws ClassNotFoundException, NoResultException, SQLException;
	
	List<Restaurant> findCeliacRestaurants(String city) throws ClassNotFoundException, NoResultException, SQLException;
	
	List<Restaurant> findVeganRestaurants(String city) throws ClassNotFoundException, NoResultException, SQLException;
	
	List<Restaurant> findBothRestaurants(String city) throws ClassNotFoundException, NoResultException, SQLException;
}
