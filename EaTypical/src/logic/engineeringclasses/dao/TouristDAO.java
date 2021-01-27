package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import logic.engineeringclasses.query.QueryLogin;
import logic.model.User;
import logic.engineeringclasses.exceptions.AlreadyInUseUsernameException;
import logic.engineeringclasses.exceptions.LoginDBException;
import logic.engineeringclasses.facade.TouristCreatorFacade;


public class TouristDAO {
		
		private static String DB_USER = "root";
	    private static String DB_PASS = "password";
	    private static String DB_URL = "jdbc:mysql://localhost:3308/progettoispwfinaledatabase";
	    private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";
	    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

	    private TouristDAO() {}
	    public static User selectTourist(String user, String pw) throws Exception {
	        Statement stmt = null;
	        Connection conn = null;	 
	        User tourist;
	        try {
	            Class.forName(DRIVER_CLASS_NAME);
	            //conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	            conn = DriverManager.getConnection(connectionString);
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);
	            
	            ResultSet rs = QueryLogin.loginTourist(stmt, user, pw);	//look in the db for the tourist with this username and this password
	            if(!rs.first())   //if nothing was found: throw exception (handled by the graphic controller)
	            {
	            	throw new LoginDBException(0);		
	            }
	            String name=rs.getString("Nome");
	            String surname=rs.getString("Cognome");
	            String username=rs.getString("Username");
	            tourist=TouristCreatorFacade.getInstance().getTourist(name, surname, username);		//compose the tourist entity             
	            rs.close();
	        	} 
	        	finally 
	        	{       	
	                if (stmt != null)
	                    stmt.close();
	                if (conn != null)
	                    conn.close();
	        	}
	        return tourist;
	    }

	    
	    
	    public static void insertTourist(User user, String pw) throws Exception {

	        Statement stmt = null;
	        Connection conn = null;
	        
	        try {

	            Class.forName(DRIVER_CLASS_NAME);
	            conn = DriverManager.getConnection(connectionString);
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);	            
	            
	            String username=user.getUsername();
	            ResultSet rs= QueryLogin.loginTourist(stmt, username);
	            if(rs.first())			//if there's already a tourist with this username, throw an exception
	            {
	            	throw new AlreadyInUseUsernameException("This username is already in use!");
	            }
	            
	            QueryLogin.registerTourist(stmt, user , pw);
	            stmt.close();
	        } 
	        finally 
	        {      	
	                if (stmt != null)
	                    stmt.close();
	                if (conn != null)
	                    conn.close();
	        }
	    }

}
