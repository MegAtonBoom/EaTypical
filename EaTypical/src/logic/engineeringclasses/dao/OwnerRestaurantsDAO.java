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
   
	private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";

	private OwnerRestaurantsDAO() {}
	
    public static List<Restaurant> findYourRestaurant(String owner) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection conn = null;
        String driverClassName = "com.mysql.jdbc.Driver";
        List<Restaurant> listOfRestaurants = new ArrayList<Restaurant>();
        
        
        try {
            Class.forName(driverClassName);    
            conn = DriverManager.getConnection(connectionString);
            //conn = Connect.getInstance().getDBConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = QueryRestaurant.selectOwnRestaurant(stmt,owner);  //look for his restaurants
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
        	}

        return listOfRestaurants;
    }
}
