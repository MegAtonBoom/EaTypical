package logic.engineeringclasses.adapter;

import java.sql.SQLException;
import java.util.List;

import logic.controller.applicationcontroller.ScheduleTrip;
import logic.engineeringclasses.exceptions.NoResultException;
import logic.model.Restaurant;

public class ScheduleTripAdapter implements ChooseSpecificRestaurants{
	
	ScheduleTrip st;
	
	public ScheduleTripAdapter(ScheduleTrip st)
	{
		this.st=st;
	}
	
	public List<Restaurant> findallRestaurants(String city) throws ClassNotFoundException, NoResultException, SQLException
	{
		return this.st.callDAO(city,false,false);
	}
	
	public List<Restaurant> findCeliacRestaurants(String city) throws ClassNotFoundException, NoResultException, SQLException
	{
		return this.st.callDAO(city,false,true);
	}
	
	public List<Restaurant> findVeganRestaurants(String city) throws ClassNotFoundException, NoResultException, SQLException
	{
		return this.st.callDAO(city,true,false);
	}
	
	public List<Restaurant> findBothRestaurants(String city) throws ClassNotFoundException, NoResultException, SQLException
	{
		return this.st.callDAO(city,true,true);
	}
}
