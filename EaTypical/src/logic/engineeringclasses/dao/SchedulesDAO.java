package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.engineeringclasses.query.QueryRestaurant;
import logic.engineeringclasses.query.QueryScheduling;
import logic.model.Restaurant;
import logic.model.Scheduling;

public class SchedulesDAO {
	private static String DB_USER = "root";
    private static String DB_PASS = "password";
    private static String DB_URL = "jdbc:mysql://localhost:3308/progettoispwfinaledatabase";
    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    
    //get a list with user notifications
    public static List<Scheduling> findTouristScheduling(String user) throws Exception {
        Statement stmt = null;
        Connection conn = null;
        List<Scheduling> scheduling = new ArrayList<Scheduling>();
        
        try {
            Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String ristName;
            Restaurant rest;
            String address;
            String city;
            double vote;
            String date;
            Scheduling sched;
            boolean atLunch;
            
            ResultSet rs = QueryScheduling.selectSchedules(stmt,user); 
            if(rs.first())
            {
	            do{									//for each notification
	
	                ResultSet rs2=QueryRestaurant.selectRestaurant(stmt, rs.getString("Ristorante"));
	                ristName=rs2.getString("Nome");
	                address=rs2.getString("Indirizzo");
	                city=rs2.getString("Citta");
	                vote=rs2.getDouble("VotoMedio");
	                rest=new Restaurant(ristName,address,city,vote);
	                date=rs.getString("Giorno");
	                atLunch=(rs.getString("CenaVsPranzo").equals("Pranzo"));
	                sched=new Scheduling(date,atLunch,rest);//vedi
	                
	                scheduling.add(sched);	//create a notification and add it to the list			//fix quando vedrai la tabella
	            }while(rs.next());
            }
            rs.close();
        	} 
        	finally 
        	{       	
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
        
        	}

        return scheduling;
    }
}