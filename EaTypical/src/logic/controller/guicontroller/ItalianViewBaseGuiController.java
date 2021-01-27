package logic.controller.guicontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import logic.engineeringclasses.others.Cities;
import logic.engineeringclasses.others.Session;

public abstract class ItalianViewBaseGuiController extends UserBaseGuiController {
	protected ObservableList<String> list=FXCollections.observableArrayList();
	
	public ItalianViewBaseGuiController(Session bs) {
		super(bs);
	}
	
    @FXML // fx:id="torino"
    protected ImageView torino; // Value injected by FXMLLoader

    @FXML // fx:id="aosta"
    protected ImageView aosta; // Value injected by FXMLLoader

    @FXML // fx:id="genova"
    protected ImageView genova; // Value injected by FXMLLoader

    @FXML // fx:id="milano"
    protected ImageView milano; // Value injected by FXMLLoader

    @FXML // fx:id="trento"
    protected ImageView trento; // Value injected by FXMLLoader

    @FXML // fx:id="trieste"
    protected ImageView trieste; // Value injected by FXMLLoader

    @FXML // fx:id="venezia"
    protected ImageView venezia; // Value injected by FXMLLoader

    @FXML // fx:id="bologna"
    protected ImageView bologna; // Value injected by FXMLLoader

    @FXML // fx:id="firenze"
    protected ImageView firenze; // Value injected by FXMLLoader

    @FXML // fx:id="ancona"
    protected ImageView ancona; // Value injected by FXMLLoader

    @FXML // fx:id="perugia"
    protected ImageView perugia; // Value injected by FXMLLoader

    @FXML // fx:id="roma"
    protected ImageView roma; // Value injected by FXMLLoader

    @FXML // fx:id="laquila"
    protected ImageView laquila; // Value injected by FXMLLoader

    @FXML // fx:id="campobasso"
    protected ImageView campobasso; // Value injected by FXMLLoader

    @FXML // fx:id="napoli"
    protected ImageView napoli; // Value injected by FXMLLoader

    @FXML // fx:id="bari"
    protected ImageView bari; // Value injected by FXMLLoader

    @FXML // fx:id="potenza"
    protected ImageView potenza; // Value injected by FXMLLoader

    @FXML // fx:id="catanzaro"
    protected ImageView catanzaro; // Value injected by FXMLLoader

    @FXML // fx:id="palermo"
    protected ImageView palermo; // Value injected by FXMLLoader

    @FXML // fx:id="cagliari"
    protected ImageView cagliari; // Value injected by FXMLLoader
    
    @FXML // fx:id="choiceBox"
    protected ChoiceBox<String> choiceBox; // Value injected by FXMLLoader
    
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
    
    protected void commonInitializeOperations() {
        assert torino != null : "fx:id=\"torino\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert aosta != null : "fx:id=\"aosta\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert genova != null : "fx:id=\"genova\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert milano != null : "fx:id=\"milano\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert trento != null : "fx:id=\"trento\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert trieste != null : "fx:id=\"trieste\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert venezia != null : "fx:id=\"venezia\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert bologna != null : "fx:id=\"bologna\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert firenze != null : "fx:id=\"firenze\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert ancona != null : "fx:id=\"ancona\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert perugia != null : "fx:id=\"perugia\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert roma != null : "fx:id=\"roma\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert laquila != null : "fx:id=\"laquila\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert campobasso != null : "fx:id=\"campobasso\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert napoli != null : "fx:id=\"napoli\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert bari != null : "fx:id=\"bari\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert potenza != null : "fx:id=\"potenza\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert catanzaro != null : "fx:id=\"catanzaro\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert palermo != null : "fx:id=\"palermo\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert cagliari != null : "fx:id=\"cagliari\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        
        for(Cities city:Cities.values())
        {
        	list.add(city.nome);
        }
        choiceBox.setItems(this.list);

    }

}
