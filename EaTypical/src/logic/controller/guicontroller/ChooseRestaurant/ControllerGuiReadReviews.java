/**
 * Sample Skeleton for 'ReadReviewsView.fxml' Controller Class
 */

package logic.controller.guicontroller.ChooseRestaurant;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import logic.controller.applicationcontroller.ReadReviews;
import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.bean.chooserestaurant.BeanReadReviews;
import logic.engineeringclasses.others.Session;
public class ControllerGuiReadReviews extends UserBaseGuiController{
	
	private String restaurant;
	private ArrayList<ArrayList<String>> reviews;
	String error="Error. Please try to reaload.";
	
	public ControllerGuiReadReviews(String restaurant, Session bs) 
	{
		super(bs);
		this.restaurant=restaurant;						
	}
	
	private void writeError()
	{
		this.reviewArea.setText(error);
	}
	
	private void writeReviews()
	{
		String username;
		String content;
		String vote;
		for(ArrayList<String> review: this.reviews)
		{
			username=review.get(0);
			vote=review.get(2);
			content=review.get(1);
			this.reviewArea.appendText("User: "+username+"	vote: "+vote+"\n\n" );
			this.reviewArea.appendText("That user said: "+content+"\n\n\n");
		}
	}

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    //@FXML // fx:id="scroll"
    //private AnchorPane scroll; // Value injected by FXMLLoader

    @FXML // fx:id="voteLabel"
    private Label voteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="nomeRistLabel"
    private Label nomeRistLabel; // Value injected by FXMLLoader
    
    @FXML
    private TextArea reviewArea;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestButton\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleButton\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        //assert scroll != null : "fx:id=\"scroll\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert voteLabel != null : "fx:id=\"voteLabel\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert nomeRistLabel != null : "fx:id=\"nomeRistLabel\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert reviewArea != null : "fx:id=\"reviewArea\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        if(this.bs.getUser()!=null)
        	nomeUtenteLabel.setText(this.bs.getUser().getUsername());
        else
        	nomeUtenteLabel.setText("Not logged");
        
        this.reviewArea.setEditable(false);
        
        try
		{		
			
			ReadReviews rv=new ReadReviews();
			BeanReadReviews b=rv.findReviews(restaurant);
			this.reviews=b.getReviews();
			this.nomeRistLabel.setText(restaurant);
			writeReviews();
		}
		catch(Exception e)
		{
			writeError();
		}	

    }
}
