/**
 * Sample Skeleton for 'RestaurantView.fxml' Controller Class
 */

package logic.controller.guicontroller.ChooseRestaurant;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.controller.applicationcontroller.ChooseRestaurant;
import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.bean.chooserestaurant.ChooseRestaurantBean;
import logic.engineeringclasses.dao.FavouriteRestDAO;
import logic.engineeringclasses.others.Session;
public class ControllerGuiRestaurantView extends UserBaseGuiController{

	private ArrayList<ArrayList<String>> allRestaurants;
	private ArrayList<ArrayList<String>> celiacRestaurants;
	private ArrayList<ArrayList<String>> veganRestaurants;
	private ArrayList<ArrayList<String>> bothRestaurants;
	private ObservableList<String> allRestaurantNames=FXCollections.observableArrayList();
	private ObservableList<String> veganRestaurantNames=FXCollections.observableArrayList();
	private ObservableList<String> celiacRestaurantNames=FXCollections.observableArrayList();
	private ObservableList<String> bothRestaurantNames=FXCollections.observableArrayList();
	private String writeReviewPage="/logic/view/standalone/ChooseRestaurant/WriteReviewView.fxml";
	private String readReviewsPage="/logic/view/standalone/ChooseRestaurant/ReadReviewsView.fxml";
	private String genericErrortext="Please try again!";
	
	
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button restUpdateButton;

    @FXML
    private Button inforUpdateButton;
    
    @FXML
    private ChoiceBox<String> restChoice;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField voteTextField;
    
    @FXML
    private CheckBox celiacCheck;

    @FXML
    private CheckBox veganCheck;
    
    @FXML
    private Label noSelection;
    
    @FXML
    private Label genericError;

    @FXML // fx:id="addressLabel"
    private Label addressLabel; // Value injected by FXMLLoader

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="saveFavButton"
    private Button saveFavButton; // Value injected by FXMLLoader

    @FXML // fx:id="readReviewsButton"
    private Button readReviewsButton; // Value injected by FXMLLoader

    @FXML // fx:id="writeReviewButton"
    private Button writeReviewButton; // Value injected by FXMLLoader
    
    
    public ControllerGuiRestaurantView(String city, Session bs)
   	{
   		super(bs);
   		ChooseRestaurant cr=new ChooseRestaurant();
   		ChooseRestaurantBean cb=cr.getallRestaurants(city);
   		this.allRestaurants=cb.getAllRestaurants();
   		this.celiacRestaurants=cb.getCeliacRestaurants();
   		this.veganRestaurants=cb.getVeganRestaurants();
   		this.bothRestaurants=cb.getBothRestaurants();
   		setAllNames();
   		setVeganNames();
   		setCeliacNames();
   		setBothNames();
   	}
    
    

