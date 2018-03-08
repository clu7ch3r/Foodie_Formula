package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManager {

	public void saveFile() {
		
		String saveFile = "Formula.txt";
		// Recipe recipe = new Recipe();
		try {
			FileOutputStream fos = new FileOutputStream(saveFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// oos.writeObject(Recipe.class);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadFile() {
		
		try {
			FileInputStream fis = new FileInputStream("Formula.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			// ois.readObject(Recipe.class);
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// } catch (IOException e) {
// System.out.println("Cmon dude, you just got an IOException .l.");
// } catch (ClassNotFoundException e) {
// System.out.println("Class not found");
// }
