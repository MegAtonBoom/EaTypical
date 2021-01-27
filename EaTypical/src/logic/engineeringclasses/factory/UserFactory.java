package logic.engineeringclasses.factory;

import java.util.List;

import logic.model.Owner;
import logic.model.OwnerReviewNotification;
import logic.model.OwnerSchedulingNotification;
import logic.model.Restaurant;
import logic.model.Tourist;
import logic.model.TouristNotification;
import logic.model.User;

public class UserFactory 
{
	private static UserFactory instance=null;
		
		private UserFactory() {}
		
		public static synchronized UserFactory getFactory() {
			if(UserFactory.instance==null) {
				UserFactory.instance = new UserFactory();
			}
			return UserFactory.instance;
		}
		
		public User createTourist(String name, String surname, String username,List<Restaurant> favourite, List<TouristNotification> notifications) 
		{
			return new Tourist(name, surname, username, favourite, notifications);
		}
		
		public User createOwner(String name, String surname, List<Restaurant> restaurants, String username, List<OwnerReviewNotification> notifications, List<OwnerSchedulingNotification> schedNotifications) 
		{
			return new Owner(name, surname, restaurants, username, notifications, schedNotifications);
		}
}
