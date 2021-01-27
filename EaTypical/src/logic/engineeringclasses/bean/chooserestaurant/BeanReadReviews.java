package logic.engineeringclasses.bean.chooserestaurant;

import java.util.ArrayList;
import java.util.List;

import logic.model.Review;

public class BeanReadReviews {

	private List<Review> reviews;
	
	public BeanReadReviews(List<Review> reviews)
	{
		this.reviews=reviews;
	}
	
	public ArrayList<ArrayList<String>> getReviews() {
		ArrayList<ArrayList<String>> reviews=new ArrayList<ArrayList<String>>();
		ArrayList<String> singleReview= new ArrayList<String>();
		String username;
		String content;
		String vote;
		for(Review rev: this.reviews)
		{
			username=rev.getTourist().getUsername();
			content=rev.getText();
			vote=(""+rev.getVote());
			singleReview.add(username);
			singleReview.add(content);
			singleReview.add(vote);
			reviews.add(singleReview);
			singleReview=new ArrayList<String>();
		}
		return reviews;
	}
	
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
}
