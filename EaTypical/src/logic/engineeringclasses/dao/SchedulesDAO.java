package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.engineeringclasses.others.Connect;
import logic.engineeringclasses.query.QueryRestaurant;
import logic.engineeringclasses.query.QueryScheduling;
import logic.model.Restaurant;
import logic.model.Scheduling;

public class SchedulesDAO {

    
    public static List<Scheduling> findTouristScheduling(String user) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection conn = null;
        String driverClassName = "com.mysql.jdbc.Driver";
        List<Scheduling> scheduling = new ArrayList<Scheduling>();
        
        try {
            Class.forName(driverClassName);
            //conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            conn = Connect.getInstance().getDBConnection();
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
            List<List<String>> schedules= new ArrayList<>();
            List<String> schedule= new ArrayList<>();
            
            ResultSet rs = QueryScheduling.selectSchedules(stmt,user); 
            
            if(rs.first())
            {
            	do {          		
            	          	schedule.add(rs.getString("Ristorante"));
            	          	schedule.add(rs.getString("Giorno"));
            	          	schedule.add(rs.getString("CenaVsPranzo"));
            	          	schedules.add(schedule);
            	          	schedule=new ArrayList<>();
            	}while(rs.next());
            }
            
            for( List<String> eachSchedule: schedules ) {
            	
            	rs=QueryRestaurant.selectRestaurant(stmt, eachSchedule.get(0));               
                
                ristName=rs.getString("Nome");
                address=rs.getString("Indirizzo");
                city=rs.getString("Citta");
                vote=rs.getDouble("VotoMedio");
                rest=new Restaurant(ristName,address,city,vote);
                

                date=eachSchedule.get(1);
                atLunch=(eachSchedule.get(2).equals("Pranzo"));
                sched=new Scheduling(date,atLunch,rest);
                scheduling.add(sched);	//create a notification and add it to the list			
            	
            }


            
            rs.close();
        	} 
        	finally 
        	{       	
                if (stmt != null)
                    stmt.close();
                
        
        	}

        return scheduling;
    }
}