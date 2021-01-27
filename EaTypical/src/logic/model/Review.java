package logic.model;

public class Review {
	
	private String text;
	private Tourist tourist;
	private Restaurant restaurant;
	private int vote;
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}


	
	public Review(String text,Tourist tourist,int vote, Restaurant restaurant) {
		this.vote = vote;
		this.text = text;
		this.tourist = tourist;
		this.restaurant=restaurant;
	}
	
	public Review(String text, int vote)
	{
		this.text=text;
		this.vote=vote;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Tourist getTourist() {
		return tourist;
	}

	public void setTourist(Tourist tourist) {
		this.tourist = tourist;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}
	
	
}
