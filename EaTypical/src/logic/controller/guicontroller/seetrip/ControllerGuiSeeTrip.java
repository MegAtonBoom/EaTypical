package logic.controller.guicontroller.seetrip;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.controller.guicontroller.SchedulingBaseGuiController;
import logic.engineeringclasses.bean.scheduletrip.BeanOutputSchedule;
import logic.engineeringclasses.bean.scheduletrip.ConvertedBeanSchedule;
import logic.engineeringclasses.dao.SchedulingDAO;
import logic.engineeringclasses.others.Session;

public class ControllerGuiSeeTrip extends SchedulingBaseGuiController {
	
	private String seeTripPage = "/logic/view/standalone/seetrip/SeeTripView.fxml";
	
	public ControllerGuiSeeTrip(String city, BeanOutputSchedule[] scheduling, Session bs) {
		super(bs);
		this.city=city;
		this.scheduling=scheduling;
		
		if(scheduling!=null) {
			this.thereIsButton=true;
			this.convertedScheduling = convertDataType(this.thereIsButton);
		}
		else {
			this.thereIsButton=false;
			this.convertedScheduling = emptyScheduling();
		}
		
	}
	
	public ControllerGuiSeeTrip(String city, BeanOutputSchedule[] scheduling, String errorMessage, Session bs) {
		super(bs);
		this.city=city;
		this.scheduling=scheduling;
		this.errorMessage=errorMessage;
		
		if(scheduling!=null) {
			this.thereIsButton=true;
			this.convertedScheduling = convertDataType(this.thereIsButton);
		}
		else {
			this.thereIsButton=false;
			this.convertedScheduling = emptyScheduling();
		}
		
	}

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="errorLabel"
    private Label errorLabel; // Value injected by FXMLLoader
    
    @FXML // fx:id="deleteSchedulingButton"
    private Button deleteSchedulingButton; // Value injected by FXMLLoader
    
    @FXML
    void deleteScheduling(ActionEvent event) throws IOException {
    	try {
    		SchedulingDAO dao = new SchedulingDAO();
    		dao.delete(this.bs.getUser().getUsername());
    	
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.seeTripPage));
    		loader.setControllerFactory(c -> new ControllerGuiSeeTrip(this.city, null, bs));
    		Parent root=loader.load();
    		myAnchorPane.getChildren().setAll(root);
    	}
    	
    	catch(Exception e) {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.seeTripPage));
    		loader.setControllerFactory(c -> new ControllerGuiSeeTrip(this.city, this.scheduling, "An unknown error occurred. Please, try again later.", bs));
    		Parent root=loader.load();
    		myAnchorPane.getChildren().setAll(root);
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'SchedulingView.fxml'.";
        assert errorLabel != null : "fx:id=\"errorLabel\" was not injected: check your FXML file 'SchedulingView.fxml'.";
        assert deleteSchedulingButton != null : "fx:id=\"deleteSchedulingButton\" was not injected: check your FXML file 'SeeTripView.fxml'.";
        
        if(this.bs.getUser()!=null)
        	nomeUtenteLabel.setText(this.bs.getUser().getUsername());
        else
        	nomeUtenteLabel.setText("Not logged");
        
        cittaLabel.setText(this.city);
        errorLabel.setText(this.errorMessage);
        
        commonInitializeOperations();
        
        if(this.thereIsButton)
        	nameColumn.setCellValueFactory(new PropertyValueFactory<ConvertedBeanSchedule, String>("button"));
        else
        	nameColumn.setCellValueFactory(new PropertyValueFactory<ConvertedBeanSchedule, String>("name"));
        
        tabella.setItems(ol);
        
    }
    
    private ConvertedBeanSchedule[] emptyScheduling() {
    	ConvertedBeanSchedule[] convertedScheduling = new ConvertedBeanSchedule[1];
    	
    	String[] dateAndHour = new String[2];
    	for(int i=0; i<2; i++) {
    		dateAndHour[i] = "";
    	}
    	
    	String[] restInfo = new String[4];
    	restInfo[0]="";
    	restInfo[1]="There is no scheduling";
    	restInfo[2]="";
    	restInfo[3]="";
    	
    	convertedScheduling[0] = new ConvertedBeanSchedule(dateAndHour, restInfo, "", "");
    	return convertedScheduling;
    }
	
}
