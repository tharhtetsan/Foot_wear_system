package Footwear;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadDataFromFile {
	ReadDataFromFile(){}
	public static String getInventoryArray() throws FileNotFoundException, IOException {

		String str = "";
		try (DataInputStream input = new DataInputStream(new FileInputStream("inventoryfile.txt"))) {

			while (true) {
				for (int j = 0; j < 11; j++) {
					str += input.readUTF() + "#";
				}
				str = str + "@";
			}
		} catch (Exception e) {

		}

		return str;
	}
	public static String getSaleArray() throws FileNotFoundException, IOException {

		String str = "";
		try (DataInputStream input = new DataInputStream(new FileInputStream("salefile.txt"))) {

			while (true) {
				for (int j = 0; j < 11; j++) {
					str += input.readUTF() + ",";
				}
				str = str + "!";
			}
		} catch (Exception e) {

		}

		return str;
	}
	public static void main(String[]args) throws FileNotFoundException, IOException{
		//System.out.print(getInventoryArray());
		System.out.println(getSaleArray());
	}

}
