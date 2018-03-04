package models;

import java.io.Serializable;
import java.util.ArrayList;
import models.Ingredient;

public class Recipe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Ingredient> ingredients = new ArrayList<>();
	private String name;
	private String instructions;

	public Recipe(String name, String instructions, ArrayList<models.Ingredient> ingredient) {
		this.name = name;
		this.instructions = instructions;
		this.ingredients = ingredient;
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

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recipe Title: ");
		builder.append(name);
		builder.append("Ingredients: ");
		builder.append(ingredients);
		builder.append(", Cooking Instructions: ");
		builder.append(instructions);
		return builder.toString();
	}

}
