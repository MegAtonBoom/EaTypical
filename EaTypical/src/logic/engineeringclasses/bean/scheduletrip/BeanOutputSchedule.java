package logic.engineeringclasses.bean.scheduletrip;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BeanOutputSchedule {

	private Date date;
	private boolean atLunch;
	private List<BeanOutputRestaurant> listOfBeans;
	private BeanOutputRestaurant rest;
	private Random random;
	
	public BeanOutputSchedule(Date date, boolean atLunch, BeanOutputRestaurant rest) {
		this.date=date;
		this.atLunch=atLunch;
		this.listOfBeans=null;
		this.rest=rest;
	}
	
	public BeanOutputSchedule(Date date, boolean atLunch, List<BeanOutputRestaurant> listOfBeans) throws NoSuchAlgorithmException {
		this.date=date;
		this.atLunch=atLunch;
		this.listOfBeans=listOfBeans;
		this.random = SecureRandom.getInstanceStrong();
		setRestFromList();		
	}
	
	public void setRestFromList() {
		if(this.listOfBeans.isEmpty()) {
			this.rest = new BeanOutputRestaurant("", "No available restaurants", "", "", 0, 0, null);
		}
		else {
			int index = this.random.nextInt(this.listOfBeans.size());
			this.rest = this.listOfBeans.get(index);
		}		
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the atLunch
	 */
	public boolean isAtLunch() {
		return atLunch;
	}

	/**
	 * @param atLunch the atLunch to set
	 */
	public void setAtLunch(boolean atLunch) {
		this.atLunch = atLunch;
	}

	/**
	 * @return the rest
	 */
	public BeanOutputRestaurant getRest() {
		return rest;
	}

	/**
	 * @param rest the rest to set
	 */
	public void setRest(BeanOutputRestaurant rest) {
		this.rest = rest;
	}
	
}
