package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.engineeringclasses.exceptions.AlreadyInUseUsernameException;
import logic.engineeringclasses.exceptions.LoginDBException;
import logic.engineeringclasses.others.Connect;
import logic.engineeringclasses.query.QueryLogin;
import logic.model.Owner;
import logic.model.User;

public class OwnerDAO {
	
	private OwnerDAO() {}
    
    private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase4?user=root&password=Monte_2020.&serverTimezone=UTC";
    //private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Kp*d.!>3&serverTimezone=UTC";

    public static User selectOwner(String user, String pw) throws ClassNotFoundException, SQLException, LoginDBException 
    {
    	String driverClassName = "com.mysql.jdbc.Driver";
        Statement stmt = null;
        Connection conn = null;
        User owner;
        String name;
        String surname;
        String username;
        try {
            Class.forName(driverClassName);
			//conn = Connect.getInstance().getDBConnection();
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
        
        	} finally {	      	
                if (stmt != null)
                    stmt.close();
        	}         
        owner = new Owner(name, surname, username); //use the factory to return a owner object
        return owner;
    }
    
    

    
    //insert a user owner in the db
    public static void insertOwner(User user, String pw) throws ClassNotFoundException, SQLException, AlreadyInUseUsernameException {
        Statement stmt = null;
        Connection conn = null;
        String driverClassName = "com.mysql.jdbc.Driver";
        
        try {
        	
            Class.forName(driverClassName);

            //conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            conn = Connect.getInstance().getDBConnection();
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
        }
    }
}
