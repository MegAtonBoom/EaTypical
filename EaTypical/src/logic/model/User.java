package logic.model;

/**
 * Non vogliamo che tale classe venga istanziata
 * @author hp
 *
 */

public abstract class User {
	private String name;
	private String surname;
	private String username;
		
	
	protected User(String name, String surname,String username) {
		this.surname = surname;
		this.name = name;
		this.username=username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	
}
