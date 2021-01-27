package logic.engineeringclasses.adapter;

import java.util.List;

import logic.controller.applicationcontroller.ScheduleTrip;
import logic.model.Restaurant;

public class ScheduleTripAdapter implements ChooseSpecificRestaurants{
	
	ScheduleTrip st;
	
	public ScheduleTripAdapter(ScheduleTrip st)
	{
		this.st=st;
	}
	
	public List<Restaurant> findallRestaurants(String city)
	{
		return this.st.callDAO(city,false,false);
	}
	
	public List<Restaurant> findCeliacRestaurants(String city)
	{
		return this.st.callDAO(city,false,true);
	}
	
	public List<Restaurant> findVeganRestaurants(String city)
	{
		return this.st.callDAO(city,true,false);
	}
	
	public List<Restaurant> findBothRestaurants(String city)
	{
		return this.st.callDAO(city,true,true);
	}
}
