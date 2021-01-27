package logic.model;

import java.util.List;


public class Menu {

	private Restaurant restaurant;
	private List<Recipe> dishes;
	private double totalPrice;
	
	public Menu(List<Recipe> dishes, double totalPrice) {
		this.dishes =dishes;
		this.totalPrice=totalPrice;
	}

	public List<Recipe> getDishes() {
		return dishes;
	}

	public void setDishes(List<Recipe> dishes) {
		this.dishes = dishes;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
