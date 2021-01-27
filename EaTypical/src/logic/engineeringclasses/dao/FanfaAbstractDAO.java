package logic.engineeringclasses.dao;

import java.sql.SQLException;
import java.util.List;
import logic.engineeringclasses.exceptions.NoResultException;
import logic.model.Restaurant;

public abstract class FanfaAbstractDAO {

	protected String driverClassName = "com.mysql.jdbc.Driver";
	
	public abstract List<Restaurant> select(String city, boolean vegan, boolean celiac) throws NoResultException, ClassNotFoundException, SQLException;
	
}
