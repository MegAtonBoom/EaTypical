
package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.engineeringclasses.others.Connect;
import logic.engineeringclasses.query.QueryReview;
import logic.model.Review;
import logic.model.Tourist;


public class ReviewsDAO {

	


    public static List<Review> findRestaurantReviews(String restaurant) throws ClassNotFoundException, SQLException   {
        Statement stmt = null;
        Connection conn = null;
        String driverClassName = "com.mysql.jdbc.Driver";
        List<Review> listOfReviews = new ArrayList<Review>();
        
        try {
            Class.forName(driverClassName);

            conn = Connect.getInstance().getDBConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs;
            
	            rs = QueryReview.selectReviews(stmt,restaurant);
	            do{								
	                String text = rs.getString("Contenuto");
	                int vote = rs.getInt("Voto");
	                Tourist tourist=new Tourist(null,null,rs.getString("UsernameTurista"),null,null,null);
	                Review rev = new Review(text,tourist, vote,null);
	                listOfReviews.add(rev);
	            }while(rs.next());            
            

            rs.close();
        	} finally {

            
                if (stmt != null)
                    stmt.close();
          
            
        }

        return listOfReviews;
    }
    public static Review findRestaurantReviews(String restaurant,String username) throws ClassNotFoundException, SQLException {		//recensione di un certo ristorante e di un certo utente
        Statement stmt = null;
        Connection conn = null;
        String driverClassName = "com.mysql.jdbc.Driver";
        
        Review rev;
        
            Class.forName(driverClassName);

            conn = Connect.getInstance().getDBConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs;
            
	            rs = QueryReview.selectReviewsByName(stmt,restaurant, username);
	            do{									
	                String text = rs.getString("Contenuto");
	                int vote = rs.getInt("Voto");
	                rev = new Review(text, vote);
	            }while(rs.next());  
	                       

        return rev;
    }

    

    public static void insertReview(Review review) throws ClassNotFoundException, SQLException  {
        Statement stmt = null;
        Connection conn = null;
        String driverClassName = "com.mysql.jdbc.Driver";
        String username=review.getTourist().getUsername();
        String restaurant=review.getRestaurant().getName();
        String content=review.getText();
        int vote=review.getVote();
        
        
        
            Class.forName(driverClassName);
            conn = Connect.getInstance().getDBConnection();

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            QueryReview.insertReview(stmt, username, restaurant, content, vote);            
                        
        stmt.close();
         
    }

    
}
