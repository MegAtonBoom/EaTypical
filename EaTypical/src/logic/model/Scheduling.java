package logic.model;

public class Scheduling {
	
	private Tourist tourist;
	private String date;
	private boolean atLunch;
	
	private Restaurant rest;
	
	public Scheduling(Tourist tourist, String date, boolean atLunch, Restaurant rest) {
		this.tourist=tourist;
		this.date=date;
		this.atLunch=atLunch;
		this.rest=rest;
	}
	
	public Scheduling( String date, boolean atLunch, Restaurant rest)
	{
		this.date=date;
		this.atLunch=atLunch;
		this.rest=rest;
	}

	/**
	 * @return the tourist
	 */
	public Tourist getTourist() {
		return tourist;
	}

	/**
	 * @param tourist the tourist to set
	 */
	public void setTourist(Tourist tourist) {
		this.tourist = tourist;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
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
	public Restaurant getRest() {
		return rest;
	}

	/**
	 * @param rest the rest to set
	 */
	public void setRest(Restaurant rest) {
		this.rest = rest;
	}
	
	
	
}
