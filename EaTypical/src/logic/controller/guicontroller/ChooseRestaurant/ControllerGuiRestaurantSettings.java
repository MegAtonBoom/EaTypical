package logic.controller.guicontroller.ChooseRestaurant;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.controller.guicontroller.UserBaseGuiController;
public class ControllerGuiRestaurantSettings extends UserBaseGuiController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField budgetButton;

    @FXML
    private Label nomeUtente;

    @FXML
    private CheckBox cbVegan;

    @FXML
    private CheckBox cbCeliac;

    @FXML
    private TextField averageVoteButton;

    @FXML
    private CheckBox cb4;

    @FXML
    private CheckBox cb3;

    @FXML
    private CheckBox cb1;

    @FXML
    private CheckBox cb2;

    @FXML
    private Button continueButton;

    @FXML
    void continueMethod(ActionEvent event) {
    	System.out.print("Continue\n");
    }


    @FXML
    void initialize() {
        assert budgetButton != null : "fx:id=\"budgetButton\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleTripButton\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestaurantButton\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";
        assert nomeUtente != null : "fx:id=\"nomeUtente\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";
        assert cbVegan != null : "fx:id=\"cbVegan\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";
        assert cbCeliac != null : "fx:id=\"cbCeliac\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";
        assert averageVoteButton != null : "fx:id=\"averageVoteButton\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";
        assert cb4 != null : "fx:id=\"cb4\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";
        assert cb3 != null : "fx:id=\"cb3\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";
        assert cb1 != null : "fx:id=\"cb1\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";
        assert cb2 != null : "fx:id=\"cb2\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";
        assert continueButton != null : "fx:id=\"continueButton\" was not injected: check your FXML file 'RestaurantSettingsView.fxml'.";

    }
}
