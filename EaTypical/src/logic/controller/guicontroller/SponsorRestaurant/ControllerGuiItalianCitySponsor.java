/**
 * Sample Skeleton for 'ItalianCitySponsorView.fxml' Controller Class
 */

package logic.controller.guicontroller.SponsorRestaurant;

import logic.controller.guicontroller.OwnerBaseGuiController;
import logic.engineeringclasses.others.Cities;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;

public class ControllerGuiItalianCitySponsor extends OwnerBaseGuiController {
	
	ObservableList<String> list=FXCollections.observableArrayList();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="continueButton"
    private Button continueButton; // Value injected by FXMLLoader

    @FXML // fx:id="choiceBox"
    private ChoiceBox<String> choiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="torino"
    private ImageView torino; // Value injected by FXMLLoader

    @FXML // fx:id="aosta"
    private ImageView aosta; // Value injected by FXMLLoader

    @FXML // fx:id="genova"
    private ImageView genova; // Value injected by FXMLLoader

    @FXML // fx:id="milano"
    private ImageView milano; // Value injected by FXMLLoader

    @FXML // fx:id="trento"
    private ImageView trento; // Value injected by FXMLLoader

    @FXML // fx:id="trieste"
    private ImageView trieste; // Value injected by FXMLLoader

    @FXML // fx:id="venezia"
    private ImageView venezia; // Value injected by FXMLLoader

    @FXML // fx:id="bologna"
    private ImageView bologna; // Value injected by FXMLLoader

    @FXML // fx:id="firenze"
    private ImageView firenze; // Value injected by FXMLLoader

    @FXML // fx:id="ancona"
    private ImageView ancona; // Value injected by FXMLLoader

    @FXML // fx:id="perugia"
    private ImageView perugia; // Value injected by FXMLLoader

    @FXML // fx:id="roma"
    private ImageView roma; // Value injected by FXMLLoader

    @FXML // fx:id="laquila"
    private ImageView laquila; // Value injected by FXMLLoader

    @FXML // fx:id="campobasso"
    private ImageView campobasso; // Value injected by FXMLLoader

    @FXML // fx:id="napoli"
    private ImageView napoli; // Value injected by FXMLLoader

    @FXML // fx:id="bari"
    private ImageView bari; // Value injected by FXMLLoader

    @FXML // fx:id="potenza"
    private ImageView potenza; // Value injected by FXMLLoader

    @FXML // fx:id="catanzaro"
    private ImageView catanzaro; // Value injected by FXMLLoader

    @FXML // fx:id="palermo"
    private ImageView palermo; // Value injected by FXMLLoader

    @FXML // fx:id="cagliari"
    private ImageView cagliari; // Value injected by FXMLLoader

    @FXML
    void selectCityChoiceBox(MouseEvent event) {
    	String imageId=((ImageView)event.getSource()).getId();
    	String selection;
    	if(imageId.equals("laquila"))
    	{
    		selection="L'Aquila";
    	}
    	else
    	{
    		selection=(imageId.substring(0, 1).toUpperCase() + imageId.substring(1));
    	}
    	choiceBox.getSelectionModel().select(selection);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert continueButton != null : "fx:id=\"continueButton\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert torino != null : "fx:id=\"torino\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert aosta != null : "fx:id=\"aosta\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert genova != null : "fx:id=\"genova\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert milano != null : "fx:id=\"milano\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert trento != null : "fx:id=\"trento\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert trieste != null : "fx:id=\"trieste\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert venezia != null : "fx:id=\"venezia\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert bologna != null : "fx:id=\"bologna\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert firenze != null : "fx:id=\"firenze\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert ancona != null : "fx:id=\"ancona\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert perugia != null : "fx:id=\"perugia\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert roma != null : "fx:id=\"roma\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert laquila != null : "fx:id=\"laquila\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert campobasso != null : "fx:id=\"campobasso\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert napoli != null : "fx:id=\"napoli\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert bari != null : "fx:id=\"bari\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert potenza != null : "fx:id=\"potenza\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert catanzaro != null : "fx:id=\"catanzaro\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert palermo != null : "fx:id=\"palermo\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        assert cagliari != null : "fx:id=\"cagliari\" was not injected: check your FXML file 'ItalianCitySponsorView.fxml'.";
        for(Cities city:Cities.values())
        {
        	list.add(city.nome);
        }
        choiceBox.setItems(this.list);

    }
}
