package controllers;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import models.Recipe;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	
	ArrayList<Recipe> recipeBox = new ArrayList<>();
	
	@Override
	public void start(Stage stage) {
		try {
			GridPane root = FXMLLoader.load(getClass().getResource("FXML-FFormula.fxml"));
			
			Scene scene = new Scene(root,1000,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Red Rum Inc. Red Rum Inc. Red Rum Inc. Red Rum Inc. Red Rum Inc.");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
