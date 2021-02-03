package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.engineeringclasses.bean.manageMenu.BeanListNotificationsScheduling;
import logic.engineeringclasses.bean.manageMenu.BeanSchedulingNotification;
import logic.engineeringclasses.others.Connect;
import logic.engineeringclasses.query.QueryNotifications;
import logic.model.OwnerSchedulingNotification;
import logic.model.Restaurant;
import logic.model.TouristNotification;

public class NotificationsDAO {
    private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";
    //private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Kp*d.!>3&serverTimezone=UTC";
    
    
    //get a list with user notifications
    public static List<TouristNotification> findTouristNotifications(String user) throws ClassNotFoundException, SQLException  {
        Statement stmt = null;
        Connection conn = null;
        List<TouristNotification> listOfNotifications = new ArrayList<TouristNotification>();
        String driverClassName = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driverClassName);
           //conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            //conn = Connect.getInstance().getDBConnection();
            conn = DriverManager.getConnection(connectionString);
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
    
    
    public static List<OwnerSchedulingNotification> findOwnerNotifications(Restaurant rest) throws ClassNotFoundException, SQLException {
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
            //conn = Connect.getInstance().getDBConnection();
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
    
public BeanListNotificationsScheduling selectOwnerSchedulingNotifications(String username) throws ClassNotFoundException {
		String driverClassName = "com.mysql.jdbc.Driver";
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		BeanListNotificationsScheduling notifications = new BeanListNotificationsScheduling();
		
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(driverClassName);
			
			//apro la connssione verso il DBMS
			//conn = DriverManager.getConnection(connectionString);
			conn = Connect.getInstance().getDBConnection();
			
			//creazione ed esecuzione dell'eliminazione
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);	
			
			
			rs = QueryNotifications.ownerNotificationScheduling(stmt,username);
				
			//scansiono i risultati
			rs.first();
			BeanSchedulingNotification notification;notification = new BeanSchedulingNotification();
			
			do {
				notification = new BeanSchedulingNotification();
				notification.setUsername(rs.getString(2));
				notification.setRistorante(rs.getString(3));
				notification.setData(rs.getString(4));
				notification.setPranzoVsCena(rs.getString(5));
				notifications.getNotifications().add(notification);
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
		
		return notifications;
	}
}