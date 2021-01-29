// DA FIXARE



package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.engineeringclasses.others.Connect;
import logic.engineeringclasses.query.QueryFavouriteRest;
import logic.engineeringclasses.query.QueryRestByName;
import logic.model.Restaurant;


public class FavouriteRestDAO {

//Note this is the USER on the DBMS that has proper privileges in order to access the specific DB 	
    //private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";
    //private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Kp*d.!>3&serverTimezone=UTC";
    

    public static List<Restaurant> findFavourites(String tourist) throws SQLException, ClassNotFoundException {
        // STEP 1: dichiarazioni
    	String driverClassName = "com.mysql.jdbc.Driver";
        Statement stmt = null;
        Connection conn = null;
        List<Restaurant> listOfRestaurants = new ArrayList<>();
        
        try {
            Class.forName(driverClassName);

            conn = Connect.getInstance().getDBConnection();
            // STEP 4: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = QueryFavouriteRest.selectFavourites(stmt,tourist); //ask for the favourite restaurants
            if(rs.first())		//if there is something
            {
	            do{			//for each restaurant									
	                String restaurant = rs.getString("NomeRistorante");		//get his name
	                ResultSet rs2=QueryRestByName.selectRestaurants(stmt, restaurant);		//look for the restaurant infos
	                String name=rs2.getString("Nome");
	                String address=rs2.getString("Indirizzo");
	                String city=rs2.getString("Città");
	                double avgVote=rs2.getDouble("VotoMedio");		
	                Restaurant r=new Restaurant(name,address,city,avgVote);		//make a new restaurant
	                listOfRestaurants.add(r);		//add the restaurant in the list
	            }while(rs.next());
            }
            
            
            rs.close();
        	} finally {
            
            
                if (stmt != null)
                    stmt.close(); 
        }

        return listOfRestaurants;
    }

    public static void insertFavourite(String rest, String tourist) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection conn = null;
        String driverClassName = "com.mysql.jdbc.Driver";
        
        try {
            
            Class.forName(driverClassName);

            conn = Connect.getInstance().getDBConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            QueryFavouriteRest.insertFavourite(stmt, rest, tourist); 

        } finally {     	
                if (stmt != null)
                    stmt.close();
        }
    }

    
}