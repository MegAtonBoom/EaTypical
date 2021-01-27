package logic.model;

import java.util.List;

public class Restaurant {
	
	private Owner owner;
	private String city;
	private Menu menu;
	private String address;
	private String name;
	private double avgVote;
	private List<Review> reviews = null;
	private List<User> clients = null;
	private boolean[][] openingHours;
	
	public Restaurant(Owner owner, String city, Menu menu, String address, String name, double avgVote, List<Review> reviews, List<User> clients, boolean[][] openingHours) {
		this.owner = owner;				//DA rivedere: clients e reviews che non servono
		this.city = city;
		this.menu = menu;
		this.address =address;
		this.name = name;
		this.avgVote = avgVote;
		this.reviews = reviews;
		this.clients = clients;
		this.openingHours = openingHours;
	}
	
	public Restaurant(String name,String address,String city, double avgVote)
	{
		this.name=name;
		this.address=address;
		this.city=city;
		this.avgVote=avgVote;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvgVote() {
		return avgVote;
	}

	public void setAvgVote(double avgVote) {
		this.avgVote = avgVote;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<User> getClients() {
		return clients;
	}

	public void setClients(List<User> clients) {
		this.clients = clients;
	}

	public boolean[][] getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(boolean[][] openingHours) {
		this.openingHours = openingHours;
	}
	
	
	
}
