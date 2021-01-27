package logic.controller.applicationcontroller;

import java.util.List;

import logic.engineeringclasses.adapter.ChooseSpecificRestaurants;
import logic.engineeringclasses.adapter.ScheduleTripAdapter;
import logic.engineeringclasses.bean.chooserestaurant.ChooseRestaurantBean;
import logic.model.Restaurant;

public class ChooseRestaurant {

	public ChooseRestaurantBean getallRestaurants(String city)
	{
		ChooseRestaurantBean crb= new ChooseRestaurantBean();
		ScheduleTrip st=new ScheduleTrip();
		ChooseSpecificRestaurants csr=new ScheduleTripAdapter(st);
		List<Restaurant> allRestaurants=csr.findallRestaurants(city);
		List<Restaurant> veganRestaurants=csr.findVeganRestaurants(city);
		List<Restaurant> celiacRestaurants=csr.findCeliacRestaurants(city);
		List<Restaurant> bothRestaurants=csr.findBothRestaurants(city);	
		crb.setAllRestaurants(allRestaurants);
		crb.setCeliacRestaurants(celiacRestaurants);
		crb.setVeganRestaurants(veganRestaurants);
		crb.setBothRestaurants(bothRestaurants);
		return crb;
	}
}
