package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import logic.engineeringclasses.query.QueryRestaurant;

public class RestaurantDAO {

	/*
	 * Se ho tempo, crea un file di configurazione per le credenziali
	 */
	String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";
	private String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	
	
	public /*ObservableList<String>*/ ArrayList<String> selectOwnRestaurant(String username) throws ClassNotFoundException
	{
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		//ObservableList<String> obs = FXCollections.observableArrayList();
		ArrayList<String> obs = new ArrayList<>();
		
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(DRIVER_CLASS_NAME);
			
			//apro la connssione verso il DBMS
			conn = DriverManager.getConnection(connectionString);
			
			
			//creazione ed esecuzione dell'eliminazione
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);	
			
			
			rs = QueryRestaurant.selectOwnRestaurant(stmt, username);
				
			//scansiono i risultati
			rs.first();
			String restaurant;
			do {
				restaurant = rs.getString(1);
				System.out.println(restaurant);
				obs.add(restaurant);
			}
			while(rs.next());
				
			
			
			
		} catch (SQLException e) {			
			System.out.print("Eccezione eliminazione piatto");			
		}finally {
			try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            	System.out.println("Errore chiusura Statement delete");
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
            	System.out.println("Errore chiusura Connessione delete");
                se.printStackTrace();
            }
		}
		
		return obs;
	}
}
