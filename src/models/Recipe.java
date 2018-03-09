package models;

import java.io.Serializable;
import javafx.collections.ObservableList;
import models.Ingredient;

public class Recipe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ObservableList<Ingredient> ingredients;
	private String name;
	private String instructions;

	public Recipe(String name, String instructions, ObservableList<Ingredient> ingreds) {
		this.name = name;
		this.instructions = instructions;
		this.ingredients = ingreds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public ObservableList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ObservableList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recipe: ");
		builder.append(name);
		builder.append(", ");
		builder.append("Ingredients: ");
		builder.append(ingredients);
		builder.append(", ");
		builder.append("Cooking Instructions: ");
		builder.append(instructions);
		return builder.toString();
	}
}
