package logic.controller.guicontroller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import logic.engineeringclasses.others.Session;

//Base Graphic Controller: every view page has a back button and a home button
public class BaseGuiController {
	
	
	 protected Session bs;
	 protected BaseGuiController(Session bs){
	 	this.bs = bs;
	 }
	
	
	protected String homePageTourist = "/logic/view/standalone/HomePageTouristView.fxml";
	protected String homePageOwner = "/logic/view/standalone/HomePageOwnerView.fxml";
    
	@FXML
    protected AnchorPane myAnchorPane;
	
    @FXML
    protected Button backButton;
    
    @FXML
    protected Button homeButton;
	
	@FXML
    void goHomePage(ActionEvent event) throws IOException {			//The Home Page button onAction method
		
		bs.getSizedStack().clearStack();
		
		// Bisogna aggiungere il controllo su se si tratta di un utente non loggato, un turista o un owner
		
    	bs.getSizedStack().push(this.bs.getSizedStack().getFirstPage());

    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.bs.getSizedStack().pop()));
		if(this.bs.isOwner())
		{
			loader.setControllerFactory(c -> new ControllerGuiHomePageOwner(this.bs));
		}
		else
			loader.setControllerFactory(c -> new ControllerGuiHomePageTourist(this.bs));
    	
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }

    @FXML
    void goToBackPage(ActionEvent event) throws IOException {		//The Back Button onAction method
    	
    	// TO FIX (Per esempio NON vengono chiamati i costruttori giusti dei controller applicativi)
    	//String page=SizedStack.getSizedStack().pop();
    	//String page=SizedStack.getSizedStack().read();
    	
    	
    	//Devo aggiungere le Bean di sessione in cui ci sarà la pagina precedente
    	//FXMLLoader loader=new FXMLLoader(getClass().getResource(page));			
    	//Parent root=loader.load();
    	//myAnchorPane.getChildren().setAll(root);
    }

}
