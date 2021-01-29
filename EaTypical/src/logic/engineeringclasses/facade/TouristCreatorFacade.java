package logic.engineeringclasses.facade;

import java.sql.SQLException;
import java.util.List;

import logic.engineeringclasses.dao.FavouriteRestDAO;
import logic.engineeringclasses.dao.NotificationsDAO;
import logic.engineeringclasses.dao.SchedulesDAO;
import logic.model.Restaurant;
import logic.model.Scheduling;
import logic.model.Tourist;
import logic.model.TouristNotification;

public class TouristCreatorFacade {

	private static TouristCreatorFacade instance=null;
	private TouristCreatorFacade()
	{
		
	}
	public static synchronized TouristCreatorFacade getInstance()
	{
		if(instance==null)
		{
			instance=new TouristCreatorFacade();
		}
		return instance;
	}
	
	public Tourist getTourist(String name, String surname, String username) throws ClassNotFoundException, SQLException 
	{
		List<Restaurant> favourites=FavouriteRestDAO.findFavourites(username);
		List<TouristNotification> notifications=NotificationsDAO.findTouristNotifications(username);
		List<Scheduling> scheduling=SchedulesDAO.findTouristScheduling(username);
		return new Tourist(name,surname,username,favourites,notifications,scheduling);		
	}
}
