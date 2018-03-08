package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import enums.VolumeType;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Ingredient;

public class GUIController implements Initializable {

	@FXML
	private TableView<Ingredient> recipeTable;

	@FXML
	private TableColumn<Ingredient, Double> amountTabCol;

	@FXML
	private TableColumn<Ingredient, VolumeType> unitTabCol;

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

		amountTabCol.setCellValueFactory(new PropertyValueFactory<Ingredient, Double>("quantity"));
		;
		ingredientTabCol.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("name"));
		;
		unitTabCol.setCellValueFactory(new PropertyValueFactory<Ingredient, VolumeType>("volumeType"));
		;

		unitComboBox.getItems().addAll("Whole", "Quart", "Cup(s)", "Tbsp", "tsp", "mL", "fl. oz.");
		unitComboBox.setPromptText("-Unit-");

		amountSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 0));

		ingredientButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				String unitType = unitComboBox.getValue();
				double amount = amountSpinner.getValue();
				String name = ingredientTextField.getText();

				if (name.isEmpty() || amount == 0 || unitType.isEmpty()) {

				} else {
					Ingredient tmp = new Ingredient(name, amount, unitType);
					recipeTable.getItems().add(tmp);
					ingredientTextField.setText("");
					amountSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 0));
					unitComboBox.setValue(unitComboBox.getPromptText());
				}
			}
		});
		
		saveRecipeButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				String name = recipeNameField.getText();
				String Inscruction = recipeInsructionsField.getText();
				@SuppressWarnings("unchecked")
				ArrayList<Ingredient> ingred = (ArrayList<Ingredient>) recipeTable.getItems();
				
				if(name.isEmpty() || Inscruction.isEmpty() || ingred.isEmpty()) {
					
				}else {
					
				}
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
