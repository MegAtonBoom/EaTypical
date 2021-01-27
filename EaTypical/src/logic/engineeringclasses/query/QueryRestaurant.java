package logic.engineeringclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryRestaurant {
	
	private QueryRestaurant() {}

	//look for all the restaurants of a specific owner
	public static ResultSet selectOwnRestaurant(Statement stmt, String username) throws SQLException
	{
		String sql = "SELECT * FROM ristorante WHERE UsernameProprietario = '"+ username + "';";
		return stmt.executeQuery(sql);
	}
	
	//look for a restauran by his name
	public static ResultSet selectRestaurant(Statement stmt, String name) throws SQLException
	{
		String sql = "SELECT * FROM ristorante WHERE Nome = '"+ name + "';";
		return stmt.executeQuery(sql);
	}
}
