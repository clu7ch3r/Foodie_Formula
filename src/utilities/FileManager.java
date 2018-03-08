package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import models.Recipe;

public class FileManager {

	ArrayList<Recipe> recipeBox = new ArrayList<>();

	public void saveFile() {

		String saveFile = "Formula.txt";

		try {
			FileOutputStream fos = new FileOutputStream(saveFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(recipeBox);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			throw new java.lang.Error("File not found");
		} catch (IOException e) {
			throw new java.lang.Error("IOException");
		}
	}

	public void loadFile() {

		try {
			FileInputStream fis = new FileInputStream("Formula.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			@SuppressWarnings({ "unchecked", "unused" })
			ArrayList<Recipe> recipeBox = (ArrayList<Recipe>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			throw new java.lang.Error("File not found.");
		} catch (ClassNotFoundException e) {
			throw new java.lang.Error("Class not found.");
		} catch (IOException e) {
			throw new java.lang.Error("IOException.");
		}
	}
}
