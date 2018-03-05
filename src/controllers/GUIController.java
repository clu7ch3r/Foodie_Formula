package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GUIController implements Initializable{

    @FXML
    private TableView<String> recipeTable;

    @FXML
    private ComboBox<String> unitComboBox;

    @FXML
    private TextField ingredientTextField;

    @FXML
    private Spinner<Integer> amountSpinner;

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
		unitComboBox.getItems().addAll("Cup(s)", "Tsp", "tsp", "Quart","mL","fl. oz.");
		//add more units here to the ComboBox as we need them
	}

}

