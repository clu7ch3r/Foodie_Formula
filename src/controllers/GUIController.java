package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import utilities.Converter;
import utilities.FileManager;
import enums.ItemType;
import enums.VolumeType;
import enums.WeightType;
import javafx.collections.ObservableList;
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
import models.Recipe;

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
	private Spinner<Double> amountSpinner;

	@FXML
	private Button ingredientButton;

	@FXML
	private Button clearButton;

	@FXML
	private TableView<Ingredient> shoppingListTable;

	@FXML
	private TableColumn<Ingredient, String> shopIngredTabCol;

	@FXML
	private TableColumn<Ingredient, Double> shopAmountTabCol;

	@FXML
	private TableColumn<Ingredient, WeightType> shopWeightTabCol;

	@FXML
	private TextField recipeNameField;

	@FXML
	private TextArea recipeInstructionsField;

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

		shopIngredTabCol.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("name"));
		shopAmountTabCol.setCellValueFactory(new PropertyValueFactory<Ingredient, Double>("weight"));
		shopWeightTabCol.setCellValueFactory(new PropertyValueFactory<Ingredient, WeightType>("weightType"));

		amountTabCol.setCellValueFactory(new PropertyValueFactory<Ingredient, Double>("quantity"));
		ingredientTabCol.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("name"));
		unitTabCol.setCellValueFactory(new PropertyValueFactory<Ingredient, VolumeType>("volumeType"));
		formTabCol.setCellValueFactory(new PropertyValueFactory<Ingredient, ItemType>("itemType"));

		formComboBox.getItems().addAll(ItemType.values());
		formComboBox.setValue(ItemType.CHOOSE);

		unitComboBox.getItems().addAll(VolumeType.values());
		unitComboBox.setValue(VolumeType.CHOOSE);

		amountSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 0, 0.25));

		clearButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				recipeTable.getItems().clear();
			}
		});

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
					amountSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 0, 0.25));
					unitComboBox.setValue(VolumeType.CHOOSE);
					formComboBox.setValue(ItemType.CHOOSE);
				}
			}
		});

		saveRecipeButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				String name = recipeNameField.getText();

				String instructions = recipeInstructionsField.getText();

				@SuppressWarnings("unchecked")
				ArrayList<Ingredient> ingreds = (ArrayList<Ingredient>) recipeTable.getItems();

				if (name.isEmpty() || instructions.isEmpty() || ingreds.isEmpty()) {

				} else {
					Recipe tmp = new Recipe(name, instructions, ingreds);
					FileManager.recipeBox.add(tmp);
					recipeTable.getItems().clear();
					recipeNameField.setText("");
					recipeInstructionsField.setText("");

				}
			}
		});

		convertButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {

				ObservableList<Ingredient> tmp = recipeTable.getItems();
				if (tmp.isEmpty()) {

				} else {
					ObservableList<Ingredient> tmp2 = Converter.convertedIngredients(tmp);
					shoppingListTable.getItems().clear();
					shoppingListTable.getItems().addAll(tmp2);
				}
			}
		});

		searchButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				String searchString = searchField.getText();
				@SuppressWarnings("unused")
				Recipe oneAndDone;
				if (searchString.isEmpty()) {
					searchField.setText("You can't search unless you enter something.");
				} else {
					boolean isSuccues = false;
					int tmpCount = 0;
					for (int i = 0; i < FileManager.recipeBox.size(); i++) {
						Recipe tmp = FileManager.recipeBox.get(i);
						String tmp2 = tmp.getName();
						if (tmp2.contains(searchString)) {
							isSuccues = true;
							tmpCount++;
							if(tmpCount == 1) {
								oneAndDone = tmp;
							}
						}
					}
					if (isSuccues) {
						if(tmpCount > 1) {
							
						}else {
							
						}
					} else {
						searchField.setText("That name doesn't exist in your Recipe Box");
					}
				}
			}
		});

	}

}
