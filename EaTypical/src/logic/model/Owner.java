package logic.model;


import java.util.List;

public class Owner extends User{

	private List<Restaurant> ownRestaurant = null;
	private List<OwnerReviewNotification> notifications;
	private List<OwnerSchedulingNotification> schedules;
	
	public List<OwnerSchedulingNotification> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<OwnerSchedulingNotification> schedules) {
		this.schedules = schedules;
	}

	public Owner(String name, String surname, List<Restaurant> restaurants, String username, List<OwnerReviewNotification> notifications, List<OwnerSchedulingNotification> schedules) {
		super(name, surname,  username);
		this.ownRestaurant = restaurants;
		this.notifications=notifications;
		this.schedules=schedules;
	}

	public List<OwnerReviewNotification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<OwnerReviewNotification> notifications) {
		this.notifications = notifications;
	}

	public List<Restaurant> getOwnRestaurant() {
		return ownRestaurant;
	}

	public void setOwnRestaurant(List<Restaurant> ownRestaurant) {
		this.ownRestaurant = ownRestaurant;
	}
	
	

}
