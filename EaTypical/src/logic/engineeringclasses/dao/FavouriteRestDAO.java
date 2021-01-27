// DA FIXARE



package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.engineeringclasses.query.QueryFavouriteRest;
import logic.engineeringclasses.query.QueryRestByName;
import logic.model.Tourist;
import logic.model.Restaurant;


public class FavouriteRestDAO {

//Note this is the USER on the DBMS that has proper privileges in order to access the specific DB 	
	private static String DB_USER = "root";
    private static String DB_PASS = "password";
    private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";
    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    public static List<Restaurant> findFavourites(String tourist) throws Exception {
        // STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = null;
        List<Restaurant> listOfRestaurants = new ArrayList<Restaurant>();
        
        try {
            Class.forName(DRIVER_CLASS_NAME);

            // STEP 3: apertura connessione
            //conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            conn = DriverManager.getConnection(connectionString);
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
            
            // STEP 5.1: Clean-up dell'ambiente
            rs.close();
        	} finally {
            // STEP 5.2: Clean-up dell'ambiente
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return listOfRestaurants;
    }

    public static void insertFavourite(String rest, String tourist) throws Exception{
        // STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = null;
        
        try {
            // STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);

            // STEP 3: apertura connessione
            conn = DriverManager.getConnection(connectionString);

            // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            //ResultSet rs = QueryFavouriteRest.selectFavourites(stmt, tourist);

            // STEP 4.2: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            QueryFavouriteRest.insertFavourite(stmt, rest, tourist); 

        } finally {
            // STEP 5.2: Clean-up dell'ambiente        	
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
        }
    }

    
}