package logic.controller.applicationcontroller;

import logic.engineeringclasses.bean.chooserestaurant.BeanNewReview;
import logic.engineeringclasses.dao.ReviewsDAO;
import logic.engineeringclasses.exceptions.GenericException;
import logic.model.Review;

public class WriteReview {
	
	public void write(BeanNewReview bnr) throws Exception
	{
		try {
		Review newReview=bnr.getReview();
		ReviewsDAO.insertReview(newReview);
		}
		catch(Exception e)
		{
			throw new GenericException("Please try again.");
		}
	}

}
