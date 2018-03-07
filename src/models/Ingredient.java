package models;

import java.io.Serializable;

import enums.ItemType;
import enums.VolumeType;
import enums.WeightType;

public class Ingredient implements  Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double quantity;
	private VolumeType volumeType;
	private WeightType weightType;
	private ItemType itemType;

	public Ingredient(String name, double quantity, VolumeType volumeType, WeightType weightType, ItemType itemType) {
		this.name = name;
		this.quantity = quantity;
		this.volumeType = volumeType;
		this.weightType = weightType;
		this.itemType = itemType;
	}
	
	public Ingredient(String name, Double quantity, String unitType) {
		setName(name);
		setQuantity(quantity);
		//"Whole", "Quart", "Cup(s)", "Tbsp", "tsp", "mL", "fl. oz."
		if(unitType.equals("Whole")) {
			volumeType = VolumeType.WHOLE;
		}else if(unitType.equals("Quart")) {
			volumeType = VolumeType.QUART;
		}else if(unitType.equals("Cup(s)")) {
			volumeType = VolumeType.CUP;
		}else if(unitType.equals("Tbsp")) {
			volumeType = VolumeType.TABLESPOON;
		}else if(unitType.equals("tsp")) {
			volumeType = VolumeType.TEASPOON;
		}else if(unitType.equals("mL")) {
			volumeType = VolumeType.MILLILITER;
		}else if(unitType.equals("fl. oz.")) {
			volumeType = VolumeType.FLUIDOUNCE;
		}else {
			throw new IllegalArgumentException("Check the Combo Box if this exception was thrown.");
		}
	}

	public String getName() {
		return name;
	}

	public VolumeType getVolumeType() {
		return volumeType;
	}

	public void setVolumeType(VolumeType volumeType) {
		this.volumeType = volumeType;
	}

	public WeightType getWeightType() {
		return weightType;
	}

	public void setWeightType(WeightType weightType) {
		this.weightType = weightType;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getWeight() {
		double b = 0;
		return b;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", quantity=" + quantity + ", volumeType=" + volumeType + ", weightType="
				+ weightType + ", itemType=" + itemType + "]";
	}
	
	
}
