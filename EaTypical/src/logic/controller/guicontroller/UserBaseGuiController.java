package logic.controller.guicontroller;

import java.io.IOException;

import logic.engineeringclasses.others.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logic.controller.guicontroller.ScheduleTrip.*;

//The second layer of Graphic Controllers: every normal user has the ChooseResytaurant Button and the Schedule Trip Page button
public abstract class UserBaseGuiController extends BaseGuiController {
	
	protected String errorMessage = "You must login to use this function.";
	protected String chooseRestPage = "/logic/view/standalone/ChooseRestaurant/ItalianViewCity.fxml";
	protected String scheduleTripPage = "/logic/view/standalone/ScheduleTrip/ItalianViewCity.fxml";
	
	protected UserBaseGuiController(Session bs) {
		super(bs);
	}
	
    @FXML
    protected Button chooseRestaurantButton;

    @FXML
    protected Button scheduleTripButton;
    
    @FXML
    protected Label mustLoginLabel;

	@FXML
	void goToChooseRestaurantPage(ActionEvent event) throws IOException {	//The Choose Restaurant Page button onAction method
	
		bs.getSizedStack().push(this.chooseRestPage);
    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.chooseRestPage));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }
	
    @FXML
    void goToScheduleTripPage(ActionEvent event) throws IOException {		//The Schedule Trip Page button onAction method	
    	if(bs.getUser()!=null) {
    		bs.getSizedStack().push(this.scheduleTripPage);
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.scheduleTripPage));
    		loader.setControllerFactory(c -> new ControllerGuiItalianViewCity(bs));
    		Parent root=loader.load();
    		myAnchorPane.getChildren().setAll(root);
    	}
    	else {
    		mustLoginLabel.setText(errorMessage);
    		mustLoginLabel.setVisible(true);
    	}
    	
    }

}
