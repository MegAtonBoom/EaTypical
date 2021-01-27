package logic.controller.guicontroller.ScheduleTrip;

/**
 * Sample Skeleton for 'ProvaTabellaBottone.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

	private ObservableList<Data> ol;
	private Data lc;
	private Data mf;
	private Data fr;
	
	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tabella"
    private TableView<Data> tabella; // Value injected by FXMLLoader

    @FXML // fx:id="colonnaBottone"
    private TableColumn<Data, Button> colonnaBottone; // Value injected by FXMLLoader

    @FXML // fx:id="colonnaNome"
    private TableColumn<Data, String> colonnaNome; // Value injected by FXMLLoader

    @FXML // fx:id="bottoneLoad"
    private Button bottoneLoad; // Value injected by FXMLLoader

    @FXML
    void load(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tabella != null : "fx:id=\"tabella\" was not injected: check your FXML file 'ProvaTabellaBottone.fxml'.";
        assert colonnaBottone != null : "fx:id=\"colonnaBottone\" was not injected: check your FXML file 'ProvaTabellaBottone.fxml'.";
        assert colonnaNome != null : "fx:id=\"colonnaNome\" was not injected: check your FXML file 'ProvaTabellaBottone.fxml'.";
        assert bottoneLoad != null : "fx:id=\"bottoneLoad\" was not injected: check your FXML file 'ProvaTabellaBottone.fxml'.";
        
        lc = new Data("Capotombolo", "Luca");
        mf = new Data("Fanfarillo", "Matteo");
        fr = new Data("Romersi", "Federico");
        Data[] array = new Data[3];
        array[0]=lc;
        array[1]=mf;
        array[2]=fr;
        ol = FXCollections.observableArrayList();
        for(int i=0; i<3; i++) {
        	ol.add(array[i]);
        }
        colonnaBottone.setCellValueFactory(new PropertyValueFactory<Data,Button>("button"));
        colonnaNome.setCellValueFactory(new PropertyValueFactory<Data,String>("cognomeString"));
        
        tabella.setItems(ol);
    }
}

