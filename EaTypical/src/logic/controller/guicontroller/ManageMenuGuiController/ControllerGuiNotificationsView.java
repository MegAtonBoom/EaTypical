/**
 * Sample Skeleton for 'NotificationsOwnerView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.controller.guicontroller.ControllerGuiHomePageOwner;
import logic.controller.guicontroller.OwnerBaseGuiController;
import logic.engineeringclasses.bean.manageMenu.BeanListNotificationsScheduling;
import logic.engineeringclasses.bean.manageMenu.BeanSchedulingNotification;
import logic.engineeringclasses.others.Session;

/**
 * 
 * @author Luca Capotombolo
 *
 */

public class ControllerGuiNotificationsView extends OwnerBaseGuiController {
	
	private BeanListNotificationsScheduling beanListNotificationsScheduling;
	private String username;
	public ControllerGuiNotificationsView(BeanListNotificationsScheduling beanListNotificationsScheduling, String username,Session bs) {
		super(bs);
		this.beanListNotificationsScheduling = beanListNotificationsScheduling;
		this.username = username;
	}
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="homeButton"
    private Button homeButton; // Value injected by FXMLLoader

    @FXML // fx:id="manageMenuButton"
    private Button manageMenuButton; // Value injected by FXMLLoader

    @FXML // fx:id="sponsorRestaurantButton"
    private Button sponsorRestaurantButton; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button continueButton; // Value injected by FXMLLoader

    @FXML // fx:id="nomeUtente"
    private Label nomeUtente; // Value injected by FXMLLoader

    @FXML // fx:id="tabellaNotifiche"
    private TableView<BeanSchedulingNotification> tabellaNotifiche; // Value injected by FXMLLoader

    @FXML // fx:id="turistaColonna"
    private TableColumn<BeanSchedulingNotification, String> turistaColonna; // Value injected by FXMLLoader

    @FXML // fx:id="ristoranteColonna"
    private TableColumn<BeanSchedulingNotification, String> ristoranteColonna; // Value injected by FXMLLoader

    @FXML // fx:id="dataColonna"
    private TableColumn<BeanSchedulingNotification, String> dataColonna; // Value injected by FXMLLoader

    @FXML // fx:id="momentoGiornataColonna"
    private TableColumn<BeanSchedulingNotification, String> momentoGiornataColonna; // Value injected by FXMLLoader

    @FXML
	public void goToHome(ActionEvent event) throws IOException {
    	//carico la gerarchia dei nodi
  	   FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/HomePageOwnerView.fxml"));
    	    	
  	   //setto il nuovo controller grafico
  	   loader.setControllerFactory(c ->  new ControllerGuiHomePageOwner(bs));
  	   Parent rootParent = loader.load();    	
    	
    	//cambio scena
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'NotificationsOwnerView.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'NotificationsOwnerView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'NotificationsOwnerView.fxml'.";
        assert continueButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'NotificationsOwnerView.fxml'.";
        assert nomeUtente != null : "fx:id=\"nomeUtente\" was not injected: check your FXML file 'NotificationsOwnerView.fxml'.";
        assert tabellaNotifiche != null : "fx:id=\"tabellaNotifiche\" was not injected: check your FXML file 'NotificationsOwnerView.fxml'.";
        assert turistaColonna != null : "fx:id=\"turistaColonna\" was not injected: check your FXML file 'NotificationsOwnerView.fxml'.";
        assert ristoranteColonna != null : "fx:id=\"ristoranteColonna\" was not injected: check your FXML file 'NotificationsOwnerView.fxml'.";
        assert dataColonna != null : "fx:id=\"dataColonna\" was not injected: check your FXML file 'NotificationsOwnerView.fxml'.";
        assert momentoGiornataColonna != null : "fx:id=\"momentoGiornataColonna\" was not injected: check your FXML file 'NotificationsOwnerView.fxml'.";

        
        turistaColonna.setCellValueFactory(new PropertyValueFactory<BeanSchedulingNotification,String>("username"));
        ristoranteColonna.setCellValueFactory(new PropertyValueFactory<BeanSchedulingNotification,String>("ristorante"));
        dataColonna.setCellValueFactory(new PropertyValueFactory<BeanSchedulingNotification,String>("data"));
        momentoGiornataColonna.setCellValueFactory(new PropertyValueFactory<BeanSchedulingNotification,String>("pranzoVsCena"));
        
        ObservableList<BeanSchedulingNotification> observableList = FXCollections.observableArrayList();
        for(int i = 0; i<beanListNotificationsScheduling.getNotifications().size();i++) {
        	observableList.add(beanListNotificationsScheduling.getNotifications().get(i));        	
        }
        nomeUtente.setText(username);
        tabellaNotifiche.setItems(observableList);
    }
}
