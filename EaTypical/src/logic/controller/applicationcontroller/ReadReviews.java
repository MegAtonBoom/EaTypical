package logic.controller.applicationcontroller;

import java.util.List;

import logic.engineeringclasses.bean.chooserestaurant.BeanReadReviews;
import logic.engineeringclasses.dao.ReviewsDAO;
import logic.model.Review;

public class ReadReviews {
	
	public BeanReadReviews findReviews( String name) throws Exception
	{
		List<Review> reviews= ReviewsDAO.findRestaurantReviews(name);
		BeanReadReviews brr=new BeanReadReviews(reviews);
		return brr;
		
	}

}
