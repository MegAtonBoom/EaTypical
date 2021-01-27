package logic.engineeringclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryNotifications {

	//look for the tourist notification, by username, in the db
	public static ResultSet touristNotifications(Statement stmt, String user) throws SQLException
	{
		String sql;
		sql = "SELECT * FROM NotificaMenuAggiornato WHERE UsernameTurista = '"+ user + "';";
		return stmt.executeQuery(sql);
	}
	
	//look for new reviews of a restaurant, for the owner, in the db
	public static ResultSet ownerReviewNotifications(Statement stmt, String rest) throws SQLException
	{
		String sql;
		sql = "SELECT * FROM NotificaRecensione WHERE NomeRistorante = '"+ rest + "';";
		return stmt.executeQuery(sql);
	}
	
	//look for new tourists that scheduled a trip to a restaurant, in the db
	public static ResultSet ownerSchedulingNotifications(Statement stmt, String rest) throws SQLException
	{
		String sql;
		sql = "SELECT * FROM NotificaScheduling WHERE NomeRistorante = '"+ rest + "';";
		return stmt.executeQuery(sql);
	}
	
	public static ResultSet ownerNotificationScheduling(Statement stmt,String username) throws SQLException {
		String sql;
		sql = "SELECT * FROM notificascheduling WHERE UsernameProprietario = '"+ username + "';";
		return stmt.executeQuery(sql);
	}
}
