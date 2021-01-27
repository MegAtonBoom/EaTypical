package logic.engineeringclasses.others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	private String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase3?user=root&password=Monte_20&serverTimezone=UTC";
	private static Connect instance=null;
	private Connection conn=null;
	
	protected Connect() {}
	
	public static synchronized Connect getInstance() {
		if(Connect.instance==null) {
			Connect.instance = new Connect();
		}
		return Connect.instance;
	}
	
	public Connection getDBConnection() throws SQLException {
		if(this.conn==null) {
			this.conn = DriverManager.getConnection(this.connectionString);
		}
		return this.conn;
	}

}
