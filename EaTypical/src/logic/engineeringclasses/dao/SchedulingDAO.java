package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.engineeringclasses.others.Connect;
import logic.engineeringclasses.query.QueryScheduling;
import logic.model.Scheduling;
import logic.model.Tourist;

public class SchedulingDAO {
	
	public void delete(Tourist tourist) throws ClassNotFoundException, SQLException {
		// Step 1: declarations
		String driverClassName = "com.mysql.jdbc.Driver";
		Statement stmt=null;
		Connection conn=null;
		
		try {
			// Step 2: dinamic loading of sql driver
			Class.forName(driverClassName);
			
			// Step 3: connection opening
			conn = Connect.getInstance().getDBConnection();
			
			// Step 4: creation and execution of query
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			QueryScheduling.deleteScheduling(stmt, tourist.getUsername());
			
		}
		
		finally {
			try {
				if(stmt!=null) {
					stmt.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		
	}
	
	public void insert(Scheduling schedEntity) throws ClassNotFoundException, SQLException {
		// Step 1: declarations
		String driverClassName = "com.mysql.jdbc.Driver";
		Statement stmt=null;
		Connection conn=null;
		
		try {
			// Step 2: dinamic loading of sql driver
			Class.forName(driverClassName);
			
			// Step 3: connection opening
			conn = Connect.getInstance().getDBConnection();
			
			// Step 4: creation and execution of query
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			QueryScheduling.insertScheduling(stmt, schedEntity.getTourist().getUsername(), schedEntity.getDate(), schedEntity.isAtLunch(), schedEntity.getRest().getName());
			
		}
		
		finally {
			try {
				if(stmt!=null) {
					stmt.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}		
	}

}
