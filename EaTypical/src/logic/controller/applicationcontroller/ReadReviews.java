package logic.controller.applicationcontroller;

import java.util.List;

import logic.engineeringclasses.bean.chooserestaurant.BeanReadReviews;
import logic.engineeringclasses.dao.ReviewsDAO;
import logic.engineeringclasses.exceptions.GenericException;
import logic.model.Review;

public class ReadReviews {
	
	public BeanReadReviews findReviews(String name) throws Exception
	{
		try
		{
			List<Review> reviews= ReviewsDAO.findRestaurantReviews(name);
			return new BeanReadReviews(reviews);	
		}
		catch(Exception e)
		{
			throw new GenericException("Please try again.");
		}
		
	}

}
