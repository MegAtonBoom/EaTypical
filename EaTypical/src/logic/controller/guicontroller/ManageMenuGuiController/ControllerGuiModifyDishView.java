/**
 * Sample Skeleton for 'ModifyDishView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import logic.controller.guicontroller.OwnerBaseGuiController;
import logic.engineeringclasses.bean.manageMenu.BeanAddDish;
import logic.engineeringclasses.bean.manageMenu.BeanErrorDish;
import logic.engineeringclasses.others.Session;

/**
 * 
 * @author Luca Capotombolo
 *
 */

public class ControllerGuiModifyDishView  extends OwnerBaseGuiController{

	private String username;
	private List<String> obs;
	private List<String> obs2;
	private int errorePiatto = -1;
	private BeanErrorDish beanErrorDish;
	
	public ControllerGuiModifyDishView(String username, List<String> obs,List<String> obs2,int errorePiatto, BeanErrorDish beanErrorDish,Session bs) {
		super(bs);
		this.username = username;
		this.obs = obs;
		this.obs2 = obs2;
		this.errorePiatto = errorePiatto;
		this.beanErrorDish = beanErrorDish;
	}
	
	@FXML
	private Label campoMancateContenuto;
	
	@FXML
	private Label campoMancantePiatto;
	
	@FXML
	private Label campoMancanteRistorante;
	
	@FXML
	private Label campoMancantePrezzo;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    
    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="choiseBox"
    private ChoiceBox<String> choiseBox; // Value injected by FXMLLoader

    @FXML // fx:id="veganCheck"
    private CheckBox veganCheck; // Value injected by FXMLLoader

    @FXML // fx:id="celiacCheck"
    private CheckBox celiacCheck; // Value injected by FXMLLoader

    @FXML // fx:id="priceText"
    private TextField priceText; // Value injected by FXMLLoader

    @FXML // fx:id="modifyButton"
    private Button modifyButton; // Value injected by FXMLLoader
    
    @FXML
    private ChoiceBox<String> choiseRistoranti;
    
    @FXML
    private TextArea nuovoContenuto;

    @FXML
    private Label errorePiattoLabel;
    
    private static final String MANCANTE = "Mancante";
  

    @FXML
    void modify(ActionEvent event) throws IOException {
    	
    	int count = 0;
    	//definisco ed inizializzo i parametri del costruttore del controller grafico    	
    	String piatto = choiseBox.getValue(); 
    	String contenuto = nuovoContenuto.getText();
    	String ristorante = choiseRistoranti.getValue();
    	String prezzoString = priceText.getText();
    	boolean vegano = veganCheck.isSelected();
    	boolean celiaco = celiacCheck.isSelected();
    	
    	if(contenuto.equals(""))
    	{
    		campoMancateContenuto.setText(MANCANTE);
    		count++;
    	}else {
    		campoMancateContenuto.setText("");
    	}
    	if(ristorante==null) {
    		campoMancanteRistorante.setText(MANCANTE);
    		count++;
    	}else {
    		campoMancanteRistorante.setText("");
    	}
    	if(prezzoString.equals("")) {
    		campoMancantePrezzo.setText(MANCANTE);
    		count++;
    	}else {
    		campoMancantePrezzo.setText("");
    	}
    	
    	if(piatto==null) {
    		campoMancantePiatto.setText(MANCANTE);
    		count++;
    	}else {
    		campoMancantePiatto.setText("");
    	}
    	
    	if(count>0) return;
    	
    	
    	
    	double prezzo = Double.parseDouble(priceText.getText());
    	
    	//ottengo il nodo radice fxml e vado a settare il controller grafico della nuova GUI
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/ConfirmMessageView.fxml"));
    	BeanAddDish beanAddDish = new BeanAddDish(piatto, ristorante, contenuto, vegano, celiaco, prezzo, 1);
    	loader.setControllerFactory(c -> new ControllerGuiConfirmMessageView(username,beanAddDish,bs));
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
    }

   

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert choiseBox != null : "fx:id=\"choiseBox\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert choiseRistoranti != null : "fx:id=\"choiseRistoranti\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert veganCheck != null : "fx:id=\"veganCheck\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert celiacCheck != null : "fx:id=\"celiacCheck\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert priceText != null : "fx:id=\"priceText\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert modifyButton != null : "fx:id=\"modifyButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert campoMancateContenuto != null : "fx:id=\"campoMancanteContenuto\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert campoMancantePiatto != null : "fx:id=\"campoMancantePiatto\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert campoMancanteRistorante != null : "fx:id=\"campoMancanteRistorante\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert campoMancantePrezzo != null : "fx:id=\"nuovoContenuto\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert errorePiattoLabel != null : "fx:id=\"errorePiattoLabel\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        
        nomeUtenteLabel.setText(username);
        
        for(int i = 0; i<this.obs.size();i++) {
        	choiseBox.getItems().add(this.obs.get(i));
        }
        for(int i = 0; i<this.obs2.size();i++) {
        	choiseRistoranti.getItems().add(this.obs2.get(i));
        }
        
        if(this.errorePiatto!=-1) {
        	this.errorePiattoLabel.setText(this.beanErrorDish.getMess());
        }
    }
}

