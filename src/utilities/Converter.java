package utilities;

import java.util.HashMap;

import enums.ItemType;
import enums.VolumeType;
import enums.WeightType;
import models.Ingredient;

public class Converter {

	private static HashMap<VolumeType, Double> volToCup = new HashMap<>();
	private static HashMap<ItemType, Double> typetoGrams = new HashMap<>();
	private static HashMap<WeightType, Double> weightToGrams = new HashMap<>();

	// missing contructor

	public static HashMap<VolumeType, Double> getVolToCup() {
		return volToCup;
	}

	public static void setVolToCup(HashMap<VolumeType, Double> volToCup) {
		Converter.volToCup = volToCup;
	}

	public static HashMap<ItemType, Double> getTypetoGrams() {
		return typetoGrams;
	}

	public static void setTypetoGrams(HashMap<ItemType, Double> typetoGrams) {
		Converter.typetoGrams = typetoGrams;
	}

	public static HashMap<WeightType, Double> getWeightToGrams() {
		return weightToGrams;
	}

	public static void setWeightToGrams(HashMap<WeightType, Double> weightToGrams) {
		Converter.weightToGrams = weightToGrams;
	}

	public double convertVolumeToWeight(Ingredient ingredients) {
		// logic
		return 0;
	}

	public double convertVolumeToWeight(VolumeType vType, ItemType iType, WeightType wType) {
		// logic
		return 0;

	}
}
