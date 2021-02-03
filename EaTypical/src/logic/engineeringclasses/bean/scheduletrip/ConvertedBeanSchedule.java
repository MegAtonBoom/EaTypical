package logic.engineeringclasses.bean.scheduletrip;

public class ConvertedBeanSchedule {

	private String strDate;
	private String strHour;
	private String usernameOwner;
	private String name;
	private String address;
	private String city;
	private String strAvgPrice;
	private String strAvgVote;
	
	public ConvertedBeanSchedule(String[] dateAndHour, String[] restInfo, String strAvgPrice, String strAvgVote) {
		this.strDate=dateAndHour[0];
		this.strHour=dateAndHour[1];
		this.usernameOwner=restInfo[0];
		this.name=restInfo[1];
		this.address=restInfo[2];
		this.city=restInfo[3];
		this.strAvgPrice=strAvgPrice;
		this.strAvgVote=strAvgVote;
	}
	
	/**
	 * @return the strHour
	 */
	public String getStrHour() {
		return strHour;
	}

	/**
	 * @param strHour the strHour to set
	 */
	public void setStrHour(String strHour) {
		this.strHour = strHour;
	}

	/**
	 * @return the strDate
	 */
	public String getStrDate() {
		return strDate;
	}

	/**
	 * @param strDate the strDate to set
	 */
	public void setStrDate(String strDate) {
		this.strDate = strDate;
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
	 * @return the strAvgPrice
	 */
	public String getStrAvgPrice() {
		return strAvgPrice;
	}

	/**
	 * @param strAvgPrice the strAvgPrice to set
	 */
	public void setStrAvgPrice(String strAvgPrice) {
		this.strAvgPrice = strAvgPrice;
	}

	/**
	 * @return the strAvgVote
	 */
	public String getStrAvgVote() {
		return strAvgVote;
	}

	/**
	 * @param strAvgVote the strAvgVote to set
	 */
	public void setStrAvgVote(String strAvgVote) {
		this.strAvgVote = strAvgVote;
	}
	
}
