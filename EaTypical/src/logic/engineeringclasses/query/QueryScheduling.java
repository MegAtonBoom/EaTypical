package logic.engineeringclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryScheduling {

	private QueryScheduling() {}
	
	public static void deleteScheduling(Statement stmt, String username) throws SQLException {
		stmt.executeUpdate("DELETE FROM Scheduling WHERE Username = '" +username+ "'");
	}
	
	public static void insertScheduling(Statement stmt, String username, String date, boolean atLunch, String nameRest) throws SQLException {
		stmt.executeUpdate("INSERT INTO Scheduling VALUES('" +nameRest+ "', '" +username+ "', '" +date+ "', '" +atLunch+ "')");
	}
	
	public static ResultSet selectSchedules(Statement stmt, String username) throws SQLException
	{
		String query;
		query="SELECT * FROM Scheduling WHERE Username = '" + username + "';";
		return stmt.executeQuery(query);
	}
}
