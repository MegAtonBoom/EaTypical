/**
 * Sample Skeleton for 'AdviceView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import logic.controller.guicontroller.OwnerBaseGuiController;
import logic.engineeringclasses.bean.manageMenu.BeanAdvice;
import logic.engineeringclasses.others.Session;

public class ControllerGuiAdviceView  extends OwnerBaseGuiController{

	private String username;
	private BeanAdvice beanAdvice;
	
	public ControllerGuiAdviceView(String username,BeanAdvice beanAdvice,Session bs) {
		super(bs);
		this.username = username;
		this.beanAdvice = beanAdvice;
	}
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    
    @FXML
    private Label labelUtente;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private TextArea area;

    @FXML // fx:id="doneButton"
    private Button doneButton; // Value injected by FXMLLoader

  
    /**
     * Ritorno alla pagina principale del caso d'uso Manage Menu
     * @param event
     * @throws IOException
     */
    @FXML
    void done(ActionEvent event) throws IOException {
    	//carico la gerarchia dei nodi
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/RestaurantMenuView.fxml"));    	
    	loader.setControllerFactory(c -> {return new ControllerGuiRestaurantMenuView(username,bs);});
    	Parent rootParent = loader.load();
    	//cambio scena
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    

   

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'AdviceView.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'AdviceView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'AdviceView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'AdviceView.fxml'.";
        assert doneButton != null : "fx:id=\"doneButton\" was not injected: check your FXML file 'AdviceView.fxml'.";
        assert area != null : "fx:id=\"area\" was not injected: check your FXML file 'AdviceView.fxml'.";
        assert labelUtente != null : "fx:id=\"labelUtente\" was not injected: check your FXML file 'AdviceView.fxml'.";
        String linea = "Possibili piatti tipici da poter aggiungere ai menu dei tuoi ristoranti:";
        labelUtente.setText(username);
        for(int i=0;i<beanAdvice.getPiattiMancanti().size();i++) {
        	linea = linea +  "\nPiatto " + i + ": " + beanAdvice.getPiattiMancanti().get(i);
        }
        area.setText(linea);        
    }
}
