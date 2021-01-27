package logic.controller.applicationcontroller;

import logic.engineeringclasses.bean.chooserestaurant.BeanNewReview;
import logic.engineeringclasses.dao.ReviewsDAO;
import logic.model.Review;

public class WriteReview {
	
	public void write(BeanNewReview bnr) throws Exception
	{
		Review newReview=bnr.getReview();
		ReviewsDAO.insertReview(newReview);
	}

}
