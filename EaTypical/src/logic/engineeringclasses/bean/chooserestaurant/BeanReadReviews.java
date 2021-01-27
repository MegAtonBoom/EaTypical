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
	
	public List<ArrayList<String>> getReviews() {
		List<ArrayList<String>> stringReviews=new ArrayList<>();
		ArrayList<String> singleReview= new ArrayList<>();
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
			stringReviews.add(singleReview);
			singleReview=new ArrayList<>();
		}
		return stringReviews;
	}
	
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
}
