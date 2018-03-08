package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import enums.ItemType;
import enums.VolumeType;
import enums.WeightType;
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
	private TableColumn<Ingredient, ItemType> formTabCol;

	@FXML
	private ComboBox<VolumeType> unitComboBox;

	@FXML
	private ComboBox<ItemType> formComboBox;

	@FXML
	private TextField ingredientTextField;

	@FXML
	private Spinner<Double> amountSpinner = new Spinner<Double>(0, 100, 0);

	@FXML
	private Button ingredientButton;

	@FXML
	private TableView<Ingredient> shoppingListTable;

	@FXML
	private TableColumn<Ingredient, String> shopIngredList;

	@FXML
	private TableColumn<Ingredient, WeightType> shopWeightTabCol;

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
		ingredientTabCol.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("name"));
		unitTabCol.setCellValueFactory(new PropertyValueFactory<Ingredient, VolumeType>("volumeType"));
		formTabCol.setCellValueFactory(new PropertyValueFactory<Ingredient, ItemType>("itemType"));

		formComboBox.getItems().addAll(ItemType.values());
		formComboBox.setValue(ItemType.CHOOSE);

		unitComboBox.getItems().addAll(VolumeType.values());
		unitComboBox.setValue(VolumeType.CHOOSE);

		amountSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 0));

		ingredientButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				ItemType form = formComboBox.getValue();
				VolumeType unitType = unitComboBox.getValue();
				double amount = amountSpinner.getValue();
				String name = ingredientTextField.getText();

				if (name.isEmpty() || amount == 0 || unitType.equals(VolumeType.CHOOSE)
						|| form.equals(ItemType.CHOOSE)) {

				} else {
					Ingredient tmp = new Ingredient(name, amount, unitType, form);
					recipeTable.getItems().add(tmp);
					ingredientTextField.setText("");
					amountSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 0));
					unitComboBox.setValue(VolumeType.CHOOSE);
					formComboBox.setValue(ItemType.CHOOSE);
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

				if (name.isEmpty() || Inscruction.isEmpty() || ingred.isEmpty()) {

				} else {

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
