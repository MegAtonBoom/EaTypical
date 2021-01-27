// DA FIXARE
package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.engineeringclasses.query.QueryReview;
import logic.model.Review;
import logic.model.Tourist;


public class ReviewsDAO {

//Note this is the USER on the DBMS that has proper privileges in order to access the specific DB 	
	private static String DB_USER = "root";
    private static String DB_PASS = "password";
    private static String DB_URL = "jdbc:mysql://localhost:3308/progettoispwfinaledatabase";
    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";

    public static List<Review> findRestaurantReviews(String restaurant) throws Exception {
        // STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = null;
        List<Review> listOfReviews = new ArrayList<Review>();
        
        try {
            Class.forName(DRIVER_CLASS_NAME);

            //conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            conn = DriverManager.getConnection(connectionString);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs;
            
	            rs = QueryReview.selectReviews(stmt,restaurant);
	            do{									//// SISTEMA TURISTA
	                String text = rs.getString("Contenuto");
	                int vote = rs.getInt("Voto");
	                Tourist tourist=new Tourist(null,null,rs.getString("UsernameTurista"),null,null,null);
	                Review rev = new Review(text,tourist, vote,null);
	                listOfReviews.add(rev);
	            }while(rs.next());            
            
            // STEP 5.1: Clean-up dell'ambiente
            rs.close();
        	} finally {
            // STEP 5.2: Clean-up dell'ambiente
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

        return listOfReviews;
    }
    public static Review findRestaurantReviews(String restaurant,String username) throws Exception {		//recensione di un certo ristorante e di un certo utente
        // STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = null;
        
        ///List<Review> listOfReviews = new ArrayList<Review>();
        Review rev;
        try {
            // STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);

            // STEP 3: apertura connessione
            //conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            conn = DriverManager.getConnection(connectionString);
            // STEP 4: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs;
            
	            rs = QueryReview.selectReviewsByName(stmt,restaurant, username);
	            do{									//// SISTEMA TURISTA
	                String text = rs.getString("Contenuto");
	                int vote = rs.getInt("Voto");
	                rev = new Review(text, vote);
	            }while(rs.next());  
	            
            
            // STEP 5.1: Clean-up dell'ambiente
            rs.close();
        	} finally {
            // STEP 5.2: Clean-up dell'ambiente
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

        return rev;
    }

    

    public static void insertReview(Review review) throws Exception {
        Statement stmt = null;
        Connection conn = null;
        String username=review.getTourist().getUsername();
        String restaurant=review.getRestaurant().getName();
        String content=review.getText();
        int vote=review.getVote();
        
        
        try {
            Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            QueryReview.insertReview(stmt, username, restaurant, content, vote);
            
            
            
            stmt.close();

        } finally {
            // STEP 5.2: Clean-up dell'ambiente        	
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
        }
    }

    
}
