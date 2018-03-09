package utilities;

import java.util.HashMap;
import enums.ItemType;
import enums.VolumeType;
import enums.WeightType;
import javafx.collections.ObservableList;
import models.Ingredient;

public class Converter {

	private static HashMap<VolumeType, Double> volToCup = new HashMap<VolumeType, Double>();
	private static HashMap<ItemType, Double> typeToGrams = new HashMap<ItemType, Double>();
	private static HashMap<WeightType, Double> weightToGrams = new HashMap<WeightType, Double>();

	static { // called once and hardset variables

		// Populate volToCup
		volToCup.put(VolumeType.CUP, 1d);
		volToCup.put(VolumeType.QUART, 4d);
		volToCup.put(VolumeType.FLUIDOUNCE, 1d / 8);
		volToCup.put(VolumeType.TABLESPOON, 1d / 16);
		volToCup.put(VolumeType.TEASPOON, 1d / 48);
		volToCup.put(VolumeType.MILLILITER, 1d / 236.6);

		// Populate typeToGrams (Cup Based)
		typeToGrams.put(ItemType.WHOLE, 1d);
		typeToGrams.put(ItemType.FINEPOWDER, 140d);
		typeToGrams.put(ItemType.GRAIN, 150d);
		typeToGrams.put(ItemType.GRANULAR, 190d);
		typeToGrams.put(ItemType.LIQUIDSOLID, 200d);
		typeToGrams.put(ItemType.LIQUID, 240d);

		// Populate weightToGrams (Gram Based)
		weightToGrams.put(WeightType.POUND, 0.002205);
		weightToGrams.put(WeightType.OUNCE, 0.03527);
		weightToGrams.put(WeightType.GRAM, 1d);
	}

	public static double convertVolumeToWeight(Ingredient ingredient) {

		double totalweight = ingredient.getQuantity() * convertVolumeToWeight(ingredient.getVolumeType(),
				ingredient.getItemType(), ingredient.getWeightType());

		ingredient.setWeight(totalweight);

		return totalweight;
	}

	public static double convertVolumeToWeight(VolumeType vType, ItemType iType, WeightType wType) {

		double vol = volToCup.get(vType);
		double item = typeToGrams.get(iType);
		double weight = weightToGrams.get(wType);
		double totalweight = vol * item * weight;

		return totalweight;
	}

	public static ObservableList<Ingredient> convertedIngredients(ObservableList<Ingredient> tmp) {

		for (int x = 0; x < tmp.size(); x++) {
			double w = convertVolumeToWeight(tmp.get(x));
			tmp.get(x).setWeight(w);
		}
		return tmp;
	}
}
