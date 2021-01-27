package logic.engineeringclasses.bean.scheduletrip;

import java.util.Date;

public class BeanRestaurantSchedule {

	private Date date1;
	private boolean atLunch1;
	private Date date2;
	private boolean atLunch2;
	private String city;
	private boolean vegan;
	private boolean celiac;
	private double budget;
	private int quality;
	
	public BeanRestaurantSchedule(Date[] dateArray, boolean[] atLunchArray, String city, boolean[] foodRequirement, double budget, int quality) {
		this.date1=dateArray[0];
		this.atLunch1=atLunchArray[0];
		this.date2=dateArray[1];
		this.atLunch2=atLunchArray[1];
		this.city=city;
		this.vegan=foodRequirement[0];
		this.celiac=foodRequirement[1];
		this.budget=budget;
		this.quality=quality;
	}

	/**
	 * @return the date1
	 */
	public Date getDate1() {
		return date1;
	}

	/**
	 * @param date1 the date1 to set
	 */
	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	/**
	 * @return the atLunch1
	 */
	public boolean isAtLunch1() {
		return atLunch1;
	}

	/**
	 * @param atLunch1 the atLunch1 to set
	 */
	public void setAtLunch1(boolean atLunch1) {
		this.atLunch1 = atLunch1;
	}

	/**
	 * @return the date2
	 */
	public Date getDate2() {
		return date2;
	}

	/**
	 * @param date2 the date2 to set
	 */
	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	/**
	 * @return the atLunch2
	 */
	public boolean isAtLunch2() {
		return atLunch2;
	}

	/**
	 * @param atLunch2 the atLunch2 to set
	 */
	public void setAtLunch2(boolean atLunch2) {
		this.atLunch2 = atLunch2;
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
	 * @return the vegan
	 */
	public boolean isVegan() {
		return vegan;
	}

	/**
	 * @param vegan the vegan to set
	 */
	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	/**
	 * @return the celiac
	 */
	public boolean isCeliac() {
		return celiac;
	}

	/**
	 * @param celiac the celiac to set
	 */
	public void setCeliac(boolean celiac) {
		this.celiac = celiac;
	}

	/**
	 * @return the budget
	 */
	public double getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(double budget) {
		this.budget = budget;
	}

	/**
	 * @return the quality
	 */
	public int getQuality() {
		return quality;
	}

	/**
	 * @param quality the quality to set
	 */
	public void setQuality(int quality) {
		this.quality = quality;
	}
	
}