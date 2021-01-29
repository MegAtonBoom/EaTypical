package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.engineeringclasses.query.QueryLogin;
import logic.model.User;
import logic.engineeringclasses.exceptions.AlreadyInUseUsernameException;
import logic.engineeringclasses.exceptions.LoginDBException;
import logic.engineeringclasses.facade.TouristCreatorFacade;
import logic.engineeringclasses.others.Connect;


public class TouristDAO {

	    
	    public static User selectTourist(String user, String pw) throws ClassNotFoundException, SQLException,LoginDBException   {
	    	String driverClassName = "com.mysql.jdbc.Driver";
	        Statement stmt = null;
	        Connection conn = null;	 
	        User tourist;
	        try {
	        	
	            Class.forName(driverClassName);
	            conn = Connect.getInstance().getDBConnection();
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
	        	}
	        return tourist;
	    }

	    
	    
	    public static void insertTourist(User user, String pw) throws ClassNotFoundException, SQLException, AlreadyInUseUsernameException {

	        Statement stmt = null;
	        Connection conn = null;
	        String driverClassName = "com.mysql.jdbc.Driver";
	        //String driverClassName = "oracle.jdbc.driver.OracleDriver";
	        
	        try {
	        	
	            Class.forName(driverClassName);
	            
	            //TimeUnit.SECONDS.sleep(5);
	            conn = Connect.getInstance().getDBConnection();	
	            System.out.println("Dragonball conn");
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
	        }
	    }

}
