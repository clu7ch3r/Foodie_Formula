package models;

import java.io.Serializable;

import enums.ItemType;
import enums.VolumeType;
import enums.WeightType;

public class Ingredient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double quantity;
	private double weight = -1;
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

	public Ingredient(String name, Double quantity, VolumeType unitType, ItemType form) {
		setName(name);
		setQuantity(quantity);
		setVolumeType(unitType);
		setItemType(form);
		// this if allows the ingredient to know what weight to use based upon if it is a solid or a liquid
		if (form.equals(ItemType.LIQUID) || form.equals(ItemType.LIQUIDSOLID)) {
			setWeightType(WeightType.OUNCE);
		} else {
			setWeightType(WeightType.GRAM);
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
		if (weight == -1) {
			throw new java.lang.Error(
					"Weight hasn't been converted yet, try calling convertVolumeToWeight with Ingredients as parameter.");
		}
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name: ");
		builder.append(name);
		builder.append(", ");
		builder.append("Quantity: ");
		builder.append(quantity);
		builder.append(", ");
		builder.append("Volume Type: ");
		builder.append(volumeType);
		builder.append(", ");
		builder.append("Weight Type: ");
		builder.append(weightType);
		builder.append(", ");
		builder.append("Item Type: ");
		builder.append(itemType);
		return builder.toString();
	}
}
