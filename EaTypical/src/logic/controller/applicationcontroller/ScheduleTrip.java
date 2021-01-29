package logic.controller.applicationcontroller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import logic.engineeringclasses.bean.scheduletrip.BeanRestaurantSchedule;
import logic.engineeringclasses.bean.scheduletrip.ConvertedBeanSchedule;
import logic.engineeringclasses.bean.scheduletrip.BeanOutputRestaurant;
import logic.engineeringclasses.bean.scheduletrip.BeanOutputSchedule;
import logic.engineeringclasses.dao.ScheduleTripRestaurantDAO;
import logic.engineeringclasses.dao.SchedulingDAO;
import logic.engineeringclasses.exceptions.NoResultException;
import logic.model.Menu;
import logic.model.Restaurant;
import logic.model.Scheduling;
import logic.model.Tourist;

public class ScheduleTrip {
	
	public BeanOutputSchedule[] generateScheduling(BeanRestaurantSchedule beanCRS) throws NoResultException, ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		
		List<Restaurant> listOfRestaurants = callDAO(beanCRS.getCity(), beanCRS.isVegan(), beanCRS.isCeliac());
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(beanCRS.getDate1());
		int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);		// Integer that indicates the first day of week of the trip
		
		int numDays = getNumDays(beanCRS, cal);					// Number of days of trip
		int numMeals = getNumMeals(beanCRS, numDays);			// Number of meals of trip
		
		boolean[][] requiredMealsWeek = getRequiredMealsWeek(beanCRS, firstDayOfWeek, numDays, numMeals);		// Array that indicates which meals, from Sunday to Saturday, are required for the trip
		
		// Check if the extracted restaurants are open at least for one meal of the trip
		List<Restaurant> listOfRestaurants2 = checkOpeningHours(listOfRestaurants, requiredMealsWeek);			// In listOfRestaurants2 there are only restaurants which satisfy this condition.
		if(listOfRestaurants2.isEmpty()) {
			throw new NoResultException("No restaurant has been found.");
		}
		
		List<Restaurant> validRestaurants = getValidRestaurants(beanCRS, numMeals, listOfRestaurants2);			// Restaurants that can actually be part of trip scheduling				
		List<BeanOutputRestaurant> validBeanRestaurants = convertValidRestaurantsList(validRestaurants);
		
		int dayOfWeek = firstDayOfWeek;
		Date date = beanCRS.getDate1();
		cal.setTime(date);
		boolean atLunch = beanCRS.isAtLunch1();
		BeanOutputSchedule[] scheduling = new BeanOutputSchedule[numMeals];				// Array that will contain the selected restaurant for each meal of the trip.
																						// Selection will be determined randomly between restaurants in validRestaurants which are open for that specific meal.
		for(int k=0; k<numMeals; k++) {
			int i;
			int j;
			if(atLunch) j=0;
			else j=1;
			i=dayOfWeek-1;
			
			BeanOutputSchedule beanSched = getScheduleForADay(validBeanRestaurants, i, j, date, atLunch);
			scheduling[k] = beanSched;
			
			if(atLunch) {
				atLunch=false;
			}
			else {
				atLunch=true;
				if(dayOfWeek!=6) {
					dayOfWeek = (dayOfWeek+1)%7;
				}
				else {
					dayOfWeek++;
				}
				cal.add(Calendar.DATE, 1);
				date=cal.getTime();
			}
			
		}		
		return scheduling;
		
	}
	
	public List<Restaurant> callDAO(String city, boolean isVegan, boolean isCeliac) throws ClassNotFoundException, NoResultException, SQLException {
		// Query of the restaurants that are in the selected city and satisfy tourist's eventual food requirements
		ScheduleTripRestaurantDAO dao = new ScheduleTripRestaurantDAO();
		return dao.select(city, isVegan, isCeliac);		// List of restaurants that satisfy the most important conditions given by the tourist.	
	}
	
	// Computation of number of days of the trip
	private int getNumDays(BeanRestaurantSchedule beanCRS, Calendar cal) {
		int numDays=0;
		Date d;
		cal.setTime(beanCRS.getDate2());
		
		do {
			cal.add(Calendar.DATE, -1);
			d=cal.getTime();
			numDays++;
		} while(beanCRS.getDate1().compareTo(d)<=0);
		
		return numDays;
	}
	
	// Computation of number of meals of the trip
	private int getNumMeals(BeanRestaurantSchedule beanCRS, int numDays) {
		int numMeals;
		
		if((beanCRS.isAtLunch1() && !beanCRS.isAtLunch2()) || (!beanCRS.isAtLunch1() && beanCRS.isAtLunch2())) {
			numMeals=2*numDays;
		}
		else {
			numMeals=2*numDays-1;
		}		
		return numMeals;
	}
	
	private boolean[][] getRequiredMealsWeek(BeanRestaurantSchedule beanCRS, int firstDayOfWeek, int numDays, int numMeals) {
		boolean[][] requiredMealsWeek;
		
		if(numMeals>=14) {										// Case 1: the trip is composed of more than 13 meals -> all the meals in a week are required.
			requiredMealsWeek = setTrueRequiredMealsWeek();
		}
		else {													// Case 2: the trip is composed of 13 meals or less.
			requiredMealsWeek = setRequiredMealsWeek(beanCRS, firstDayOfWeek, numDays);
		}
		return requiredMealsWeek;
	}
	
	private boolean[][] setTrueRequiredMealsWeek() {
		boolean[][] requiredMealsWeek = new boolean[7][2];		// Array that indicates which meals, from Sunday to Saturday, are required for the trip	
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<2; j++) {
				requiredMealsWeek[i][j]=true;
			}
		}
		return requiredMealsWeek;
	}
	
	private boolean[][] setRequiredMealsWeek(BeanRestaurantSchedule beanCRS, int firstDayOfWeek, int numDays) {
		boolean[][] requiredMealsWeek = new boolean[7][2];		// Array that indicates which meals, from Sunday to Saturday, are required for the trip
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<2; j++) {
				requiredMealsWeek[i][j]=false;
			}
		}
		for(int i=firstDayOfWeek; i<firstDayOfWeek+numDays; i++) {
			for(int j=0; j<2; j++) {
				if(!(i==firstDayOfWeek && j==0 && !beanCRS.isAtLunch1()) && !(i==firstDayOfWeek+numDays-1 && j==1 && beanCRS.isAtLunch2())) {		// Check if the first day comprehends lunch and if the last day comprehends dinner
					requiredMealsWeek[(i-1)%7][j]=true;
				}
			}
		}
		return requiredMealsWeek;
	}
	
	private List<Restaurant> checkOpeningHours(List<Restaurant> listOfRestaurants, boolean[][] requiredMealsWeek) {
		Iterator<Restaurant> iter = listOfRestaurants.iterator();
		boolean isOk;
		
		while(iter.hasNext()) {
			Restaurant r = iter.next();
			isOk = checkOpeningHoursOfOneRest(requiredMealsWeek, r);

			if(!isOk) {
				iter.remove();			// If an extracted restaurant is never open for the trip, remove it from the array-list.
			}
			
		}
		return listOfRestaurants;
	}
	
	private boolean checkOpeningHoursOfOneRest(boolean[][] requiredMealsWeek, Restaurant r) {
		for(int i=0; i<7; i++) {
			for(int j=0; j<2; j++) {
				if(requiredMealsWeek[i][j] && r.getOpeningHours()[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	private List<Restaurant> getValidRestaurants(BeanRestaurantSchedule beanCRS, int numMeals, List<Restaurant> listOfRestaurants) {
		Iterator<Restaurant> iter;
		
		int numRestaurants = listOfRestaurants.size();
		List<Restaurant> validRestaurants;						// List of restaurants that actually can be part of the schedule.
		
		// Here, it is established which is the minimum threshold (mt) of number of restaurants that will be part of the schedule.
		// We assume that mt is equals to the minimum value between the number of restaurants in listOfRestaurants and the number of meals of the trip divided by 3.
		if(numRestaurants <= numMeals/3) {
			validRestaurants=listOfRestaurants;					// If mt == number of restaurants in listOfRestaurants, then any restaurant in listOfRestaurants actually can be part of the schedule.
		}
		
		else {													// If mt == number of meals of the trip divided by 3, then we will do a selection of restaurants in listOfRestaurants based on their budget and their average vote.
			validRestaurants = new ArrayList<>();
			int mt;
			if((numMeals/3)>0) mt=numMeals/3;
			else mt=1;											// We assume that minimum threshold has ALWAYS to be at least 1.
			
			iter = listOfRestaurants.iterator();			
			while(iter.hasNext()) {
				Restaurant r = iter.next();
				if(r.getMenu().getTotalPrice() <= beanCRS.getBudget() && r.getAvgVote() >= (double)beanCRS.getQuality()) {
					validRestaurants.add(r);					// Restaurant which satisfy both requested budget and requested quality
				}
			}
			
			// If number of restaurants in validRestaurants is not lower than mt, then we are already satisfied for this array-list.
			// Else, we have to add some other restaurant in validRestaurants to reach the minimum threshold.
			if(validRestaurants.size() < mt) {
				validRestaurants = addValidRestaurants(beanCRS, listOfRestaurants, validRestaurants, mt);
			}
			
		}
		// Now, in validRestaurants we have the restaurants that can actually be part of trip scheduling.
		return validRestaurants;
		
	}
	
	private List<Restaurant> addValidRestaurants(BeanRestaurantSchedule beanCRS, List<Restaurant> listOfRestaurants, List<Restaurant> validRestaurants, int mt) {
		
		int remainingRestaurants = mt-validRestaurants.size();
		listOfRestaurants.removeAll(validRestaurants);
		
		List<Restaurant> temporaryList = getRestaurantsNotRespectingVote(beanCRS, listOfRestaurants);		// Restaurants which are potentially valid for the scheduling (their budget but not their quality is compliant with tourist's request)		
		listOfRestaurants.removeAll(temporaryList);
		
		Iterator<Restaurant> iter;
		
		// If minimum threshold is reached, then we will accept only a part of restaurants whose budget (but not quality) is compliant with tourist's request.
		// Else, we will accept all these restaurants and we will look for restaurants whose quality (but not budget) is compliant with tourist's request.
		if(temporaryList.size() >= remainingRestaurants) {
			double minVote = getMinVote(temporaryList, remainingRestaurants);				// Lower bound of the range of quality of valid restaurants	
			
			List<Restaurant> temporaryList2 = deleteRestaurantsWithTooLowVote(temporaryList, minVote);			
			validRestaurants.addAll(temporaryList2);				
		}		
		else {
			validRestaurants.addAll(temporaryList);
			remainingRestaurants = mt-validRestaurants.size();
			
			iter = listOfRestaurants.iterator();
			temporaryList.clear();											// Clear of temporaryList
			
			while(iter.hasNext()) {
				Restaurant r = iter.next();
				if(r.getAvgVote() >= (double)beanCRS.getQuality()) {
					temporaryList.add(r);									// Restaurant which is potentially valid for the scheduling (its quality but not its budget is compliant with tourist's request)
				}
			}
			listOfRestaurants.removeAll(temporaryList);
			
			// If minimum threshold is reached, then we will accept only a part of restaurant whose quality (but not budget) is compliant with tourist's request.
			// Else, we will accept all these restaurants and we will look for restaurants whose quality and budget are NOT compliant with tourist's request.
			List<Restaurant> validRestaurants2;
			if(temporaryList.size() >= remainingRestaurants) {
				validRestaurants2 = addValidRestaurantsNotRespectingBudget(validRestaurants, temporaryList, remainingRestaurants);
			}			
			else {
				validRestaurants.addAll(temporaryList);
				remainingRestaurants = mt-validRestaurants.size();
				
				temporaryList.clear();										// Clear of temporaryList
				validRestaurants2 = addValidRestaurantsNotRespectingBudgetVote(validRestaurants, temporaryList, listOfRestaurants, remainingRestaurants, mt);				
			}
			validRestaurants=validRestaurants2;
			
		}
		return validRestaurants;		
	}
	
	private List<Restaurant> getRestaurantsNotRespectingVote(BeanRestaurantSchedule beanCRS, List<Restaurant> listOfRestaurants) {
		Iterator<Restaurant> iter = listOfRestaurants.iterator();
		List<Restaurant> temporaryList = new ArrayList<>();
		
		while(iter.hasNext()) {
			Restaurant r = iter.next();
			if(r.getMenu().getTotalPrice() <= beanCRS.getBudget()) {
				temporaryList.add(r);										//Restaurant which is potentially valid for the scheduling (its budget but not its quality is compliant with tourist's request)
			}
		}
		return temporaryList;
	}
	
	private List<Restaurant> deleteRestaurantsWithTooLowVote(List<Restaurant> temporaryList, double minVote) {
		Iterator<Restaurant> iter = temporaryList.iterator();	
		while(iter.hasNext()) {
			Restaurant r = iter.next();
			if(r.getAvgVote() < minVote) {
				iter.remove();												// Invalid restaurant (it has a too low vote)
			}									
		}
		return temporaryList;
	}
	
	private List<Restaurant> addValidRestaurantsNotRespectingBudget(List<Restaurant> validRestaurants, List<Restaurant> temporaryList, int remainingRestaurants) {
		double maxPrice = getMaxPrice(temporaryList, remainingRestaurants);		// Upper bound of the budget of a meal in valid restaurants
		
		Iterator<Restaurant> iter = temporaryList.iterator();
		while(iter.hasNext()) {
			Restaurant r = iter.next();
			if(r.getMenu().getTotalPrice() > maxPrice) {
				iter.remove();													// Invalid restaurant (it has too high prices)
			}					
			validRestaurants.addAll(temporaryList);
		}
		return validRestaurants;
	}
	
	private List<Restaurant> addValidRestaurantsNotRespectingBudgetVote(List<Restaurant> validRestaurants, List<Restaurant> temporaryList, List<Restaurant> listOfRestaurants, int remainingRestaurants, int mt) {
		double maxPrice = getMaxPrice(listOfRestaurants, remainingRestaurants);		// Upper bound of the budget of a meal in valid restaurants

		Iterator<Restaurant> iter = listOfRestaurants.iterator();				
		while(iter.hasNext()) {
			Restaurant r = iter.next();
			if(r.getMenu().getTotalPrice() < maxPrice) {
				validRestaurants.add(r);								// Restaurants whose prices do not reach the established upper bound are added in validRestaurants.
			}							
			else if(r.getMenu().getTotalPrice() == maxPrice) {
				temporaryList.add(r);									// Now temporaryList contains restaurants whose budget is equal to maxPrice.
			}
			
		}				
		// Now, we have to select restaurants whose prices are equal to the established upper bound and whose quality is equal or greater than a lower bound.
		// NB: Our goal is always to reach the minimum threshold of number of restaurants in validRestaurants array-list.
		remainingRestaurants = mt-validRestaurants.size();
		double minVote = getMinVote(temporaryList, remainingRestaurants);			// Lower bound of the range of quality of valid restaurants
		
		iter = temporaryList.iterator();
		while(iter.hasNext()) {
			Restaurant r = iter.next();
			if(r.getAvgVote() >= minVote) {
				validRestaurants.add(r);								// Restaurant whose quality is equal or greater than lower bound.
			}
			
		}
		return validRestaurants;
	}
	
	private double getMinVote(List<Restaurant> temporaryList, int remainingRestaurants) {
		Iterator<Restaurant> iter = temporaryList.iterator();
		List<Double> listOfVotes = new ArrayList<>();
		
		while(iter.hasNext()) {
			Restaurant r = iter.next();
			listOfVotes.add(r.getAvgVote());
		}
		Collections.sort(listOfVotes);
		Collections.reverse(listOfVotes);
		
		return listOfVotes.get(remainingRestaurants-1);			// Lower bound of the range of quality of valid restaurants
	}
	
	private double getMaxPrice(List<Restaurant> list, int remainingRestaurants) {
		Iterator<Restaurant> iter = list.iterator();
		List<Double> listOfPrices = new ArrayList<>();
		
		while(iter.hasNext()) {
			Restaurant r = iter.next();
			listOfPrices.add(r.getMenu().getTotalPrice());
		}
		Collections.sort(listOfPrices);
		
		return listOfPrices.get(remainingRestaurants-1);		// Upper bound of the budget of a meal in valid restaurants	
	}
	
	private List<BeanOutputRestaurant> convertValidRestaurantsList(List<Restaurant> validRestaurants) {
		List<BeanOutputRestaurant> validBeanRestaurants = new ArrayList<>();
		Iterator<Restaurant> iter = validRestaurants.iterator();
		
		while(iter.hasNext()) {									// Conversion of valid restaurants in beans.
			Restaurant r = iter.next();
			BeanOutputRestaurant b = new BeanOutputRestaurant(r.getOwner().getUsername(), r.getName(), r.getAddress(), r.getCity(), r.getMenu().getTotalPrice(), r.getAvgVote(), r.getOpeningHours());
			validBeanRestaurants.add(b);
		}
		return validBeanRestaurants;
	}
	
	private BeanOutputSchedule getScheduleForADay(List<BeanOutputRestaurant> validBeanRestaurants, int i, int j, Date date, boolean atLunch) throws NoSuchAlgorithmException {
		Iterator<BeanOutputRestaurant> iter=validBeanRestaurants.iterator();
		List<BeanOutputRestaurant> validRestForAMeal = new ArrayList<>();		// Restaurants in validRestaurants which are open for a specific meal
		
		while(iter.hasNext()) {
			BeanOutputRestaurant b = iter.next();
			if(b.getOpeningHours()[i][j]) {
				validRestForAMeal.add(b);
			}
		}			
		return new BeanOutputSchedule(date, atLunch, validRestForAMeal);
		
	}
	
	
	
	public void saveScheduleTrip(ConvertedBeanSchedule[] scheduling, String username) throws ClassNotFoundException, SQLException {
		SchedulingDAO dao = new SchedulingDAO();
		Tourist tourist = new Tourist(null, null, username, null, null, null);	
		double doubleAvgPrice;
		double doubleAvgVote;
		boolean atLunch;

		dao.delete(tourist);
		
		for(int i=0; i<scheduling.length; i++) {
			doubleAvgPrice = Double.parseDouble(scheduling[i].getStrAvgPrice());
			doubleAvgVote = Double.parseDouble(scheduling[i].getStrAvgVote());
			
			Menu menu = new Menu(null, doubleAvgPrice);
			Restaurant r = new Restaurant(null, scheduling[i].getCity(), menu, scheduling[i].getAddress(), scheduling[i].getName(), doubleAvgVote, null, null, null);
			
			if(scheduling[i].getStrHour().equals("Lunch")) atLunch=true;
			else atLunch = false;
			
			Scheduling schedEntity = new Scheduling(tourist, scheduling[i].getStrDate(), atLunch, r);
			dao.insert(schedEntity);
		}
		
	}
	
}
