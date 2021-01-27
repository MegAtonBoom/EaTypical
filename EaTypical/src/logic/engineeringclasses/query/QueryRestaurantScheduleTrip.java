package logic.engineeringclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryRestaurantScheduleTrip {
	
	private QueryRestaurantScheduleTrip() {}

	public static ResultSet selectRestaurantsForTrip(Statement stmt, String city, boolean vegan, boolean celiac) throws SQLException {
		String sql;
		String firstPartQuery = "SELECT distinct Nome, Indirizzo, UsernameProprietario, VotoMedio, Totale, GiornoSettimana, ApertoAPranzo, ApertoACena FROM Ristorante, Menu M, Piatto P, Apertura A "
				+ "WHERE M.NomeRistorante=Nome and P.NomeRistorante=Nome and A.NomeRistorante=Nome and Citta='" +city+ "'";
		String lastPartQuery = " ORDER BY Nome;";
		
		if(vegan) {
			if(celiac)
				sql = firstPartQuery + " and Vegano='1' and Celiaco='1'" + lastPartQuery;
			else
				sql = firstPartQuery + " and Vegano='1'" + lastPartQuery;
		}
		
		else {
			if(celiac)
				sql = firstPartQuery + " and Celiaco='1'" + lastPartQuery;
			else
				sql = firstPartQuery + lastPartQuery;
		}
		
		return stmt.executeQuery(sql);
		
	}
	
}
