package Main;

import Model.storeModel;
import View.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception
	{
		storeModel model = new storeModel();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../View/adder.fxml"));

		BorderPane view = loader.load();
		Controller cont = loader.getController();
		cont.setModel(model);
		
		Scene s = new Scene(view);
		stage.setScene(s);
		stage.show();
	}

	public static void main(String [] args) {
		launch(args);
	}
}
