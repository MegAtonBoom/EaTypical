package logic.view.standalone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/HomePageTouristView.fxml"));
		Parent rootParent = loader.load();
		Scene scene = new Scene(rootParent);
		arg0.setScene(scene);
		arg0.show();
		
	}

}
