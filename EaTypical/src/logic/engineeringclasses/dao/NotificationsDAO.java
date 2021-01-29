package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.engineeringclasses.others.Connect;
import logic.engineeringclasses.query.QueryNotifications;
import logic.model.OwnerSchedulingNotification;
import logic.model.Restaurant;
import logic.model.TouristNotification;

public class NotificationsDAO {
    //private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";
    //private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Kp*d.!>3&serverTimezone=UTC";
    
    
    //get a list with user notifications
    public static List<TouristNotification> findTouristNotifications(String user) throws Exception {
        Statement stmt = null;
        Connection conn = null;
        List<TouristNotification> listOfNotifications = new ArrayList<TouristNotification>();
        String driverClassName = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driverClassName);
           //conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            conn = Connect.getInstance().getDBConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = QueryNotifications.touristNotifications(stmt,user); 
            if(rs.first())
            {
	            do{									//for each notification
	
	                String restaurant = rs.getString("NomeRistorante");
	                String notificationType = rs.getString("TipoModifica");
	                String dish = rs.getString("NomePiatto");
	                TouristNotification tn=new TouristNotification(restaurant,notificationType,dish);
	                listOfNotifications.add(tn);	//create a notification and add it to the list
	            }while(rs.next());
            }
            rs.close();
        	} 
        	finally 
        	{       	
                if (stmt != null)
                    stmt.close();
        
        	}

        return listOfNotifications;
    }
    
    
    public static List<OwnerSchedulingNotification> findOwnerNotifications(Restaurant rest) throws Exception {
    	String driverClassName = "com.mysql.jdbc.Driver";
        Statement stmt = null;
        Connection conn = null;
        List<OwnerSchedulingNotification> listOfNotifications = new ArrayList<OwnerSchedulingNotification>();
        String usernameTourist;
        String date;
        boolean isLunch;
        
        try {
            Class.forName(driverClassName);
            //conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            conn = Connect.getInstance().getDBConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            
            ResultSet rs = QueryNotifications.ownerSchedulingNotifications(stmt,rest.getName());		//get owner notifications about scheduled trips
            if(rs.first())
            {
	            do{		//for each notification							
	
	                usernameTourist = rs.getString("UsernameTurista");	                
	                isLunch = rs.getBoolean("PranzoVsCena");
	                date = rs.getNString("Data");
	                OwnerSchedulingNotification osn=new OwnerSchedulingNotification(usernameTourist,isLunch,date,rest);
	                listOfNotifications.add(osn);	//create the entity and fill the list	
	            }while(rs.next());
            }
            rs.close();
        	} 
        	finally 
        	{       	
                if (stmt != null)
                    stmt.close();
        	}

        return listOfNotifications;
    }
}
