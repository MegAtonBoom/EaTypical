package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.engineeringclasses.query.QueryLogin;
import logic.model.User;

public class LoginDAO {
	
	//Note this is the USER on the DBMS that has proper privileges in order to access the specific DB 	
		private static String DB_USER = "root";
	    private static String DB_PASS = "password";
	    private static String DB_URL = "jdbc:mysql://localhost:3308/progettoispwfinaledatabase";
	    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

	    public static void tryLogin(User user, String pw, boolean isOwner) throws Exception {
	        // STEP 1: dichiarazioni
	        Statement stmt = null;
	        Connection conn = null;	        	        
	        try {
	            // STEP 2: loading dinamico del driver mysql
	            Class.forName(DRIVER_CLASS_NAME);

	            // STEP 3: apertura connessione
	            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

	            // STEP 4: creazione ed esecuzione della query
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);
	            
	            ResultSet rs = QueryLogin.login(stmt, user, pw, isOwner);
	            if(!rs.first())   //se vuoto
	            {
	            	//throw loginErrorException();		//FIX 
	            }
	            rs.close();
	        	} finally {	  //da gestire          
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
	    }

	    public static void tryRegister(User user, String pw, boolean isOwner) throws Exception {
	        // STEP 1: dichiarazioni
	        Statement stmt = null;
	        Connection conn = null;
	        
	        try {
	            // STEP 2: loading dinamico del driver mysql
	            Class.forName(DRIVER_CLASS_NAME);

	            // STEP 3: apertura connessione
	            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

	            // STEP 4.1: creazione ed esecuzione della query
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);
	            int ris = QueryLogin.register(stmt, user , pw, isOwner);
	            stmt.close();

	            // STEP 4.2: creazione ed esecuzione della query
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);
	            
	            if(ris==0) {												///DA FARE: VEDI SIGNIFICATO EXECUTEUPDATE
	            	
	            }

	        } finally {
	            // STEP 5.2: Clean-up dell'ambiente        	
	                if (stmt != null)
	                    stmt.close();
	                if (conn != null)
	                    conn.close();
	        }
	    }

}
