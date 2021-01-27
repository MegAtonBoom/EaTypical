package logic.controller.guicontroller.ScheduleTrip;


import javafx.scene.control.Button;

public class Data {
	private Button button;
	private String cognomeString;
	
	public Data(String cognome,String nome) {		
		this.cognomeString = cognome;
		this.button = new Button(nome);
	}

	
	public Button getButton() {
		return button;
	}


	public void setButton(Button button) {
		this.button = button;
	}


	public String getCognomeString() {
		return cognomeString;
	}

	public void setCognomeString(String cognomeString) {
		this.cognomeString = cognomeString;
	}
	
	
}
