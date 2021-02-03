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
	
	//look for a restaurant by his name
	public static ResultSet selectRestaurant(Statement stmt, String name) throws SQLException
	{
		String sql = "SELECT * FROM ristorante WHERE Nome = '"+ name + "';";
		return stmt.executeQuery(sql);
	}
	
	//sponsor a restaurant by adding it into db
	public static void insertNewRestaurant(Statement stmt, String name, String address, String city, String owner, boolean[][] openingHours) throws SQLException {
		stmt.executeUpdate("INSERT INTO Ristorante VALUES('" +name+ "', '" +address+ "', '" +city+ "', '" +owner+ "', '0')");
		stmt.executeUpdate("INSERT INTO Menu VALUES('" + name+ "', '0')");
		
		for(int i=0; i<7; i++) {
			int openLunch;
			int openDinner;
			int day=i+1;
			
			if(openingHours[i][0]) openLunch=1;
			else openLunch=0;
			
			if(openingHours[i][1]) openDinner=1;
			else openDinner=0;
			
			stmt.executeUpdate("INSERT INTO Apertura VALUES('" +name+ "', '" +day+ "', '" +openLunch+ "', '" +openDinner+ "')");

		}
		
	}
	
}
