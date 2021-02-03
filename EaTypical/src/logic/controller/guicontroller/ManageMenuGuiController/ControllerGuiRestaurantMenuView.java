/**
 * Sample Skeleton for 'RestaurantMenuView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;


import logic.controller.applicationcontroller.ManageMenu;
import logic.controller.guicontroller.OwnerBaseGuiController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logic.engineeringclasses.bean.manageMenu.BeanAdvice;
import logic.engineeringclasses.bean.manageMenu.BeanErrorDish;
import logic.engineeringclasses.bean.manageMenu.BeanErrorDishAlreadyExists;
import logic.engineeringclasses.dao.RecipeDAO;
import logic.engineeringclasses.dao.RestaurantDAO;
import logic.engineeringclasses.others.Session;

/**
 * 
 * @author Luca Capotombolo
 *
 */

public class ControllerGuiRestaurantMenuView  extends OwnerBaseGuiController{

	private String username;
	private int errorePiatto = -1;
	private BeanErrorDish beanErrorDish = null;
	private BeanErrorDishAlreadyExists beanErrorDishAlreadyExists = null;
	
	public ControllerGuiRestaurantMenuView(String username,int errore, BeanErrorDish beanErrorDish,Session bs) {
		super(bs);
		this.username = username;
		this.errorePiatto = errore;
		this.beanErrorDish = beanErrorDish;
	}
	
	public ControllerGuiRestaurantMenuView(String username,int errore, BeanErrorDishAlreadyExists beanErrorDishAlreadyExists,Session bs) {
		super(bs);
		this.username = username;
		this.errorePiatto = errore;
		this.beanErrorDishAlreadyExists = beanErrorDishAlreadyExists;
	}
	
	
	public ControllerGuiRestaurantMenuView(String username,Session bs) {
		super(bs);
		this.username = username;
		
	}
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;


    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="deleteDishButton"
    private Button deleteDishButton; // Value injected by FXMLLoader

    @FXML // fx:id="addADishButton"
    private Button addADishButton; // Value injected by FXMLLoader

    @FXML // fx:id="modifyADishButton"
    private Button modifyADishButton; // Value injected by FXMLLoader

    @FXML // fx:id="getAdviceButton"
    private Button getAdviceButton; // Value injected by FXMLLoader

    /**
     * Ottiene i piatti disponibili e i ristoranti di sua proprieta 
     * per poi passarli al costruttore del controller grafico di AddDishView
     * @param event
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @FXML
    void addADish(ActionEvent event) throws IOException, ClassNotFoundException {    	
    	
    	//ottengo le ricette che possono essere aggiunte
    	RecipeDAO recipeDAO = new RecipeDAO();
    	ArrayList<String> obs1 = (ArrayList<String>) recipeDAO.selectAllRecipe(); 

    	//ottengo i ristoranti dell'utente
    	RestaurantDAO restaurantDAO = new RestaurantDAO();
    	ArrayList<String> obs2 = (ArrayList<String>) restaurantDAO.selectOwnRestaurant("liuk");
    	
    	//carico la gerarchia dei nodi
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/AddDish.fxml"));
    	    	
    	//setto il nuovo controller grafico
    	loader.setControllerFactory(c -> new ControllerGuiAddDishView(obs1,obs2,nomeUtenteLabel.getText(),this.errorePiatto,this.beanErrorDishAlreadyExists,bs));
    	Parent rootParent = loader.load();    	
    	
    	//cambio scena
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    /**
     * ottiene i piatti e le ricette di tutti i ristoranti dell'utente
     * Li passa al controller grafico della view successiva in cui l'utente potrÃƒÆ’Ã‚Â  fare la selezione
     * @param event
     * @throws IOException
     * @throws ClassNotFoundException
     */
    
    @FXML
    void deleteADish(ActionEvent event) throws IOException, ClassNotFoundException {    	
    	
    	//ottengo tutte le ricette di tutti i ristoranti dell'utente
    	RecipeDAO recipeDAO = new RecipeDAO();
    	ArrayList<String> obs1 = (ArrayList<String>) recipeDAO.selectOwnRecipe(nomeUtenteLabel.getText());
    	
    	//ottengo tutti i ristoranti dell'utente
    	  	
    	RestaurantDAO restaurantDAO = new RestaurantDAO();
    	ArrayList<String> obs2 = (ArrayList<String>) restaurantDAO.selectOwnRestaurant(nomeUtenteLabel.getText());
    	
    	//FXMLLoader e setto il nuovo controller grafico
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/DeleteDishView.fxml"));
    	loader.setControllerFactory(c -> new ControllerGuiDeleteDish(nomeUtenteLabel.getText(),obs1,obs2,this.errorePiatto,this.beanErrorDish,bs));
    	Parent rootParent = loader.load();    	
    	
    	//cambio scena
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    /**
     * Il sistema fornisce all'utente i piatti tipici della sua zona che non
     * offre ai clienti
     * @param event
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @FXML
    void getAdvice(ActionEvent event) throws IOException, ClassNotFoundException {
    	
    	//chiamo l'applicativo per ottenere la lista di suggerimenti da farmi dare
    	ManageMenu manageMenu = new ManageMenu();
    	BeanAdvice beanAdvices = manageMenu.advice(username);
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/AdviceView.fxml"));    	
    	loader.setControllerFactory(c -> new ControllerGuiAdviceView(username,beanAdvices,bs));
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    

    /**
     * Vengono caricati i ristoranti e i piatti dell'utente per poi passarli
     * alla view successiva tramite cui l'utente potrÃƒÆ’Ã‚Â  cancellarli
     * @param event
     * @throws IOException
     * @throws ClassNotFoundException
     */
   

    @FXML
    void modifyADish(ActionEvent event) throws IOException, ClassNotFoundException {
    	
    	RecipeDAO recipeDAO = new RecipeDAO();
    	
    	//ottengo le ricette dei ristoranti del proprietario
    	ArrayList<String> obs = (ArrayList<String>) recipeDAO.selectOwnRecipe(nomeUtenteLabel.getText());
    	
    	RestaurantDAO restaurantDAO = new RestaurantDAO();
    	
    	ArrayList<String> obs2 = (ArrayList<String>) restaurantDAO.selectOwnRestaurant(username);
    
    	//FXMLLoader e setto il nuovo controller grafico
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/ModifyDishView.fxml"));
    	loader.setControllerFactory(c -> new ControllerGuiModifyDishView(nomeUtenteLabel.getText(),obs,obs2,this.errorePiatto,this.beanErrorDish,bs));
    	Parent rootParent = loader.load();      	
    	
    	//carica GUI successiva
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws ClassNotFoundException, IOException {
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert deleteDishButton != null : "fx:id=\"deleteDishButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert addADishButton != null : "fx:id=\"addADishButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert modifyADishButton != null : "fx:id=\"modifyADishButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert getAdviceButton != null : "fx:id=\"getAdviceButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        
        nomeUtenteLabel.setText(this.username);
        
        //se si ÃƒÆ’Ã‚Â¨ verificato un errore all'atto dell'inserimento del piatto l'utente viene reindirizzato alla pagina 
        //per l'inserimento e viene avvisato dell'errore
        if(this.errorePiatto == 0 ) {
        	this.addADish(null);
        }else if(this.errorePiatto == 1) {
        	this.modifyADish(null);
        }else if(this.errorePiatto == 2) {
        	this.deleteADish(null);
        }
    }
}
