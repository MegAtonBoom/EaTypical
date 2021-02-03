/**
 * Sample Skeleton for 'CreatingRestaurantView.fxml' Controller Class
 */

package logic.controller.guicontroller.SponsorRestaurant;

import logic.controller.guicontroller.OwnerBaseGuiController;
import logic.engineeringclasses.bean.sponsorrestaurant.BeanNewRestaurant;
import logic.engineeringclasses.exceptions.EmptyFieldException;
import logic.engineeringclasses.others.Cities;
import logic.engineeringclasses.others.Session;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerGuiCreatingRestaurant extends OwnerBaseGuiController {
	private String errorMessage;
	private String openingHoursPage = "/logic/view/standalone/SponsorRestaurant/SetOpeningHoursView.fxml";
	
	public ControllerGuiCreatingRestaurant(Session bs) {
		super(bs);
		this.errorMessage="";
	}
	
	public ControllerGuiCreatingRestaurant(String errorMsg, Session bs) {
		super(bs);
		this.errorMessage=errorMsg;
	}

	private ObservableList<String> cityList=FXCollections.observableArrayList();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="setOpeningHoursButton"
    private Button setOpeningHoursButton; // Value injected by FXMLLoader

    @FXML // fx:id="restNameTextBox"
    private TextField restNameTextBox; // Value injected by FXMLLoader

    @FXML // fx:id="addrNameTextBox"
    private TextField addrNameTextBox; // Value injected by FXMLLoader
    
    @FXML // fx:id="choiceBox"
    private ChoiceBox<String> choiceBox; // Value injected by FXMLLoader
    
    @FXML // fx:id="errorLabel"
    private Label errorLabel; // Value injected by FXMLLoader
    
	@FXML
    void goToOpeningHoursPage(ActionEvent event) throws IOException {
    	try {
    		String name = restNameTextBox.getText();
    		String address = addrNameTextBox.getText();
    		String city = choiceBox.getValue();
    		
    		if(name.equals("") || address.equals("") || city==null) {
    			throw new EmptyFieldException(this.errorMessage);
    		}
    		
    		BeanNewRestaurant bnr = new BeanNewRestaurant(name, address, city, this.bs.getUser().getUsername());
    		
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.openingHoursPage));
    		loader.setControllerFactory(c -> new ControllerGuiSetOpeningHours(bnr, this.bs));
    		Parent root=loader.load();
    		myAnchorPane.getChildren().setAll(root);   
    		
    	}
    	catch(EmptyFieldException e) {
    		this.errorMessage="You need to insert name, address and city of your restaurant before setting the opening hours";
    		errorLabel.setText(this.errorMessage);
    	}
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'CreatingRestaurantView.fxml'.";
        assert setOpeningHoursButton != null : "fx:id=\"setOpeningHoursButton\" was not injected: check your FXML file 'CreatingRestaurantView.fxml'.";
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'CreatingRestaurantView.fxml'.";
        assert restNameTextBox != null : "fx:id=\"restNameTextBox\" was not injected: check your FXML file 'CreatingRestaurantView.fxml'.";
        assert addrNameTextBox != null : "fx:id=\"addrNameTextBox\" was not injected: check your FXML file 'CreatingRestaurantView.fxml'.";
        assert errorLabel != null : "fx:id=\"errorLabel\" was not injected: check your FXML file 'CreatingRestaurantView.fxml'.";
        
        errorLabel.setText(this.errorMessage);
        
        for(Cities city:Cities.values())
        {
        	cityList.add(city.nome);
        }
        choiceBox.setItems(this.cityList);       
    }
}
