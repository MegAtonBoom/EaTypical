package logic.controller.guicontroller;





/**
 * Sample Skeleton for 'HomePageOwnerView.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logic.controller.guicontroller.ManageMenuGuiController.ControllerGuiNotificationsView;
import logic.engineeringclasses.bean.manageMenu.BeanListNotificationsScheduling;
import logic.engineeringclasses.dao.NotificationsOwnerDAO;
import logic.engineeringclasses.others.Session;

/**
 * 
 * @author Luca Capotombolo
 *
 */

public class ControllerGuiHomePageOwner extends OwnerBaseGuiController {
	
	
	
	public ControllerGuiHomePageOwner(Session bs) {
		super(bs);
	}

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;    

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="labelBenvenuto"
    private Label labelBenvenuto; // Value injected by FXMLLoader
    
    @FXML
    private Button bottoneNotifiche;

    public void goToNotificationsView(ActionEvent e) throws ClassNotFoundException, IOException {
 	   System.out.print("Colpito\n");
 	  NotificationsOwnerDAO notificationsDAO = new NotificationsOwnerDAO();
 	   BeanListNotificationsScheduling beanListNotificationsScheduling = notificationsDAO.selectOwnerSchedulingNotifications("liuk");
 	   
 	   //carico la gerarchia dei nodi
 	   FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/NotificationsRestaurantViewScheduling.fxml"));
   	    	
 	   //setto il nuovo controller grafico
 	   loader.setControllerFactory(c -> {return new ControllerGuiNotificationsView(beanListNotificationsScheduling,"liuk",bs);});
 	   Parent rootParent = loader.load();    	
   	
   	//cambio scena
   	myAnchorPane.getChildren().setAll(rootParent);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert myAnchorPane != null : "fx:id=\"myAnchorPane\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        assert labelBenvenuto != null : "fx:id=\"labelBenvenuto\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        assert bottoneNotifiche != null : "fx:id=\"bottoneNotifiche\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        labelBenvenuto.setText(this.bs.getUser().getName());
        nomeUtenteLabel.setText(this.bs.getUser().getUsername());
    }
}
