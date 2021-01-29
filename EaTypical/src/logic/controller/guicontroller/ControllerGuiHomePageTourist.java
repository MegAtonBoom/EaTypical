/**
 * Sample Skeleton for 'HomePageTouristView.fxml' Controller Class
 */

package logic.controller.guicontroller;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logic.controller.guicontroller.login.LoginGuiController;
import logic.controller.guicontroller.seetrip.ControllerGuiSeeTrip;
import logic.engineeringclasses.bean.scheduletrip.BeanOutputSchedule;
import logic.engineeringclasses.others.BeanConverter;
import logic.engineeringclasses.others.Session;

public class ControllerGuiHomePageTourist extends UserBaseGuiController {
	
	private String seeTripPage = "/logic/view/standalone/seetrip/SeeTripView.fxml";
	private String loginPage = "/logic/view/standalone/login/loginView.fxml";

    public ControllerGuiHomePageTourist(Session bs) {
		super(bs);	
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML
    private Button logButton;

    @FXML // fx:id="tripsButton"
    private Button tripsButton; // Value injected by FXMLLoader

    @FXML // fx:id="favouriteRestaurantsButton"
    private Button favouriteRestaurantsButton; // Value injected by FXMLLoader

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="labelBenvenuto"
    private Label labelBenvenuto; // Value injected by FXMLLoader
    
    @FXML // fx:id="seeNotificationsButton"
    private Button seeNotificationsButton; // Value injected by FXMLLoader
    
    @FXML
    void goToNotificationsPage(ActionEvent event) {
    	// To do
    }

    @FXML
    void goToFavouriteRestaurantsPage(ActionEvent event) {
    	//To do
    }

    @FXML
    void goToTripsPage(ActionEvent event) throws IOException {
    	try {
    		BeanConverter converter = new BeanConverter();
    		BeanOutputSchedule[] scheduling = converter.convertScheduling(bs.getUser());
    		String city = converter.getCityFromScheduling(bs.getUser());
    		
    		this.bs.getSizedStack().push(this.seeTripPage);
        	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.seeTripPage));
        	loader.setControllerFactory(c -> new ControllerGuiSeeTrip(city, scheduling, bs));
        	Parent root=loader.load();
        	myAnchorPane.getChildren().setAll(root);    
    		
    	}
    	catch(ParseException e) {
    		// To do
    		e.printStackTrace();
    	}
    	
    }
    

    @FXML
    void logMethod(ActionEvent event) throws IOException {
    	if(this.bs.getUser()==null)
    	{
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.loginPage));
			loader.setControllerFactory(c -> new LoginGuiController(this.bs));
			Parent root=loader.load();
			myAnchorPane.getChildren().setAll(root);
    	}
    	else {
    		Session bs=new Session(false);
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.homePageTourist));
        	loader.setControllerFactory(c -> new ControllerGuiHomePageTourist(bs));
        	Parent root=loader.load();
        	myAnchorPane.getChildren().setAll(root);
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tripsButton != null : "fx:id=\"tripsButton\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";
        assert favouriteRestaurantsButton != null : "fx:id=\"favouriteRestaurantsButton\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";
        assert labelBenvenuto != null : "fx:id=\"labelBenvenuto\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";
        assert seeNotificationsButton != null : "fx:id=\"seeNotificationsButton\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";
        assert mustLoginLabel != null : "fx:id=\"mustLoginLabel\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";
        assert logButton != null : "fx:id=\"logButton\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";       
        if(this.bs.getUser()!=null) {
        	nomeUtenteLabel.setText(this.bs.getUser().getUsername());
        	this.logButton.setText("Logout");
        }
        else {
        	nomeUtenteLabel.setText("Not logged");
        	this.logButton.setText("Login");
        }
        
    }
}
