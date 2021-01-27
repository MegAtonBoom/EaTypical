package logic.engineeringclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.model.User;


public class QueryLogin {
	
	//look for a tourist account in the database, by username and password
	public static ResultSet loginTourist(Statement stmt, String user, String pw) throws SQLException
	{
		String sql;
		sql = "SELECT * FROM Turista WHERE Username = '"+ user + "' and PASSWORD = '"+ pw +"';";
		return stmt.executeQuery(sql);
	}
	
	//look if there's a tourist with a specific username
	public static ResultSet loginTourist(Statement stmt, String user) throws SQLException
	{
		String sql;
		sql = "SELECT * FROM Turista WHERE Username = '"+ user + "';";
		return stmt.executeQuery(sql);
	}
	
	//look for an owner account in the database, by username and password
	public static ResultSet loginOwner(Statement stmt, String user, String pw) throws SQLException
	{
		String sql;
		sql = "SELECT * FROM Proprietario WHERE Username = '"+ user + "' and PASSWORD = '"+ pw +"';";
		return stmt.executeQuery(sql);
	}
	
	//look if there's an owner with a specific username
	public static ResultSet loginOwner(Statement stmt, String user) throws SQLException
	{
		String sql;
		sql = "SELECT * FROM Proprietario WHERE Username = '"+ user + "';";
		return stmt.executeQuery(sql);
	}
	
	//insert a new tourist account in the database with all his registration data
	public static int registerTourist(Statement stmt, User user, String pw) throws SQLException
	{	
		String insertStatement;
		String name=user.getName();
		String surname=user.getSurname();
		String username=user.getUsername();
		insertStatement = String.format("INSERT INTO Turista (Nome, Cognome, Username, Password) VALUES ('%s','%s','%s','%s')", name, surname, username , pw);
		System.out.println("Turista Registrato");				        	
		return stmt.executeUpdate(insertStatement);
	}
	
	//insert a new owner account in the database with all his registration data
	public static int registerOwner(Statement stmt, User user, String pw) throws SQLException{
		String insertStatement;
		String name=user.getName();
		String surname=user.getSurname();
		String username=user.getUsername();
		insertStatement = String.format("INSERT INTO Proprietario (Nome, Cognome, Username, Password) VALUES ('%s','%s','%s','%s')", name, surname, username , pw);
		System.out.println("Proprietario Registrato");
		return stmt.executeUpdate(insertStatement);
	}
	
}
