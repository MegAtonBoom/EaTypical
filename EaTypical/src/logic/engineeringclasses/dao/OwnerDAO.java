package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.engineeringclasses.exceptions.AlreadyInUseUsernameException;
import logic.engineeringclasses.exceptions.LoginDBException;
import logic.engineeringclasses.factory.UserFactory;
import logic.engineeringclasses.query.QueryLogin;
import logic.engineeringclasses.query.QueryNotifications;
import logic.model.Owner;
import logic.model.OwnerReviewNotification;
import logic.model.OwnerSchedulingNotification;
import logic.model.Restaurant;
import logic.model.Review;
import logic.model.User;

public class OwnerDAO {
	private static String DB_USER = "root";
    private static String DB_PASS = "password";
    private static String DB_URL = "jdbc:mysql://localhost:3308/progettoispwfinaledatabase";
    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";

    public static User selectOwner(String user, String pw) throws Exception 
    {
        Statement stmt = null;
        Connection conn = null;
        List<OwnerReviewNotification> ownerRev= new ArrayList<OwnerReviewNotification>();
        List<OwnerSchedulingNotification> ownerSched = new ArrayList<OwnerSchedulingNotification>();
        User owner;
        String name;
        String surname;
        String username;
        List<Restaurant> restaurants;
        System.out.println("Dragon Ball");
        try {
            Class.forName(DRIVER_CLASS_NAME);
            //conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            //apro la connssione verso il DBMS
			conn = DriverManager.getConnection(connectionString);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = QueryLogin.loginOwner(stmt, user, pw);		//get the owner data from the database
            if(!rs.first())   //if empty, throw exception, handled by the graphic controller
            {
            	throw new LoginDBException(0);		
            }
            
            name=rs.getString("Nome");
            surname=rs.getString("Cognome");
            username=rs.getString("Username");   
            System.out.println("Dragon Balllllllll " + username);
            restaurants= OwnerRestaurantsDAO.findYourRestaurant(username);
            System.out.print("Dopo find Restaurant riga 59\n");
            for(Restaurant rest: restaurants) {		//for each owner restaurant
            	rs=QueryNotifications.ownerReviewNotifications(stmt, rest.getName());		//get notifications about new reviews
            	if(rs.first())
            	{
            		do {
            			Review review=findSpecificReview(rest.getName(), rs.getString("UsernameTurista"));
            			String touristUsername=rs.getString("UsernameTurista");
            			OwnerReviewNotification orn=new OwnerReviewNotification(touristUsername,review,rest);
            			ownerRev.add(orn);
            		}while(rs.next());				//put the notifications in a list
            		rs.first();
            		
            	}
            	List<OwnerSchedulingNotification> ownerSpecificSched= NotificationsDAO.findOwnerNotifications(rest);	//get notifications about new schedules in your restaurant
            	ownerSched.addAll(ownerSpecificSched);    //put them in the list       	
            }
            rs.close();
        	} finally {	      	
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
        	}                 
        owner = new Owner(name, surname, restaurants, username, ownerRev, ownerSched); //use the factory to return a owner object
        System.out.println("Dragon Ball");
        return owner;
    }
    
    
    //find the review of specific user, for a specific restaurant
    private static Review findSpecificReview(String restName, String username) throws Exception
    {
    	return ReviewsDAO.findRestaurantReviews(restName,username);
    }

    
    //insert a user owner in the db
    public static void insertOwner(User user, String pw) throws Exception {
        Statement stmt = null;
        Connection conn = null;
        
        try {
        	
            Class.forName(DRIVER_CLASS_NAME);

            //conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            conn = DriverManager.getConnection(connectionString);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            String username=user.getUsername();
            
            ResultSet rs= QueryLogin.loginOwner(stmt, username);
            if(rs.first())		//if there's already a owner  with this username, throw an exception
            {
            	throw new AlreadyInUseUsernameException("This username is already in use!");		
            }
            
            QueryLogin.registerOwner(stmt, user , pw);
            stmt.close();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } finally {    	
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
        }
    }
}
