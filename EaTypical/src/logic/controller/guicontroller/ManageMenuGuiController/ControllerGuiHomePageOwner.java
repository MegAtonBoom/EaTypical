
package logic.controller.guicontroller;

/**
 * Sample Skeleton for 'HomePageOwnerView.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerGuiHomePageOwner extends OwnerBaseGuiController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;    

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="labelBenvenuto"
    private Label labelBenvenuto; // Value injected by FXMLLoader

   

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert myAnchorPane != null : "fx:id=\"myAnchorPane\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";
        assert labelBenvenuto != null : "fx:id=\"labelBenvenuto\" was not injected: check your FXML file 'HomePageOwnerView.fxml'.";

    }
}
