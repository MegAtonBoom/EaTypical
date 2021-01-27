package logic.model;

public class OwnerReviewNotification {
	private String username;
	private Review review;
	private Restaurant restaurant;

	public OwnerReviewNotification(String username, Review review, Restaurant rest)
	{
		this.username=username;
		this.review=review;
		this.restaurant=rest;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}

	

}
