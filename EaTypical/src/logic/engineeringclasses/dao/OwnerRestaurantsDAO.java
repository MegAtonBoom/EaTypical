package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.engineeringclasses.query.QueryRestaurant;
import logic.model.Restaurant;

public class OwnerRestaurantsDAO {
	private static String DB_USER = "root";
    private static String DB_PASS = "password";
    private static String DB_URL = "jdbc:mysql://localhost:3308/progettoispwfinaledatabase";
    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";

    public static List<Restaurant> findYourRestaurant(String owner) throws Exception {
        Statement stmt = null;
        Connection conn = null;
        List<Restaurant> listOfRestaurants = new ArrayList<Restaurant>();
        
        
        try {
            Class.forName(DRIVER_CLASS_NAME);
            //conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            conn = DriverManager.getConnection(connectionString);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = QueryRestaurant.selectOwnRestaurant(stmt,owner);  //look for his restaurants
            System.out.print("Caio");
            if(rs.first())
            {
	            do{					//for each					
	
	                String name=rs.getString("Nome");
	                String address=rs.getString("Indirizzo");
	                String city=rs.getString("Citta");
	                double avgVote=rs.getDouble("VotoMedio");
	                Restaurant r=new Restaurant(name,address,city,avgVote);		//create a restaurant with the collected data
	                listOfRestaurants.add(r);			//and add to the list
	            }while(rs.next());
            }
            
            rs.close();
        	} catch(SQLException e) {
        		e.printStackTrace();
        	}
        	finally 
        	{       	
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
        	}
        System.out.print("Speramo\n");

        return listOfRestaurants;
    }
}
