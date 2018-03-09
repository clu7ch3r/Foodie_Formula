package controllers;	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import utilities.FileManager;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
		try {
			FileManager.loadFile();
			GridPane root = FXMLLoader.load(getClass().getResource("FXML-FFormula.fxml"));
			
			Scene scene = new Scene(root,1000,650);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			stage.getIcons().add(new Image("file:FoodiesFormulaplatter.jpg"));
			stage.setOnCloseRequest(event -> {
				FileManager.saveFile();
			});
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Foodie's Formula");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
