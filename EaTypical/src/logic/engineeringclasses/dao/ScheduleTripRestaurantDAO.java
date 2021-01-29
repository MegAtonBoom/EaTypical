package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.model.Menu;
import logic.model.Owner;
import logic.model.Restaurant;
import logic.engineeringclasses.exceptions.NoResultException;
import logic.engineeringclasses.query.QueryRestaurantScheduleTrip;
import logic.engineeringclasses.others.Connect;

public class ScheduleTripRestaurantDAO {

	public List<Restaurant> select(String city, boolean vegan, boolean celiac) throws NoResultException, ClassNotFoundException, SQLException {
		// Step 1: declarations
		String driverClassName = "com.mysql.jdbc.Driver";
		Statement stmt=null;
		Connection conn=null;
		List<Restaurant> listOfRestaurants = new ArrayList<>();
		
		try {
			// Step 2: dinamic loading of sql driver
			Class.forName(driverClassName);
			
			// Step 3: connection opening
			conn = Connect.getInstance().getDBConnection();
			
			// Step 4: creation and execution of query
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = QueryRestaurantScheduleTrip.selectRestaurantsForTrip(stmt, city, vegan, celiac);
			
			if(!rs.first()) {		// rs empty
				throw new NoResultException("No restaurant has been found.");
			}
			
			rs.first();
			do {
				String name = rs.getString("Nome");
				String address = rs.getString("Indirizzo");
				double avgVote = rs.getDouble("VotoMedio");
				Menu menu = new Menu(null, rs.getDouble("Totale"));
				Owner owner = new Owner(null, null, null, rs.getString("UsernameProprietario"), null, null);
				boolean[][] openingHours = new boolean[7][2];
				
				for(int i=0; i<7; i++) {
					for(int j=0; j<2; j++) {
						openingHours[i][j]=false;
					}
				}
				
				do {
					openingHours[rs.getInt("GiornoSettimana")-1][0] = rs.getBoolean("ApertoAPranzo");
					openingHours[rs.getInt("GiornoSettimana")-1][1] = rs.getBoolean("ApertoACena");					
				} while(rs.next() && rs.getString("Nome").equals(name));
				
				rs.previous();
				
				Restaurant rest = new Restaurant(owner, city, menu, address, name, avgVote, null, null, openingHours);
				listOfRestaurants.add(rest);
				
			}	while(rs.next());
			
			// Step 5: clean-up
			rs.close();
			
		}
		
		finally {
			try {
				if(stmt!=null) {
					stmt.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		
		return listOfRestaurants;
		
	}
	
}
