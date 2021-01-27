/**
 * Sample Skeleton for 'ItalianViewCity.fxml' Controller Class
 */

package logic.controller.guicontroller.ScheduleTrip;

import logic.controller.guicontroller.ItalianViewBaseGuiController;
import logic.engineeringclasses.others.Session;
import logic.engineeringclasses.exceptions.EmptyFieldException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControllerGuiItalianViewCity extends ItalianViewBaseGuiController {	
	
	private String tripSettingsPage = "/logic/view/standalone/ScheduleTrip/TripSettingsView.fxml";
	private String errorMessage="";
	
	public ControllerGuiItalianViewCity(Session bs) {
		super(bs);
	}
	
	public ControllerGuiItalianViewCity(String errorMessage, Session bs) {
		super(bs);
		this.errorMessage=errorMessage;
	}

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="continueButton"
    private Button continueButton; // Value injected by FXMLLoader

    @FXML // fx:id="errorLabel"
    private Label errorLabel; // Value injected by FXMLLoader
    
    @FXML
    void goToTripSettingsPage(ActionEvent event) throws IOException, ClassNotFoundException { 	//The Trip Settings Page button onAction method		
		try {
			String city = choiceBox.getValue();
			if(city==null) {
				throw new EmptyFieldException("There is no city selected.");
			}
		
			this.bs.getSizedStack().push(this.tripSettingsPage);
			FXMLLoader loader=new FXMLLoader(getClass().getResource(this.tripSettingsPage));
			loader.setControllerFactory(c -> new ControllerGuiTripSettings(city, bs));
			Parent root=loader.load();
			myAnchorPane.getChildren().setAll(root);
		}
		
		catch(EmptyFieldException e) {
			FXMLLoader loader=new FXMLLoader(getClass().getResource(this.scheduleTripPage));
			loader.setControllerFactory(c -> new ControllerGuiItalianViewCity(e.getMessage(), bs));
			Parent root=loader.load();
			myAnchorPane.getChildren().setAll(root);
		}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert myAnchorPane != null : "fx:id=\"pane\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleTripButton\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestaurantButton\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert continueButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert errorLabel != null : "fx:id=\"errorLabel\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtente\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        
        commonInitializeOperations();
        if(this.bs.getUser()!=null)
        	nomeUtenteLabel.setText(this.bs.getUser().getUsername());
        else
        	nomeUtenteLabel.setText("Not logged");
        errorLabel.setText(this.errorMessage);
    }
}
