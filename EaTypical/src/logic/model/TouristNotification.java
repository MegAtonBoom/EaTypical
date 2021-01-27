package logic.model;

public class TouristNotification {
	private String restaurantName;
	private String notificationType;
	private String dish;
	
	public TouristNotification(String restaurantName, String notificationType, String dish)
	{
		this.restaurantName=restaurantName;
		this.notificationType=notificationType;
		this.dish=dish;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
	public String getDish() {
		return dish;
	}
	public void setDish(String dish) {
		this.dish = dish;
	}

}
