/**
 * Sample Skeleton for 'SetOpeningHoursView.fxml' Controller Class
 */

package logic.controller.guicontroller.SponsorRestaurant;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import logic.controller.guicontroller.UserBaseGuiController;

public class ControllerGuiSetOpeningHours extends UserBaseGuiController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="sundayLunch"
    private CheckBox sundayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="sundayDinner"
    private CheckBox sundayDinner; // Value injected by FXMLLoader

    @FXML // fx:id="saturdayLunch"
    private CheckBox saturdayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="mondayLunch"
    private CheckBox mondayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="tuesdayLunch"
    private CheckBox tuesdayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="wednesdayLunch"
    private CheckBox wednesdayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="thursdayLunch"
    private CheckBox thursdayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="fridayLunch"
    private CheckBox fridayLunch; // Value injected by FXMLLoader

    @FXML // fx:id="mondayDinner"
    private CheckBox mondayDinner; // Value injected by FXMLLoader

    @FXML // fx:id="tuesdayDinner"
    private CheckBox tuesdayDinner; // Value injected by FXMLLoader

    @FXML // fx:id="wednesdayDinner"
    private CheckBox wednesdayDinner; // Value injected by FXMLLoader

    @FXML // fx:id="thursdayDinner"
    private CheckBox thursdayDinner; // Value injected by FXMLLoader

    @FXML // fx:id="fridayDinner"
    private CheckBox fridayDinner; // Value injected by FXMLLoader

    @FXML // fx:id="saturdayDinner"
    private CheckBox saturdayDinner; // Value injected by FXMLLoader

    @FXML
    void setOpeningHours(ActionEvent event) {
    	// To do
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert okButton != null : "fx:id=\"okButton\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert sundayLunch != null : "fx:id=\"sundayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert sundayDinner != null : "fx:id=\"sundayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert saturdayLunch != null : "fx:id=\"saturdayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert mondayLunch != null : "fx:id=\"mondayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert tuesdayLunch != null : "fx:id=\"tuesdayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert wednesdayLunch != null : "fx:id=\"wednesdayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert thursdayLunch != null : "fx:id=\"thursdayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert fridayLunch != null : "fx:id=\"fridayLunch\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert mondayDinner != null : "fx:id=\"mondayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert tuesdayDinner != null : "fx:id=\"tuesdayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert wednesdayDinner != null : "fx:id=\"wednesdayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert thursdayDinner != null : "fx:id=\"thursdayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert fridayDinner != null : "fx:id=\"fridayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";
        assert saturdayDinner != null : "fx:id=\"saturdayDinner\" was not injected: check your FXML file 'SetOpeningHoursView.fxml'.";

    }
}
