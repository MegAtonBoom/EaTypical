/**
 * Sample Skeleton for 'DeleteDishView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;
import logic.controller.guicontroller.OwnerBaseGuiController;
import logic.engineeringclasses.bean.manageMenu.BeanDeleteDish;
import logic.engineeringclasses.bean.manageMenu.BeanErrorDish;
import logic.engineeringclasses.others.Session;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 * 
 * @author Luca Capotombolo
 *
 */

public class ControllerGuiDeleteDish  extends OwnerBaseGuiController{

	private List<String> obs1;
	private List<String> obs2;
	private String username;
	private BeanErrorDish beanErrorDish;
	private int errorePiatto = -1;
	
	public ControllerGuiDeleteDish(String username,List<String> obs1, List<String> obs2,int errorePiatto,BeanErrorDish beanErrorDish,Session bs) {
		super(bs);
		this.obs1 = obs1;
    	this.obs2 = obs2;
		this.username = username;
		this.beanErrorDish = beanErrorDish;
		this.errorePiatto = errorePiatto;
	}
	
	@FXML
	private Label campoMancantePiatto;
	
	@FXML
	private Label errorePiattoLabel;
	
	@FXML
	private Label campoMancanteRistorante;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private ChoiceBox<String> scegliRistorante;

    @FXML // fx:id="nomeUtente"
    private Label nomeUtente; // Value injected by FXMLLoader

    @FXML // fx:id="choiseDish"
    private ChoiceBox<String> choiseDish; // Value injected by FXMLLoader

    @FXML // fx:id="deleteButton"
    private Button deleteButton; // Value injected by FXMLLoader
    
    private static final String MANCANTE = "Mancante";

    @FXML
    void delete(ActionEvent event) throws IOException {
    	
    	String ristorante = scegliRistorante.getValue();
    	String piatto = choiseDish.getValue(); 
    	int count = 0;
    	
    	
    	
    	if(piatto == null) {
    		campoMancantePiatto.setText(MANCANTE);
    		count++;
    	}else {
			campoMancantePiatto.setText("");
		}
		if(ristorante == null) {
    		campoMancanteRistorante.setText(MANCANTE);
    		count++;
    	}else {
			campoMancanteRistorante.setText("");
		}
    	
    	if(count>0) return;
    	
    	//ottengo il nodo radice fxml e vado a settare il controller grafico della nuova GUI
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/ConfirmMessageView.fxml"));
    	BeanDeleteDish beanDeleteDish = new BeanDeleteDish(ristorante, piatto,2);
    	loader.setControllerFactory(c -> new ControllerGuiConfirmMessageView(username,beanDeleteDish,bs));
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
    }

        

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert backButton != null : "fx:id=\"back\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert nomeUtente != null : "fx:id=\"nomeUtente\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert choiseDish != null : "fx:id=\"choiseDish\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert campoMancanteRistorante != null : "fx:id=\"campoMancanteRistorante\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert campoMancantePiatto != null : "fx:id=\"\"campoMancantePiatto\"\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert errorePiattoLabel != null : "fx:id=\"\"errorePiattoLabel\"\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        
        for(int i = 0; i<this.obs1.size();i++) {
        	choiseDish.getItems().add(this.obs1.get(i));
        }
        
        for(int i = 0; i<this.obs2.size();i++) {
        	scegliRistorante.getItems().add(this.obs2.get(i));
        }
        nomeUtente.setText(username);
        
        if(this.errorePiatto==2) {
        	this.errorePiattoLabel.setText(beanErrorDish.getMess());
        }
    }
}