    @FXML
    void goToReadreviewsPage(ActionEvent event) throws IOException {		//TO DO
    	boolean restChosen=restChoice.getSelectionModel().isEmpty();
    	if(restChosen)
    	{
    		String restaurant = restChoice.getSelectionModel().getSelectedItem();
	    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.readReviewsPage));
			loader.setControllerFactory(c -> new ControllerGuiWriteReview(restaurant, this.bs));
			Parent root=loader.load();
			myAnchorPane.getChildren().setAll(root);
    	}
    }
    
    @FXML
    void goToWriteReviewPage(ActionEvent event) throws IOException {		//TO Do
    	boolean restChosen=restChoice.getSelectionModel().isEmpty();
    	if(!isLogged())
    	{   		
        	this.mustLoginLabel.setText(errorMessage);
        	this.mustLoginLabel.setVisible(true);  
    	}
    	else if((!restChosen  &&  isLogged()))
    	{
	    	System.out.print("WritereviewPage\n");
	    	String restaurant = restChoice.getSelectionModel().getSelectedItem();
	    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.writeReviewPage));
			loader.setControllerFactory(c -> new ControllerGuiWriteReview(restaurant, this.bs));
			Parent root=loader.load();
			myAnchorPane.getChildren().setAll(root);
    	}
    	else
    	{   		
    		mustLoginLabel.setText(errorMessage);
        	mustLoginLabel.setVisible(true);  
        	
    	}
    }
    
    @FXML
    void saveFavourites(ActionEvent event) {			//TO DO
    	System.out.print("saveFav");
    	boolean restChosen=restChoice.getSelectionModel().isEmpty();
    	try
    	{
	    	if(!isLogged())
	    	{   		
	        	this.mustLoginLabel.setText(errorMessage);
	        	this.mustLoginLabel.setVisible(true);  
	    	}
	    	else if((!restChosen  &&  isLogged()))
	    	{
	    		String restaurant = restChoice.getSelectionModel().getSelectedItem();
	    		String username=this.bs.getUser().getUsername();
	    		FavouriteRestDAO.insertFavourite(restaurant,username);
	    	}
    	}
    	catch(Exception e)
    	{
    		this.genericError.setText(genericErrortext);
    		this.genericError.setVisible(restChosen);
    	}
    	
    }
    
    @FXML
    void updateInfo(ActionEvent event) {
    	String name;
    	if(!restChoice.getSelectionModel().isEmpty())
    	{
    		name=restChoice.getValue();
    		checkName(name);
    		for(List<String> rest : this.allRestaurants)
    		{
    			this.allRestaurantNames.add(rest.get(0));
    		}
    		
    	}

    }
    
    private void checkName(String name)
    {
    	for(List<String> rest : this.allRestaurants)
		{
			if(rest.get(0).equals(name))
				updateFields(rest.get(1),rest.get(2));
		}
    }
    
    private void updateFields(String address, String vote)
    {
    	this.addressTextField.setText(address);
    	this.voteTextField.setText(vote);
    }

    
    
    
    @FXML
    void updateRestaurants(ActionEvent event) {

    	this.restChoice.getSelectionModel().clearSelection();
    	boolean celiac=this.celiacCheck.isSelected();
    	boolean vegan=this.veganCheck.isSelected();
    	
    	if(celiac&&vegan)
    	{
    		restChoice.setItems(this.bothRestaurantNames);
    	}
    	else if(celiac)
    	{
    		restChoice.setItems(this.celiacRestaurantNames);
    	}
    	else if(vegan)
    	{
    		restChoice.setItems(this.veganRestaurantNames);
    	}
    	else
    		restChoice.setItems(this.allRestaurantNames);
    
    	this.addressTextField.setText("");
    	this.voteTextField.setText("");
    }
    
   
	
	private void setAllNames() 
	{
		for(List<String> rest : this.allRestaurants)
		{
			this.allRestaurantNames.add(rest.get(0));
		}
	}
	
	private void setCeliacNames() 
	{
		for(List<String> rest : this.celiacRestaurants)
		{
			this.celiacRestaurantNames.add(rest.get(0));
		}
	}
	
	private void setVeganNames() 
	{
		for(List<String> rest : this.veganRestaurants)
		{
			this.veganRestaurantNames.add(rest.get(0));
		}
	}
	
	private void setBothNames() 
	{
		for(List<String> rest : this.bothRestaurants)
		{
			this.bothRestaurantNames.add(rest.get(0));
		}
	}
	
	
	private boolean isLogged()
	{
		return (this.bs.getUser()==null);
	}
	
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert addressLabel != null : "fx:id=\"addressLabel\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert saveFavButton != null : "fx:id=\"saveFavButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert readReviewsButton != null : "fx:id=\"readReviewsButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert writeReviewButton != null : "fx:id=\"writeReviewButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert mustLoginLabel != null : "fx:id=\"mustLoginLabel\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert restUpdateButton != null : "fx:id=\"restUpdateButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert inforUpdateButton != null : "fx:id=\"inforUpdateButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert addressTextField != null : "fx:id=\"addressTextField\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert voteTextField != null : "fx:id=\"voteTextField\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert restChoice != null : "fx:id=\"restChoice\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert celiacCheck != null : "fx:id=\"celiacCheck\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert veganCheck != null : "fx:id=\"veganCheck\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert noSelection != null : "fx:id=\"noSelection\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert genericError != null : "fx:id=\"genericError\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        if(this.bs.getUser()!=null)
        	nomeUtenteLabel.setText(this.bs.getUser().getUsername());
        else
        	nomeUtenteLabel.setText("Not logged");
        restChoice.setItems(allRestaurantNames);
        
        
    }
}
