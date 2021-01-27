package logic.model;


import java.util.List;

public class Tourist extends User {

	private List<Restaurant> favouriteRestaurants = null; 
	private List<TouristNotification> notifications;
	private List<Scheduling> trip;
	
	public Tourist(String name, String surname,String username, List<Restaurant> favourite, List<TouristNotification> notifications,List<Scheduling> trip) {
		super(name, surname, username);
		this.favouriteRestaurants = favourite;
		this.notifications=notifications;
		this.trip=trip;
	}

	public List<Scheduling> getTrip() {
		return trip;
	}

	public void setTrip(List<Scheduling> trip) {
		this.trip = trip;
	}

	public List<TouristNotification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<TouristNotification> notifications) {
		this.notifications = notifications;
	}

	public List<Restaurant> getFavouriteRestaurants() {
		return favouriteRestaurants;
	}

	public void setFavouriteRestaurants(List<Restaurant> favouriteRestaurants) {
		this.favouriteRestaurants = favouriteRestaurants;
	}

	
}
