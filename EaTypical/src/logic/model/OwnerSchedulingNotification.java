package logic.model;

public class OwnerSchedulingNotification {
	private String username;
	private boolean isLunch;
	private String date;
	private Restaurant restaurant;
	
	public OwnerSchedulingNotification(String username, boolean isLunch, String date, Restaurant restaurant) 
	{
		this.username=username;
		this.isLunch=isLunch;
		this.date=date;
		this.restaurant=restaurant;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}


	public boolean isLunch() {
		return isLunch;
	}

	public void setLunch(boolean isLunch) {
		this.isLunch = isLunch;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
