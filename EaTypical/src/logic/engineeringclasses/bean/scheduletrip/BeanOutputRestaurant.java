package logic.engineeringclasses.bean.scheduletrip;

public class BeanOutputRestaurant {

	private String usernameOwner;
	private String name;
	private String address;
	private String city;
	private double avgPrice;
	private double avgVote;
	private boolean[][] openingHours;
	
	public BeanOutputRestaurant(String usernameOwner, String name, String address, String city, double avgPrice, double avgVote, boolean[][] openingHours) {
		this.usernameOwner=usernameOwner;
		this.name=name;
		this.address=address;
		this.city=city;
		this.avgPrice=avgPrice;
		this.avgVote=avgVote;
		this.openingHours=openingHours;
	}
	
	/**
	 * @return the usernameOwner
	 */
	public String getUsernameOwner() {
		return usernameOwner;
	}

	/**
	 * @param usernameOwner the usernameOwner to set
	 */
	public void setUsernameOwner(String usernameOwner) {
		this.usernameOwner = usernameOwner;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the avgPrice
	 */
	public double getAvgPrice() {
		return avgPrice;
	}

	/**
	 * @param avgPrice the avgPrice to set
	 */
	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	/**
	 * @return the avgVote
	 */
	public double getAvgVote() {
		return avgVote;
	}

	/**
	 * @param avgVote the avgVote to set
	 */
	public void setAvgVote(double avgVote) {
		this.avgVote = avgVote;
	}

	/**
	 * @return the openingHours
	 */
	public boolean[][] getOpeningHours() {
		return openingHours;
	}

	/**
	 * @param openingHours the openingHours to set
	 */
	public void setOpeningHours(boolean[][] openingHours) {
		this.openingHours = openingHours;
	}
	
}
