package logic.engineeringclasses.others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	//private String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Kp*d.!>3&serverTimezone=UTC";
	private String connectionString = "jdbc:mysql://localhost:3308/progettoispwfinaledatabase?user=root&password=password.!>3&serverTimezone=UTC";
	String a="jdbc:mysql://localhost:3308/progettoispwfinaledatabase?";
	String b="user=root&password=password";
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
			//this.conn = DriverManager.getConnection(this.connectionString);
			this.conn=DriverManager.getConnection(a+b);
		}
		return this.conn;
	}

}
