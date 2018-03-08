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

	public static ArrayList<Recipe> recipeBox = new ArrayList<>();

<<<<<<< HEAD
	public static void saveFile() {

=======
	public void saveFile() throws ClassNotFoundException {
>>>>>>> d988fc805eff3715ad272d607278f3de853d5d6d
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

<<<<<<< HEAD
	public static void loadFile() {

=======
	public void loadFile() {
>>>>>>> d988fc805eff3715ad272d607278f3de853d5d6d
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
