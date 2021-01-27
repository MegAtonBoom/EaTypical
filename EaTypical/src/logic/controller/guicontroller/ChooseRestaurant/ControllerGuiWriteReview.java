/**
 * Sample Skeleton for 'WriteReviewView.fxml' Controller Class
 */

package logic.controller.guicontroller.ChooseRestaurant;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import logic.controller.applicationcontroller.WriteReview;
import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.bean.chooserestaurant.BeanNewReview;
import logic.engineeringclasses.exceptions.EmptyReviewFieldException;
import logic.engineeringclasses.others.Session;
public class ControllerGuiWriteReview extends UserBaseGuiController {

	private String restaurant;
	private ObservableList<String> votes=FXCollections.observableArrayList();
	private String successString="Your review hads been successfully submitted.";
	
	public ControllerGuiWriteReview(String restaurant, Session bs)
	{
		super(bs);
		this.restaurant=restaurant;
		for(int i=0;i<5;i++)
		{
			this.votes.add(""+(i+1));
		}
		
	}
	
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML
    private Label emptyText;
    
    @FXML
    private Label successLabel;

    @FXML
    private Label genericError;

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML
    private ChoiceBox<String> voteChoice;

    @FXML // fx:id="textArea"
    private TextArea textArea; // Value injected by FXMLLoader

    @FXML // fx:id="publishButton"
    private Button publishButton; // Value injected by FXMLLoader
    
    @FXML
    void publishMethod() {

    	try
    	{   		    	
	    	BeanNewReview bnr= new BeanNewReview();
	    	setBeanData(bnr);
	    	WriteReview wr= new WriteReview();
	    	wr.write(bnr);
	    	this.successLabel.setText(this.successString);
	    	this.successLabel.setVisible(true);
    	}
    	catch (EmptyReviewFieldException e) 
    	{
			this.emptyText.setText(e.getMessage());
			this.emptyText.setVisible(true);
		} 
    	catch (Exception e) 
    	{
			this.genericError.setText("Error, please try again later");
			this.genericError.setVisible(true);
		}
    
    
    }
    private void setBeanData(BeanNewReview bnr) throws EmptyReviewFieldException
    {
    	
    	
			bnr.setContent(this.textArea.getText());
			bnr.setUsername(this.bs.getUser().getUsername());
			bnr.setVote(getVote());
			bnr.setRestaurant(this.restaurant);
		
    	
    }
    
    private String getVote()
    {
    	return this.voteChoice.getValue().toString();
    }

    @FXML 
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestButton\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleButton\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert voteChoice != null : "fx:id=\"voteChoice\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert publishButton != null : "fx:id=\"publishButton\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert emptyText != null : "fx:id=\"emptyText\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert genericError != null : "fx:id=\"genericError\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert successLabel != null : "fx:id=\"successLabel\" was not injected: check your FXML file 'WriteReviewView.fxml'.";


        if(this.bs.getUser()!=null)
        	nomeUtenteLabel.setText(this.bs.getUser().getUsername());
        else
        	nomeUtenteLabel.setText("Not logged");
        
        this.voteChoice.setItems(this.votes);
        this.voteChoice.getSelectionModel().select(2);

    }
}
