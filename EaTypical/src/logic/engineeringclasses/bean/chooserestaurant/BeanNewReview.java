package logic.engineeringclasses.bean.chooserestaurant;

import logic.engineeringclasses.exceptions.EmptyReviewFieldException;
import logic.model.Restaurant;
import logic.model.Review;
import logic.model.Tourist;

public class BeanNewReview {

	
	private String username;
	private String vote;	
	private String content;
	private String restaurant;
	

	public void setUsername(String username) {
		this.username = username;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	public void setContent(String content) throws EmptyReviewFieldException {
		if(content==null)
			throw new EmptyReviewFieldException("You didn't write anything.");
		else
			this.content = content;
	}


	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public Review getReview()
	{
		int vote=Integer.parseInt(this.vote);	
		Tourist tourist=new Tourist(null,null,username,null,null,null);
		Restaurant restaurant=new Restaurant(this.restaurant,null,null,0);
		Review review=new Review(this.content,tourist,vote,restaurant);
		return review;
	}
	
	
	
	
}
