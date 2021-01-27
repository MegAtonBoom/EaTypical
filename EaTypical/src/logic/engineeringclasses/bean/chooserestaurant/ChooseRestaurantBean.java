package logic.engineeringclasses.bean.chooserestaurant;

import java.util.ArrayList;
import java.util.List;

import logic.model.Restaurant;

public class ChooseRestaurantBean {
	private List<Restaurant> allRestaurants;
	private List<Restaurant> celiacRestaurants;
	private List<Restaurant> veganRestaurants;
	private List<Restaurant> bothRestaurants;
	
	
	public ArrayList<ArrayList<String>> getAllRestaurants() 
	{
		ArrayList<ArrayList<String>> result= new ArrayList<ArrayList<String>>();
		ArrayList<String> restInfo= new ArrayList<String>();
		for(Restaurant rest : this.allRestaurants)
		{
			restInfo.add(rest.getName());
			restInfo.add(rest.getAddress());
			restInfo.add(Double.toString(rest.getAvgVote()));
			result.add(restInfo);
			restInfo= new ArrayList<String>();
		}
		return result;
	}
	
	
	public void setAllRestaurants(List<Restaurant> allRestaurants) 
	{
		this.allRestaurants = allRestaurants;
	}
	
	
	public ArrayList<ArrayList<String>> getCeliacRestaurants() 
	{
		ArrayList<ArrayList<String>> result= new ArrayList<ArrayList<String>>();
		ArrayList<String> restInfo= new ArrayList<String>();
		for(Restaurant rest : this.celiacRestaurants)
		{
			restInfo.add(rest.getName());
			restInfo.add(rest.getAddress());
			restInfo.add(Double.toString(rest.getAvgVote()));
			result.add(restInfo);
			restInfo= new ArrayList<String>();
		}
		return result;
	}
	
	
	public void setCeliacRestaurants(List<Restaurant> celiacRestaurants) 
	{
		this.celiacRestaurants = celiacRestaurants;
	}
	
	
	public ArrayList<ArrayList<String>> getVeganRestaurants() 
	{
		ArrayList<ArrayList<String>> result= new ArrayList<ArrayList<String>>();
		ArrayList<String> restInfo= new ArrayList<String>();
		for(Restaurant rest : this.veganRestaurants)
		{
			restInfo.add(rest.getName());
			restInfo.add(rest.getAddress());
			restInfo.add(Double.toString(rest.getAvgVote()));
			result.add(restInfo);
			restInfo= new ArrayList<String>();
		}
		return result;
	}
	
	
	public void setVeganRestaurants(List<Restaurant> veganRestaurants) 
	{
		this.veganRestaurants = veganRestaurants;
	}
	
	
	public ArrayList<ArrayList<String>> getBothRestaurants() 
	{
		ArrayList<ArrayList<String>> result= new ArrayList<ArrayList<String>>();
		ArrayList<String> restInfo= new ArrayList<String>();
		for(Restaurant rest : this.bothRestaurants)
		{
			restInfo.add(rest.getName());
			restInfo.add(rest.getAddress());
			restInfo.add(Double.toString(rest.getAvgVote()));
			result.add(restInfo);
			restInfo= new ArrayList<String>();
		}
		return result;
	}
	
	
	public void setBothRestaurants(List<Restaurant> bothRestaurants) 
	{
		this.bothRestaurants = bothRestaurants;
	}
}
