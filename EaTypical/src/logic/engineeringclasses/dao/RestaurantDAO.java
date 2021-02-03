package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.engineeringclasses.others.Connect;
import logic.engineeringclasses.query.QueryRestaurant;

public class RestaurantDAO {

	/*
	 * Se ho tempo, crea un file di configurazione per le credenziali
	 */
	String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";
	private String driverclassname = "com.mysql.jdbc.Driver";
	
	
	public  List<String> selectOwnRestaurant(String username) throws ClassNotFoundException
	{
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		ArrayList<String> obs = new ArrayList<>();
		
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(driverclassname);
			
			//apro la connssione verso il DBMS
			conn = Connect.getInstance().getDBConnection();
			
			
			//creazione ed esecuzione dell'eliminazione
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);	
			
			
			rs = QueryRestaurant.selectOwnRestaurant(stmt, username);
				
			//scansiono i risultati
			rs.first();
			String restaurant;
			do {
				restaurant = rs.getString(1);
				obs.add(restaurant);
			}
			while(rs.next());
				
			
			
			
		} catch (SQLException e) {			
			e.printStackTrace();			
		}finally {
			try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
				se2.printStackTrace();
            }
		}
		
		return obs;
	}
}

