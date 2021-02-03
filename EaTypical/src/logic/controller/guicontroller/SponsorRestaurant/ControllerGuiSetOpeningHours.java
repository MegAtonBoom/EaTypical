/**
 * Sample Skeleton for 'SetOpeningHoursView.fxml' Controller Class
 */

package logic.controller.guicontroller.SponsorRestaurant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import logic.controller.applicationcontroller.SponsorRestaurant;
import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.bean.sponsorrestaurant.BeanNewRestaurant;
import logic.engineeringclasses.exceptions.AlreadyInUseRestaurantNameException;
import logic.engineeringclasses.others.Session;

public class ControllerGuiSetOpeningHours extends UserBaseGuiController {
	private BeanNewRestaurant bnr;
	private String savedMessage = "Restaurant saved successfully.";
	private String creatingRestPage = "/logic/view/standalone/SponsorRestaurant/CreatingRestaurantView.fxml";
	
	public ControllerGuiSetOpeningHours(BeanNewRestaurant bnr, Session bs) {
		super(bs);
		this.bnr=bnr;
	}

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="sundayLunch"
    private CheckBox sundayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="sundayDinner"
    private CheckBox sundayDinner; // Value injected by FXMLLoader

    @FXML // fx:id="saturdayLunch"
    private CheckBox saturdayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="mondayLunch"
    private CheckBox mondayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="tuesdayLunch"
    private CheckBox tuesdayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="wednesdayLunch"
    private CheckBox wednesdayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="thursdayLunch"
    private CheckBox thursdayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="fridayLunch"
    private CheckBox fridayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="mondayDinner"
    private CheckBox mondayDinner; // Value injected by FXMLLoader

    @FXML // fx:id="tuesdayDinner"
    private CheckBox tuesdayDinner; // Value injected by FXMLLoader

    @FXML // fx:id="wednesdayDinner"
    private CheckBox wednesdayDinner; // Value injected by FXMLLoader

    @FXML // fx:id="thursdayDinner"
    private CheckBox thursdayDinner; // Value injected by FXMLLoader

    @FXML // fx:id="fridayDinner"
    private CheckBox fridayDinner; // Value injected by FXMLLoader

    @FXML // fx:id="saturdayDinner"
    private CheckBox saturdayDinner; // Value injected by FXMLLoader

    @FXML // fx:id="savedLabel"
    private Label savedLabel; // Value injected by FXMLLoader

    @FXML
    void saveRestaurant(ActionEvent event) throws IOException {
    	try {
    		boolean[][] openingHours = new boolean[7][2];
    	
    		openingHours[0][0] = sundayLunch.isSelected();
    		openingHours[0][1] = sundayDinner.isSelected();
    		openingHours[1][0] = mondayLunch.isSelected();
    		openingHours[1][1] = mondayDinner.isSelected();
    		openingHours[2][0] = tuesdayLunch.isSelected();
    		openingHours[2][1] = tuesdayDinner.isSelected();
    		openingHours[3][0] = wednesdayLunch.isSelected();
    		openingHours[3][1] = wednesdayDinner.isSelected();
    		openingHours[4][0] = thursdayLunch.isSelected();
    		openingHours[4][1] = thursdayDinner.isSelected();
    		openingHours[5][0] = fridayLunch.isSelected();
    		openingHours[5][1] = fridayDinner.isSelected();
    		openingHours[6][0] = saturdayLunch.isSelected();
    		openingHours[6][1] = saturdayDinner.isSelected();
    	
    		bnr.setOpeningHours(openingHours);
    		SponsorRestaurant sponsorRest = new SponsorRestaurant();
    		sponsorRest.saveRestaurant(this.bnr);;
    		savedLabel.setText(this.savedMessage);
    	}
    	
    	catch(AlreadyInUseRestaurantNameException e) {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.creatingRestPage));
    		loader.setControllerFactory(c -> new ControllerGuiCreatingRestaurant("This restaurant has already been sponsored.", bs));
    		Parent root=loader.load();
    		myAnchorPane.getChildren().setAll(root);    
    	}
    	catch(Exception e) {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.creatingRestPage));
    		loader.setControllerFactory(c -> new ControllerGuiCreatingRestaurant("An unknown error occurred. Please, try again later.", bs));
    		Parent root=loader.load();
    		myAnchorPane.getChildren().setAll(root);
    	}
    	;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert okButton != null : "fx:id=\"okButton\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert sundayLunch != null : "fx:id=\"sundayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert sundayDinner != null : "fx:id=\"sundayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert saturdayLunch != null : "fx:id=\"saturdayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert mondayLunch != null : "fx:id=\"mondayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert tuesdayLunch != null : "fx:id=\"tuesdayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert wednesdayLunch != null : "fx:id=\"wednesdayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert thursdayLunch != null : "fx:id=\"thursdayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert fridayLunch != null : "fx:id=\"fridayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert mondayDinner != null : "fx:id=\"mondayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert tuesdayDinner != null : "fx:id=\"tuesdayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert wednesdayDinner != null : "fx:id=\"wednesdayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert thursdayDinner != null : "fx:id=\"thursdayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert fridayDinner != null : "fx:id=\"fridayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert saturdayDinner != null : "fx:id=\"saturdayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert savedLabel != null : "fx:id=\"savedLabel\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        
    }
}
