package models;

import java.io.Serializable;

import enums.ItemType;
import enums.VolumeType;
import enums.WeightType;

public class Ingredient implements  Serializable{
	
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
