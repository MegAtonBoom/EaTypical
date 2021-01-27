package logic.engineeringclasses.bean.chooserestaurant;

import java.util.ArrayList;
import java.util.List;

import logic.model.Restaurant;

public class ChooseRestaurantBean {
	private List<Restaurant> allRestaurants;
	private List<Restaurant> celiacRestaurants;
	private List<Restaurant> veganRestaurants;
	private List<Restaurant> bothRestaurants;
	
	
	public List<ArrayList<String>> getAllRestaurants() 
	{
		List<ArrayList<String>> result= new ArrayList<>();
		List<String> restInfo= new ArrayList<>();
		for(Restaurant rest : this.allRestaurants)
		{
			restInfo.add(rest.getName());
			restInfo.add(rest.getAddress());
			restInfo.add(Double.toString(rest.getAvgVote()));
			result.add((ArrayList<String>) restInfo);
			restInfo= new ArrayList<String>();
		}
		return result;
	}
	
	
	public void setAllRestaurants(List<Restaurant> allRestaurants) 
	{
		this.allRestaurants = allRestaurants;
	}
	
	
	public List<ArrayList<String>> getCeliacRestaurants() 
	{
		List<ArrayList<String>> result= new ArrayList<>();
		List<String> restInfo= new ArrayList<>();
		for(Restaurant rest : this.celiacRestaurants)
		{
			restInfo.add(rest.getName());
			restInfo.add(rest.getAddress());
			restInfo.add(Double.toString(rest.getAvgVote()));
			result.add((ArrayList<String>) restInfo);
			restInfo= new ArrayList<String>();
		}
		return result;
	}
	
	
	public void setCeliacRestaurants(List<Restaurant> celiacRestaurants) 
	{
		this.celiacRestaurants = celiacRestaurants;
	}
	
	
	public List<ArrayList<String>> getVeganRestaurants() 
	{
		List<ArrayList<String>> result= new ArrayList<>();
		List<String> restInfo= new ArrayList<>();
		for(Restaurant rest : this.veganRestaurants)
		{
			restInfo.add(rest.getName());
			restInfo.add(rest.getAddress());
			restInfo.add(Double.toString(rest.getAvgVote()));
			result.add((ArrayList<String>) restInfo);
			restInfo= new ArrayList<String>();
		}
		return result;
	}
	
	
	public void setVeganRestaurants(List<Restaurant> veganRestaurants) 
	{
		this.veganRestaurants = veganRestaurants;
	}
	
	
	public List<ArrayList<String>> getBothRestaurants() 
	{
		List<ArrayList<String>> result= new ArrayList<>();
		List<String> restInfo= new ArrayList<>();
		for(Restaurant rest : this.bothRestaurants)
		{
			restInfo.add(rest.getName());
			restInfo.add(rest.getAddress());
			restInfo.add(Double.toString(rest.getAvgVote()));
			result.add((ArrayList<String>) restInfo);
			restInfo= new ArrayList<String>();
		}
		return result;
	}
	
	
	public void setBothRestaurants(List<Restaurant> bothRestaurants) 
	{
		this.bothRestaurants = bothRestaurants;
	}
}
