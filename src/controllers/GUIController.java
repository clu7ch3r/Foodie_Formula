package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import models.Ingredient;

public class GUIController implements Initializable {

	@FXML
	private TableView<Ingredient> recipeTable;

	@FXML
	private TableColumn<Ingredient, Double> amountTabCol;

	@FXML
	private TableColumn<Ingredient, String> unitTabCol;

	@FXML
	private TableColumn<Ingredient, String> ingredientTabCol;

	@FXML
	private ComboBox<String> unitComboBox;

	@FXML
	private TextField ingredientTextField;

	@FXML
	private Spinner<Double> amountSpinner = new Spinner<Double>(0, 100, 0);

	@FXML
	private Button ingredientButton;

	@FXML
	private TableView<String> shoppingListTable;

	@FXML
	private TextField recipeNameField;

	@FXML
	private TextArea recipeInsructionsField;

	@FXML
	private Button saveRecipeButton;

	@FXML
	private Button convertButton;

	@FXML
	private TextField searchField;

	@FXML
	private Button searchButton;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		unitComboBox.getItems().addAll("Whole", "Quart", "Cup(s)", "Tbsp", "tsp", "mL", "fl. oz.");
		unitComboBox.setPromptText("-Unit-");

		amountSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 0));

		ingredientButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				String unitType = unitComboBox.getValue();
				Double amount = amountSpinner.getValue();
				String name = ingredientTextField.getText();
				
				Ingredient tmp = new Ingredient(name,amount,unitType);
				recipeTable.getItems().add(tmp);
				
			}
		});
		saveRecipeButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// This method should save the recipes to the recipe box
			}
		});

		convertButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				// This method should convert the recipe into the shopping list.
			}
		});

		searchButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				String searchString = searchField.getText();
				// This is the method for search for recipes
			}
		});

	}

}
