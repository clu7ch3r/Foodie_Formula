package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable{
	ArrayList<ingredient> ingredients = new ArrayList<>();
	String name;
	String instructions;
	
	
	public Recipe(String name, String instructions, ArrayList<models.ingredient> ingredient) {
		this.name = name;
		this.instructions = instructions;
		this.ingredient = ingredient;
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
	public ArrayList<ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recipe title: ");
		builder.append(name);
		builder.append(", Cooking Instructions: ");
		builder.append(instructions);
		return builder.toString();
	}
	
	
	

}
